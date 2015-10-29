package com.qa.shopkick.utils;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

import static com.jayway.restassured.RestAssured.given;
import static junit.framework.TestCase.assertTrue;

public class QaTestLodge {
    private Logger log = Logger.getLogger(QaTestLodge.class);
    private String projectId = "10019";

    public class TestLodge {
        private String testLodgeUrl;
        private String username;
        private String password;

        public TestLodge() {
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
                    //                    ArrayList<String> stepNo_tname = response1.getBody().path("executed_steps.step_number");
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
    }

    @Test
    public void TestSetTestCaseStatus() {

        String projectId = "10019";
        String suiteId = "58074";
        String testRunId = "";
        TestLodge testLodge = new TestLodge();
        testRunId = testLodge.createTestRun(projectId, suiteId);
        log.info("testRunId: " + testRunId);
        ArrayList<String> testCaseList = testLodge.getTestResult();

        for (int i = 0; i < testCaseList.size(); i++) {
            String testCaseName = testCaseList.get(i).split(":")[0];
            String runStatus = testCaseList.get(i).split(":")[1];

            log.info("testCaseName: " + testCaseName);
            assertTrue(testLodge.setTestCaseStatus(testRunId, testCaseName, runStatus));
        }
    }
}
