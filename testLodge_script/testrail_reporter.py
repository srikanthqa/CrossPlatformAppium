#!/usr/bin/env python

##########################################
# TestRailReporter
#
##########################################
"""
Simple app using the TestRail API, provides bulk test-result reporting
"""
__author__ = 'manish'

import datetime
import getpass
import json
import optparse
import os
import sys
import testrail_api


class TestRailReporter(object):
    def __init__(self):
        # Allow caller to block actual operation in favor of "I would do" reporting
        self.dry_run = False

        # Load config info from user's home directory
        uname = getpass.getuser()
        config_path = "/Users/mmadhusoodan/workspace/CrossPlatformAppium/testLodge_script/.testLodgeCred.json"
        with open(config_path, 'r') as fh:
            contents = fh.read()
        user_config = json.loads(contents)

        # Init interface to the TestRail system
        self.testrail = testrail_api.TestRailApi("https://shopkick.api.testlodge.com/v1/", "manish@shopkick.com",
                                                 "shopkick123")


        # self.testrail = testrail_api.TestRailApi(user_config.get("TL_Base_URL"),
        #                                          user_config.get("TL_User_Name"),
        #                                          user_config.get("TL_User_PW"))

        print user_config.get("TL_User_Name");

        # Default Project, Suite, Section
        self.project_name = user_config.get("Default_Project_Name")
        self.suite_name = user_config.get("Default_Suite_Name")
        self.section_name = user_config.get("Default_Section_Name")

        # Default type used when creating cases
        self.default_case_type = user_config.get("Default_Case_Type")
        # Tester name (the name that will be the "reported by" in TestRail
        self.tester_name = user_config.get("Tester_Name")

        # List of result dicts we gather from results file
        self.results_list = []

    def set_dry_run(self, dry_run):
        self.dry_run = dry_run

    ###################
    #
    # Routines related to getting DB entity IDs
    #
    ###################

    def __get_id_from_dict(self, in_dict):
        ret_val = None
        if in_dict:
            ret_val = in_dict.get("id")
        return ret_val

    def get_case_id_for_title(self, title):
        """
        Search for case with target name and return associated ID, or None if not found.
        @param title:
        """
        case = self.testrail.get_case_by_title(title, self.project_id, self.suite_id, self.section_id)
        return self.__get_id_from_dict(case)

    def get_section_id_for_name(self, name):
        """
        Search for section with target name and return associated ID, or None if not found.
        @param name: Target section name
        """
        section = self.testrail.get_section_by_name(name, self.project_id, self.suite_id)
        return self.__get_id_from_dict(section)

    def get_suite_id_for_name(self, name):
        """
        Search for suite with target name and return associated ID, or None if not found.
        @param name: Target suite name
        """
        suite = self.testrail.get_suite_by_name(name, self.project_id)
        return self.__get_id_from_dict(suite)

    def get_project_id_for_name(self, name):
        """
        Search for project with target name and return associated ID, or None if not found.
        @param name: Target project name
        """
        project = self.testrail.get_project_by_name(name)
        return self.__get_id_from_dict(project)

    ###################
    #
    # Routines related to creating DB entities
    #
    ###################

    def create_case(self, title):
        """
        Add a new case to a TestRail Project:Suite:Section
        @param title: Case title
        """
        response_data = self.testrail.add_case(title, self.section_id, self.default_case_type)
        case_id = response_data.get("id")
        return case_id

    def create_section(self, name):
        """
        Add a new section to a TestRail Project:Suite
        @param name: new section name
        """
        response_data = self.testrail.add_section(name, self.project_id, self.suite_id)
        return response_data.get("id")

    def create_suite(self, name, description=None):
        """
        Add a new suite to a TestRail Project
        @param name: new section name
        @param description: Optional suite description
        """
        response_data = self.testrail.add_suite(name, self.project_id, description)
        return response_data.get("id")

    def create_run(self, name, description=None, case_ids=None):
        """
        Add a new suite to a TestRail Project
        @param description: Optional suite description
        @param case_ids: Optional list of case IDs in the run. If omitted, run assumes all cases in suite
        """
        response_data = self.testrail.add_run(name, self.project_id, self.suite_id, description, case_ids)
        return response_data.get("id")

    ###################
    #
    # Highest-level routines
    #
    ###################

    def process_report_file(self, report_file):
        """
        Read report into useful dicts.
        @param report_file: Path to file containing test results
        """
        with open(report_file, 'r') as fh:
            report = fh.read()
        self.report_dict = json.loads(report)
        self.results_list = self.report_dict.get("resultsList")

    def check_project(self, project_name):
        """
        Allow override of project name. Check TestRail for existence of project--if none, abort.
        (Would be easy-enough to create projects, but I'm assuming we want to avoid automated project creation.)
        @param project_name:
        @return: nothing
        """
        # Default Project name may come from user's config file
        # Allow call-time override
        if project_name:
            self.project_name = project_name
        self.project_id = self.get_project_id_for_name(self.project_name)
        if not self.project_id:
            print "No valid project_id provided"
            sys.exit(-1)

    def check_suite(self, suite_name):
        """
        Allow override of suite name. Check TestRail for existence of suite--if none, create it.
        @param suite_name:
        @return: nothing
        """
        # Default Suite name may come from from user's config file
        # That would be overridden by a suite name provided in the report
        self.suite_name = self.report_dict.get("suiteName", self.suite_name)
        # Finally, caller can override
        self.suite_name = suite_name or self.suite_name
        if not self.suite_name:
            print "No suite name was provided."
            sys.exit(-1)

        if self.dry_run:
            print "Would check TestRail for suite name %s" % self.suite_name
        self.suite_id = self.get_suite_id_for_name(self.suite_name)
        if not self.suite_id:
            if self.dry_run:
                print "Would create a new test suite: %s" % self.suite_name
            else:
                self.suite_id = self.create_suite(self.suite_name)
                if not self.suite_id:
                    print "Failed to create new suite: %s" % self.suite_name
                    sys.exit(-1)

    def check_section(self, section_name):
        """
        Allow override of section name. Check TestRail for existence of section--if none, create it.
        @param section_name:
        @return: nothing
        """
        # Default Section name may come from user's config file
        # Allow call-time override
        self.section_name = section_name or self.section_name
        if self.dry_run:
            print "Would check TestRail for section name %s" % self.section_name
        if not self.section_name:
            print "No section name was provided."
            sys.exit(-1)
        self.section_id = self.get_section_id_for_name(self.section_name)
        if not self.section_id:
            if self.dry_run:
                print "Would create a new section in TestRail: %s" % self.section_name
            else:
                self.section_id = self.create_section(self.section_name)
                if not self.section_id:
                    print "Failed to create new section: %s" % self.section_name
                    sys.exit(-1)

    def check_testcases(self):
        """
        Make sure every case reported exists in the target suite, and get the ID for each.
        """
        for item in self.results_list:
            case_name = item.get("testName")
            if self.dry_run:
                print "Would check TestRail for test case %s" % case_name
            run_status = item.get("runStatus")
            assert run_status, "Malformed result entry with case_name %s" % case_name
            case_id = self.get_case_id_for_title(case_name)
            if not case_id:
                if self.dry_run:
                    print "Would create new test case in TestRail: %s" % case_name
                else:
                    case_id = self.create_case(case_name)
                    assert case_id, "Failed to create new case: %s" % case_name

    def get_case_from_result_list(self, case_name):
        """
        Search dicts in results list for one which includes a specified value in the 'testName' field
        If found, return that dict. Else return None.
        """
        ret_val = None
        try:
            for item in self.results_list:
                if item.get("testName") == case_name:
                    ret_val = item
                    break
        except:
            pass
        return ret_val

    def post_results_to_run(self, override_name=None):
        """
        Upload run results for all cases
        @param override_name: Run name to use. Will override any name in report file
        @return:
        """
        run_name = override_name or self.report_dict.get("reportName")
        if not run_name:
            print "No run name provided"
            sys.exit(-1)
        run_id = self.create_run(run_name)
        all_tests_in_run = self.testrail.get_tests(run_id)
        for test in all_tests_in_run:
            try:
                test_id = test.get("id")
                case_title = test.get("title")
                case_dict = self.get_case_from_result_list(case_title)
                status_id = self.testrail.id_for_status[case_dict.get("runStatus")]
                elapsed_time = case_dict.get("elapsed")
                self.testrail.add_result(test_id, status_id, elapsed_time)
            except AttributeError:
                print "WARNING: Failed to get result information for test '%s'. Perhaps that test was not run this time?" % case_title
        self.testrail.close_run(run_id)

###################
#
# Standalone app
#
###################

if __name__ == '__main__':

    parser = optparse.OptionParser(usage='Usage: %prog <options> <input_file>')
    # Suite name can be specified as any arbitrary string, but will generally reflect target OS
    parser.add_option('-a', '--android', action="append_const", const="AgentLibFuncTest_Android",
                      dest='suite_name', help="Shortcut: report suite named for Android")
    parser.add_option('-i', '--ios', action="append_const", const="AgentLibFuncTest_iOS",
                      dest='suite_name', help="Shortcut: report suite named for iOS")
    parser.add_option('-m', '--mac', action="append_const", const="AgentLibFuncTest_MacOS",
                      dest='suite_name', help="Shortcut: report suite named for MacOS")
    parser.add_option('-w', '--windows', action="append_const", const="AgentLibFuncTest_Windows",
                      dest='suite_name', help="Shortcut: report suite named for Windows")
    parser.add_option('-s', '--suite', action="append", default=None,
                      dest='suite_name', help="Name of suite you're reporting")

    parser.add_option('-p', '--project', action="store", default=None,
                      dest='project_name', help="Name of project you're reporting")
    parser.add_option('-c', '--section', action="store", default=None,
                      dest='section_name', help="Name of section you're reporting")

    parser.add_option('-r', '--run', action="store", default=None,
                      dest='run_name', help="Name of run you're reporting")
    parser.add_option('-d', '--dryrun', action="count", default=0,
                      dest='dry_run', help="Don't actually report to TestRail, just report what _would_ happen")

    (opts, args) = parser.parse_args()

    suite_name = None
    if opts.suite_name:
        if len(opts.suite_name) > 1:
            print "Please specify only one suite. You specified %d:" % len(opts.suite_name)
            print opts.suite_name
            sys.exit(-1)
        suite_name = opts.suite_name[0]

    report_file = args[0]
    if not (os.path.exists(report_file)):
        print "Can't find specified input file path: %s" % report_file
        sys.exit(-1)

    run_name = opts.run_name

    # Initializing the reporter:
    # Reads config file, getting reporter name, username, password for TestRail,
    # and defaults for project name, tester name
    reporter = TestRailReporter()
    reporter.set_dry_run((opts.dry_run > 0))

    # Read input file, getting a list of case name:result pairs, suite info, etc
    reporter.process_report_file(report_file)

    # Prepare TestRail to receive this report, adding any needed Suites, Sections, Cases
    # If project doesn't exist, we fail out here.
    reporter.check_project(opts.project_name)
    reporter.check_suite(suite_name)
    reporter.check_section(opts.section_name)
    reporter.check_testcases()

    # Upload the run results
    if (opts.dry_run > 0):
        print "Would create new run in TestRail, and report test results"
    else:
        reporter.post_results_to_run(run_name)
