package com.qa.shopkick.rest;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import com.qa.shopkick.utils.QaCalendar;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static com.jayway.restassured.RestAssured.given;


public class RunTestCase {
    String projectID = "10019";
    String suiteId = "58074";
    private Logger log = Logger.getLogger(RunTestCase.class);

    public Integer getTestCaseID(String testCaseName) {
        HashMap<String, Integer> map = new HashMap<>();
        try {
            Response response = given().contentType(ContentType.URLENC).auth().basic("manish@shopkick.com", "shopkick123").expect().statusCode(200).
                    get("https://shopkick.api.testlodge.com/v1/projects/10019/runs/175520/executed_steps.json");
            Integer tpages = response.getBody().path("pagination.total_pages");
            ArrayList<Integer> tcid = new ArrayList<>();
            ArrayList<String> tcname = new ArrayList<>();
            for (int i = 1; i <= tpages; i++) {
                Response response1 = given().contentType(ContentType.URLENC).auth().basic("manish@shopkick.com", "shopkick123").expect().statusCode(200).
                        get("https://shopkick.api.testlodge.com/v1/projects/10019/runs/175520/executed_steps.json?page=" + i);
                ArrayList<Integer> temp_tid = response1.getBody().path("executed_steps.id");
                ArrayList<String> temp_tname = response1.getBody().path("executed_steps.step_number");
                tcid.addAll(temp_tid);
                tcname.addAll(temp_tname);
            }

            for (int j = 0; j < tcid.size(); j++) {
                map.put(tcname.get(j), tcid.get(j));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map.get(testCaseName);
    }


    public void setTestCaseStatus(String testCaseName, String testResult, String testRunId) {
        try {
            RequestSpecification request = null;
            if (testResult.equals("passed")) {
                request = given().contentType(ContentType.URLENC).with().parameters("executed_step[actual_result]", "Passed[Automation]", "executed_step[passed]", "1");
            } else if (testResult.equals("failed")) {
                request = given().contentType(ContentType.URLENC).with().parameters("executed_step[actual_result]", "Failed[Automation]", "executed_step[passed]", "0");
            }
            Integer testcase_id = getTestCaseID(testCaseName);
            //            testcase_id = 8617371;
            given(request).auth().basic("manish@shopkick.com", "shopkick123").expect().statusCode(200).
                    patch("https://shopkick.api.testlodge.com/v1/projects/10019/runs/" + testRunId + "/executed_steps/8617371.json");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void TestSetTestCaseStatus() {

        String testCaseName = "TC1200";
        String status = "passed";
        String testRunId = "175693";
        setTestCaseStatus(testCaseName, status, testRunId);
    }

    @Test
    public void TestGetTestCaseID() {
        Integer testcase_id = getTestCaseID("TC1173");
        log.info(testcase_id);

    }


    public String CreateTestRun() {

        try {
            String runName = "automated Test Run " + QaCalendar.getInstance().getDateTime();
            //https://shopkick.api.testlodge.com/v1/projects/10019/runs.json
            RequestSpecification request = given().contentType(ContentType.URLENC).with().
                    parameters("run[name]", runName, "run[plan_id]", "11001", "run[suite_ids][]", suiteId);
            Response resp = given(request).auth().basic("manish@shopkick.com", "shopkick123").expect().statusCode(201).
                    post("https://shopkick.api.testlodge.com/v1/projects/10019/runs.json");
            String runId = resp.getBody().path("id").toString();
            log.info(runId);
            return runId;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
