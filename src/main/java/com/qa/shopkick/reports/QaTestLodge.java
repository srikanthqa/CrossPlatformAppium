package com.qa.shopkick.reports;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import com.qa.shopkick.utils.QaCalendar;
import com.qa.shopkick.utils.QaConstants;
import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

import static com.jayway.restassured.RestAssured.given;

public class QaTestLodge {

    private Logger log = Logger.getLogger(QaTestLodge.class);
    private static String projectId = "10019";
    private String testLodgeUrl;
    private String username;
    private String password;

    public QaTestLodge() {
        JSONParser parser = new JSONParser();
        try {
            File file = new File(QaConstants.TEST_LODGE_DIR + "/" + QaConstants.TEST_LODGE_CRED_JSON);
            Object obj = parser.parse(new FileReader(file));
            JSONObject jsonObject = (JSONObject) obj;
            testLodgeUrl = (String) jsonObject.get("TL_Base_URL");
            username = (String) jsonObject.get("TL_User_Name");
            password = (String) jsonObject.get("TL_User_PW");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> getTestResult() {
        ArrayList<String> testCaseList = new ArrayList<>();
        try {
            JSONParser parser = new JSONParser();
            File file = new File(QaConstants.TEST_LODGE_DIR + "/" + QaConstants.TEST_LODGE_RESULT_JSON);
            Object obj = parser.parse(new FileReader(file));
            JSONObject level1Object = (JSONObject) obj;
            JSONArray resultsList = (JSONArray) level1Object.get("resultsList");
            for (int i = 0; i < resultsList.size(); i++) {
                String testName = ((JSONObject) resultsList.get(i)).get("testName").toString();
                String runStatus = ((JSONObject) resultsList.get(i)).get("runStatus").toString();
                testCaseList.add(testName + ":" + runStatus);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return testCaseList;
    }

    public Integer getTestCaseID(String TestCaseName, String testRunId) {
        try {
            String getUrl = "https://shopkick.api.testlodge.com/v1/projects/" + projectId + "/runs/" + testRunId + "/executed_steps.json";
            Response response = given().contentType(ContentType.URLENC).auth().basic(username, password).expect().statusCode(200).get(getUrl);

            Integer tpages = response.getBody().path("pagination.total_pages");
            ArrayList<Integer> tcid = new ArrayList<>();
            ArrayList<String> tcname = new ArrayList<>();
            for (int i = 1; i <= tpages; i++) {
                String getUrl1 = "https://shopkick.api.testlodge.com/v1/projects/" + projectId + "/runs/" + testRunId + "/executed_steps.json?page=" + i;
                Response response1 = given().contentType(ContentType.URLENC).auth().basic(username, password).expect().statusCode(200).get(getUrl1);
                ArrayList<Integer> temp_tid = response1.getBody().path("executed_steps.id");
                ArrayList<String> title_tname = response1.getBody().path("executed_steps.title");
                tcid.addAll(temp_tid);
                tcname.addAll(title_tname);
            }
            HashMap<String, Integer> map = new HashMap<>();
            for (int j = 0; j < tcid.size(); j++) {
                map.put(tcname.get(j), tcid.get(j));
            }
            Integer tcID = map.get(TestCaseName);
            return tcID;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public boolean setTestCaseStatus(String testRunId, String testCaseName, String testResult) {
        try {
            Integer testcaseId = getTestCaseID(testCaseName, testRunId);
            if (testcaseId != null) {
                RequestSpecification request = null;
                if (testResult.equals("passed")) {
                    request = given().contentType(ContentType.URLENC).with().parameters("executed_step[actual_result]", "passed", "executed_step[passed]", "1");
                } else if (testResult.equals("failed")) {
                    request = given().contentType(ContentType.URLENC).with().parameters("executed_step[actual_result]", "failed", "executed_step[passed]", "0");
                }
                String patchUrl = testLodgeUrl + projectId + "/runs/" + testRunId + "/executed_steps/" + testcaseId + ".json";
                given(request).auth().basic(username, password).expect().statusCode(200).patch(patchUrl);
                log.info(testCaseName + " Updated on TestLodge");
                return true;
            }
        } catch (Exception e) {
            log.info("ERROR in TestResult Update process ");
            e.printStackTrace();
            return false;
        }
        return false;
    }

    public String createTestRun(String projectId, String suiteId) {
        try {
            String runName = "automated Test Run " + QaCalendar.getInstance().getDateTime();
            RequestSpecification request = given().contentType(ContentType.URLENC).with().
                    parameters("run[name]", runName, "run[plan_id]", "11001", "run[suite_ids][]", suiteId);
            Response resp = given(request).auth().basic(username, password).expect().statusCode(201).
                    post(testLodgeUrl + projectId + "/runs.json");
            String runId = resp.getBody().path("id").toString();
            log.info("runId: " + runId);
            return runId;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public boolean deleteTestRun(String projectId, String runId) {
        try {
            RequestSpecification request = given().contentType(ContentType.URLENC).with();
            Response resp = given(request).auth().basic(username, password).expect().statusCode(204).
                    delete(testLodgeUrl + projectId + "/runs/" + runId + ".json");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}