package com.qa.shopkick.rest;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.Test;


/**
 * Created by mmadhusoodan on 10/27/15.
 */

public class TestLodgeMethods extends APIClient {

    private Logger log = Logger.getLogger(TestLodgeMethods.class);
    private static TestLodgeMethods instance;
    private String passed = "", failed = "", skipped = "";

    public static synchronized TestLodgeMethods getInstance() {

        if (instance == null) {
            instance = new TestLodgeMethods();
        }
        return instance;
    }


    public void getProjectsList() {
        String url = "https://shopkick.api.testlodge.com/v1/projects.json";
        try {
            jsonData = executeHttpGet(url);
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(jsonData);
            JSONObject levelObject = (JSONObject) obj;
            JSONArray projectArray = (JSONArray) levelObject.get("projects");
            for (int i = 0; i < projectArray.size(); i++) {
                JSONObject projectObject = (JSONObject) projectArray.get(i);
                log.info("SuiteId: " + projectObject.get("id").toString());
                log.info("SuiteName: " + projectObject.get("name").toString());
            }
        } catch (Exception e) {
            log.error(e);
        }
    }

    public void getTestSuiteFromProject(String projectId) {
        String url = "https://shopkick.api.testlodge.com/v1/projects/" + projectId + "/suites.json";
        try {
            jsonData = executeHttpPost(url);
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(jsonData);
            JSONObject levelObject = (JSONObject) obj;

            JSONArray suitesArray = (JSONArray) levelObject.get("suites");
            log.info("Suite Count: " + suitesArray.size());
            for (int i = 0; i < suitesArray.size(); i++) {
                JSONObject suiteObject = (JSONObject) suitesArray.get(i);
                log.info("SuiteId: " + suiteObject.get("id").toString() + ": SuiteName " + suiteObject.get("name").toString());
            }
        } catch (Exception e) {
            log.error(e);
        }
    }

    public void showTestSuiteDetails(String projectId, String suiteId) {
        String url = "https://shopkick.api.testlodge.com/v1/projects/" + projectId + "/suites/" + suiteId + ".json";
        try {
            jsonData = executeHttpGet(url);
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(jsonData);

            JSONObject suiteObject = (JSONObject) obj;
            //project_id
            log.info("SuiteId: " + suiteObject.get("id").toString() + ": SuiteName " + suiteObject.get("name").toString());
        } catch (Exception e) {
            log.error(e);
        }
    }

    public void showAllTestRunsFromProject(String projectId) {
        String url = "https://shopkick.api.testlodge.com/v1/projects/" + projectId + "/runs.json";
        try {
            jsonData = executeHttpGet(url);
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(jsonData);
            JSONObject levelObject = (JSONObject) obj;

            JSONArray suitesArray = (JSONArray) levelObject.get("runs");
            log.info("Suite Count: " + suitesArray.size());
            for (int i = 0; i < suitesArray.size(); i++) {
                JSONObject suiteObject = (JSONObject) suitesArray.get(i);
                log.info("RunId: " + suiteObject.get("id").toString() + ": SuiteName " + suiteObject.get("name").toString());
            }
        } catch (Exception e) {
            log.error(e);
        }
    }

    public void showTestRunsFromProjectAndRunId(String projectId, String runId) {
        String url = "https://shopkick.api.testlodge.com/v1/projects/" + projectId + "/runs/" + runId + ".json";
        //http://shopkick.testlodge.com/projects/10019/runs/175520
        try {
            jsonData = executeHttpGet(url);
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(jsonData);
            JSONObject levelObject = (JSONObject) obj;

            log.info("RunId: " + levelObject.get("id").toString() + ": SuiteName " + levelObject.get("name").toString());

            passed = levelObject.get("passed_number").toString();
            failed = levelObject.get("failed_number").toString();
            skipped = levelObject.get("skipped_number").toString();
            log.info("passed_number: " + levelObject.get("passed_number").toString() + ": failed_number " + levelObject.get("failed_number").toString());

        } catch (Exception e) {
            log.error(e);
        }
    }

    public void createTestCases(String projectId, String suiteId) {

        String url = "https://shopkick.api.testlodge.com/v1/projects/" + projectId + "/suites/" + suiteId + "/steps.json";
        try {
            jsonData = executeHttpPost(url);
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(jsonData);

            JSONObject suiteObject = (JSONObject) obj;
            log.info("SuiteId: " + suiteObject.get("id").toString() + ": SuiteName " + suiteObject.get("name").toString());

        } catch (Exception e) {
            log.error(e);
        }
    }

    @Test
    public void runMain() throws Exception {

        // Existing Project Id = 10019
        // Created Smoke Suite id = 58074
        //TestLodgeMethods.getInstance().showTestSuiteDetails("10019", "58074");

        TestLodgeMethods.getInstance().showTestRunsFromProjectAndRunId("10019", "175520");
    }
}
