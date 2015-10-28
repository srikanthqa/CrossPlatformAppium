##########################################
# TestRailAPI
#
##########################################
"""
Provides access to TestRail web API
"""
__author__ = 'jblack'

import json
import requests


class TestRailApi(object):
    def __init__(self, base_url, user_name, user_password):
        self.base_url = base_url
        self.user_name = user_name
        self.user_password = user_password
        self.__populate_case_type_id_dict()
        self.__populate_status_id_dict()

    ###################
    #
    # Helper routines
    #
    ###################

    def __populate_status_id_dict(self):
        """
        Setup routine for self.id_for_status, dict that translates from status keyword to corresponding ID
        """
        self.id_for_status = {}
        response_json = self.get_statuses()
        for item in response_json:
            self.id_for_status[item["name"]] = item["id"]

    def __populate_case_type_id_dict(self):
        """
        Setup routine for self.id_for_case_type, dict that translates from case type keyword to corresponding ID
        """
        self.id_for_case_type = {}
        response_json = self.get_case_types()
        for item in response_json:
            self.id_for_case_type[item["name"]] = item["id"]

    def __get_dict_from_list_with_specified_kv_pair(self, source_json, target_key, target_value):
        """
        Search dicts in source_json for one which includes a specified k,v pair.
        If found, return the value in that dict's target_key. Else return None.
        Example: find the dict that has value "Foo" for the key "name"
        @param source_json: JSON (some request response) to search
        @param target_key: Key used as marker
        @param target_value: Value used as marker
        """
        ret_val = None
        try:
            for item in source_json:
                if item.get(target_key) == target_value:
                    ret_val = item
                    break
        except:
            pass
        return ret_val

    ###################
    #
    # HTTP routines
    #
    ###################

    def get_request(self, url_frag, additional_headers=None):
        """
        Encapsulates our HTTP GET requests
        @param url_frag: 
        @param additional_headers: 
        """
        the_url = self.base_url + url_frag
        headers = {'content-type': 'application/json'}
        if additional_headers:
            headers.update(additional_headers)
        response = requests.get(the_url,
                                headers=headers,
                                auth=(self.user_name, self.user_password),
                                verify=False)    # Prevent certificate problems
        return response.json()

    def post_request(self, url_frag, post_data_dict, additional_headers=None):
        """
        Encapsulates our HTTP POST requests
        @param url_frag: URL beyond the base_url
        @param post_data_dict: POST data
        @param additional_headers: Optional additional headers
        """
        the_url = self.base_url + url_frag
        headers = {'content-type': 'application/json'}
        if additional_headers:
            headers.update(additional_headers)
        post_data = json.dumps(post_data_dict, encoding="ISO-8859-1")
        response = requests.post(the_url,
                                 data=post_data,
                                 headers=headers,
                                 auth=(self.user_name, self.user_password),
                                 verify=False)    # Prevent certificate problems
        return response.json()

    ###################
    #
    # Routines related to cases
    #
    ###################

    def add_case(self, title, section_id, case_type_name=None):
        """
        Add a new case to a TestRail Project:Suite:Section
        @param title: Title for new test case
        @param section_id: Section ID
        @param case_type_name: Optional case type name (e.g. 'Automated', 'Regression', 'Performance'...)
        """
        url_frag = "add_case/%s" % section_id
        post_data_dict = {"title": title}
        if case_type_name:
            post_data_dict.update({"type_id": self.id_for_case_type[case_type_name]})
        return self.post_request(url_frag, post_data_dict)

    def delete_case(self, case_id):
        """
        Delete a case to a specified by ID
        @param case_id: ID of case to delete
        """
        url_frag = "delete_case/%s" % case_id
        post_data_dict = {}
        return self.post_request(url_frag, post_data_dict)

    def get_case(self, case_id):
        """
        Get case specified by ID
        @param case_id: ID of case of interest
        """
        return self.get_request("get_case/%s" % case_id)

    def get_case_by_title(self, title, project_id, suite_id, section_id):
        """
        Request case with specified title for specified project, suite, and section
        @param title: Case title
        @param project_id: Project ID
        @param suite_id: Suite ID
        @param section_id: Section ID
        """
        all_cases = self.get_cases(project_id, suite_id, section_id)
        return self.__get_dict_from_list_with_specified_kv_pair(all_cases, "title", title)

    def get_cases(self, project_id, suite_id, section_id):
        """
        Request list of cases for specified project, suite, and section
        @param project_id: Project ID
        @param suite_id: Suite ID
        @param section_id: Section ID
        """
        return self.get_request("get_cases/%s&suite_id=%s&section_id=%s" % (project_id, suite_id, section_id))

    def update_case(self, case_id, title=None, case_type_name=None):
        """
        Update a case specified by ID
        @param title: Title for test case
        @param case_type_name: Case type name (e.g. 'Automated', 'Regression', 'Performance'...)
        """
        url_frag = "update_case/%s" % case_id
        post_data_dict = {"title": title}
        if title:
            post_data_dict.update({"title": title})
        if case_type_name:
            post_data_dict.update({"type_id": self.id_for_case_type[case_type_name]})
        return self.post_request(url_frag, post_data_dict)

    ###################
    #
    # Routines related to case_types
    #
    ###################

    def get_case_types(self):
        """
        Request list of case types.
        """
        return self.get_request("get_case_types/")

    ###################
    #
    # Routines related to projects
    #
    ###################

    def add_project(self, is_completed=None, name=None, description=None):
        """
        Update a TestRail Project
        @param is_completed: Bool specifying whether or not a project is completed
        @param name: Name of project
        @param description: Description of project
        """
        url_frag = "add_project"
        post_data_dict = {}
        if is_completed:
            post_data_dict.update({"is_completed": is_completed})
        if name:
            post_data_dict.update({"name": name})
        if description:
            post_data_dict.update({"announcement": description, "show_announcement": True})
        return self.post_request(url_frag, post_data_dict)

    def get_project(self, project_id):
        """
        Get case specified by ID
        @param project_id: ID of project of interest
        """
        return self.get_request("get_project/%s" % project_id)

    def get_project_by_name(self, name):
        """
        Request section with specified name for specified project, suite, and section
        @param name: Project name
        """
        all_projects = self.get_projects()
        return self.__get_dict_from_list_with_specified_kv_pair(all_projects, "name", name)

    def get_projects(self):
        """
        Request list of projects.
        """
        return self.get_request("get_projects")

    def update_project(self, name=None, description=None):
        """
        Add a new case to a TestRail Project:Suite:Section
        @param name: Name for project
        @param description: Description of project
        """
        url_frag = "add_project"
        post_data_dict = {}
        if name:
            post_data_dict.update({"name": name})
        if description:
            post_data_dict.update({"announcement": description, "show_announcement": True})
        return self.post_request(url_frag, post_data_dict)

    def delete_project(self, project_id):
        """
        Delete project specified by ID
        @param project_id: ID of project to delete
        """
        url_frag = "delete_project/%s" % project_id
        post_data_dict = {}
        return self.post_request(url_frag, post_data_dict)

    ###################
    #
    # Routines related to results
    #
    ###################

    def add_result(self, test_id, status_id, elapsed=None):
        """
        Add a new test result
        @param test_id: Test ID
        @param status_id: Status ID of result (e.g. ID 1 = "passed", 2 = "blocked", 5 = "failed")
        @param elapsed: Elapsed time of test (sec)
        @return:
        """
        url_frag = "add_result/%s" % test_id
        post_data_dict = {"status_id": status_id}
        if elapsed:
            post_data_dict.update({"elapsed": elapsed})
        return self.post_request(url_frag, post_data_dict)

    def get_results(self, test_id, limit=None):
        """
        Request list of results for specified test ID
        @param test_id: ID of test of interest
        @param limit: Optional integer max number of results to return (latest first)
        """
        url_frag = "get_results/%s" % test_id
        if limit:
            url_frag += "&limit=%s" % limit
        return self.get_request(url_frag)

    def get_results_for_case(self, run_id, case_id, limit=None):
        """
        Request list of results for specified test run-and-case combination
        @param run_id: ID of test run of interest
        @param case_id: ID of case of interest
        @param limit: Optional integer max number of results to return (latest first)
        """
        url_frag = "get_results_for_case/%s/case_id/%s" % (run_id, case_id)
        if limit:
            url_frag += "&limit=%s" % limit
        return self.get_request(url_frag)

    ###################
    #
    # Routines related to runs
    #
    ###################

    def add_run(self, name, project_id, suite_id, description=None, case_ids=None):
        """
        Add a new run to a TestRail Project
        @param name: Name for new run
        @param project_id: Project ID
        @param suite_id: Suite ID
        @param description: Optional run description
        @param case_ids: Optional list of case ids--if not supplied, will assume all cases in suite
        """
        url_frag = "add_run/%s" % project_id
        post_data_dict = {"suite_id": suite_id, "name": name}
        if description:
            post_data_dict.update({"description": description})
        if case_ids:
            post_data_dict.update({"include_all": False, "case_ids": case_ids})
        return self.post_request(url_frag, post_data_dict)

    def get_run(self, run_id):
        """
        Get run specified by ID
        @param run_id: ID of run of interest
        """
        return self.get_request("get_run/%s" % run_id)

    def get_runs(self, project_id):
        """
        Request list of runs for specified project.
        @param project_id: Project ID containing runs of interest
        """
        return self.get_request("get_runs/%s" % project_id)

    def close_run(self, run_id):
        """
        Close run specified by ID and archive its tests & results. CANNOT BE UNDONE.
        @param run_id: ID of run of interest
        """
        post_data_dict = {}
        return self.post_request("close_run/%s" % run_id, post_data_dict)

    def delete_run(self, run_id):
        """
        Delete run specified by ID. Also permanently deletes all tests & results of the test run. CANNOT BE UNDONE.
        @param run_id: ID of run of interest
        """
        post_data_dict = {}
        return self.post_request("delete_run/%s" % run_id, post_data_dict)

    ###################
    #
    # Routines related to sections
    #
    ###################

    def add_section(self, name, project_id, suite_id):
        """
        Add a new section to a TestRail Project:Suite
        @param name: Name for new section
        @param project_id: Project ID
        @param suite_id: Suite ID
        """
        url_frag = "add_section/%s" % project_id
        post_data_dict = {"suite_id": suite_id, "name": name}
        return self.post_request(url_frag, post_data_dict)

    def get_section(self, section_id):
        """
        Request section specified by ID
        @param section_id: ID of section of interest
        """
        return self.get_request("get_section/%s" % section_id)

    def get_section_by_name(self, name, project_id, suite_id):
        """
        Request section with specified name for specified project, suite, and section
        @param name: Section name
        @param project_id: Project ID
        @param suite_id: Suite ID
        """
        all_sections = self.get_sections(project_id, suite_id)
        return self.__get_dict_from_list_with_specified_kv_pair(all_sections, "name", name)

    def get_sections(self, project_id, suite_id):
        """
        Request list of sections for specified project and suite
        @param project_id: Project ID
        @param suite_id: Suite ID
        """
        return self.get_request("get_sections/%s&suite_id=%s" % (project_id, suite_id))

    def update_section(self, section_id, name=None):
        """
        Update existing section specified by ID
        @param section_id: ID of section to update
        @param name: Name of section
        """
        url_frag = "update_section/%s" % section_id
        post_data_dict = {"name": name}
        return self.post_request(url_frag, post_data_dict)

    def delete_section(self, section_id):
        """
        Delete section specified by ID.
        Also permanently deletes all related test cases & unclosed tests and results. CANNOT BE UNDONE.
        @param section_id: ID of section of interest
        """
        post_data_dict = {}
        return self.post_request("delete_section/%s" % section_id, post_data_dict)

    ###################
    #
    # Routines related to statuses
    #
    ###################

    def get_statuses(self):
        """
        Request list of statuses.
        """
        return self.get_request("get_statuses/")

    ###################
    #
    # Routines related to suites
    #
    ###################

    def add_suite(self, name, project_id, description=None):
        """
        Add a new suite to a TestRail Project
        @param name: New suite name
        @param description: Optional suite description
        """
        url_frag = "add_suite/%s" % project_id
        post_data_dict = {"name": name}
        if description:
            post_data_dict.update({"description": description})
        return self.post_request(url_frag, post_data_dict)

    def get_suite(self, suite_id):
        """
        Request suite specified by ID
        @param suite_id: ID of suite of interest
        """
        return self.get_request("get_suite/%s" % suite_id)

    def get_suite_by_name(self, name, project_id):
        """
        Request suite with specified name in specified project
        @param name: Suite name
        @param project_id: Project ID
        """
        all_suites = self.get_suites(project_id)
        return self.__get_dict_from_list_with_specified_kv_pair(all_suites, "name", name)

    def get_suites(self, project_id):
        """
        Request list of suites for specified project
        @param project_id: Project ID
        """
        return self.get_request("get_suites/%s" % project_id)

    def update_suite(self, suite_id, name=None, description=None):
        """
        Update an existing suite
        @param name: Suite name
        @param description: Suite description
        """
        url_frag = "update_suite/%s" % suite_id
        post_data_dict = {}
        if name:
            post_data_dict.update({"name": name})
        if description:
            post_data_dict.update({"description": description})
        return self.post_request(url_frag, post_data_dict)

    def delete_suite(self, suite_id):
        """
        Delete suite specified by ID. Also permanently deletes all active test runs and results. CANNOT BE UNDONE.
        @param suite_id: ID of suite of interest
        """
        post_data_dict = {}
        return self.post_request("delete_suite/%s" % suite_id, post_data_dict)

    ###################
    #
    # Routines related to tests
    #
    ###################

    def get_test(self, test_id):
        """
        Request test specified by ID
        @param test_id: ID of test of interest
        """
        return self.get_request("get_test/%s" % test_id)

    def get_tests(self, run_id):
        """
        Request list of tests for specified run
        @param run_id: Run ID containing tests of interest
        """
        return self.get_request("get_tests/%s" % run_id)
