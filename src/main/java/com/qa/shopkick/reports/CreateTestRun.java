package com.qa.shopkick.reports;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

import static com.jayway.restassured.RestAssured.given;

public class CreateTestRun {

    public static void main(String[] args) {
        //Create Test Run
        //https://shopkick.api.testlodge.com/v1/projects/10019/runs.json
        RequestSpecification request1 = given().contentType(ContentType.URLENC).with().parameters("run[name]", "Appium Test Run 10:32", "run[plan_id]", "11001", "run[suite_ids][]", "58074");
        Response resp = given(request1).auth().basic("manish@shopkick.com", "shopkick123").expect().statusCode(201).post("https://shopkick.api.testlodge.com/v1/projects/10019/runs.json");
        System.out.println("runId : " + resp.getBody().path("id").toString());

    }
}
