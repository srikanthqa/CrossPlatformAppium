package com.qa.shopkick.reports;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;

import static com.jayway.restassured.RestAssured.given;


public class RunTestCase {
    public static Logger log = Logger.getLogger(RunTestCase.class);

    public static void main(String[] args) {

        Integer testcase_id = getTestCaseID("Test1_LoginWithEmailAccount");
        //setTestCaseStatus("TC1200","passed");
    }

    public static Integer getTestCaseID(String TestCaseName) {
        Response response = given().contentType(ContentType.URLENC).auth().basic("manish@shopkick.com", "shopkick123").expect().statusCode(200).
                get("https://shopkick.api.testlodge.com/v1/projects/10019/runs/175961/executed_steps.json");

        Integer tpages = response.getBody().path("pagination.total_pages");
        ArrayList<Integer> tcid = new ArrayList<>();
        ArrayList<String> tcname = new ArrayList<>();
        for (int i = 1; i <= tpages; i++) {
            Response response1 = given().contentType(ContentType.URLENC).auth().basic("manish@shopkick.com", "shopkick123").expect().statusCode(200).
                    get("https://shopkick.api.testlodge.com/v1/projects/10019/runs/175961/executed_steps.json?page=" + i);
            ArrayList<Integer> temp_tid = response1.getBody().path("executed_steps.id");
            ArrayList<String> stepNo_tname = response1.getBody().path("executed_steps.step_number");
            ArrayList<String> title_tname = response1.getBody().path("executed_steps.title");
            tcid.addAll(temp_tid);
            tcname.addAll(title_tname);
        }
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (int j = 0; j < tcid.size(); j++) {
            map.put(tcname.get(j), tcid.get(j));
        }
        Integer tcID = map.get(TestCaseName);
        return tcID;
    }

    public static void setTestCaseStatus(String TestCaseName, String TestResult) {

        RequestSpecification request = null;
        if (TestResult.equals("passed")) {
            request = given().contentType(ContentType.URLENC).with().parameters("executed_step[actual_result]", "Passed[Automation]", "executed_step[passed]", "1");
        } else if (TestResult.equals("failed")) {
            request = given().contentType(ContentType.URLENC).with().parameters("executed_step[actual_result]", "Failed[Automation]", "executed_step[passed]", "0");
        }
        Integer testcase_id = getTestCaseID(TestCaseName);

        given(request).auth().basic("manish@shopkick.com", "shopkick123").expect().statusCode(200).
                patch("https://shopkick.api.testlodge.com/v1/projects/10019/runs/175745/executed_steps/" + testcase_id + ".json");

    }

}
