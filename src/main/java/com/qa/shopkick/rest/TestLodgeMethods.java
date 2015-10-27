package com.qa.shopkick.rest;

import com.qa.shopkick.utils.QaConstants;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;


/**
 * Created by mmadhusoodan on 10/27/15.
 */

public class TestLodgeMethods {

    private Logger log = Logger.getLogger(TestLodgeMethods.class);
    private static TestLodgeMethods instance;

    private static final String SLASH = "/";

    private String baseURL = "";
    private String user = "";
    private String pass = "";
    private final String USER_AGENT = "Mozilla/5.0";
    private HttpClient client = HttpClientBuilder.create().build();
    private String jsonData = "";


    public static synchronized TestLodgeMethods getInstance() {

        if (instance == null) {
            instance = new TestLodgeMethods();
        }
        return instance;
    }

    public void getTestLodgeCredentials() {
        JSONParser parser = new JSONParser();

        try {
            File file = new File(QaConstants.TEST_LODGE_DIR + SLASH + QaConstants.TEST_LODGE_CRED_JSON);
            Object obj = parser.parse(new FileReader(file));
            JSONObject jsonObject = (JSONObject) obj;

            baseURL = (String) jsonObject.get("TL_Base_URL");
            user = (String) jsonObject.get("TL_User_Name");
            pass = (String) jsonObject.get("TL_User_PW");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String executeHttpGet(String url) throws Exception {

        try {
            getTestLodgeCredentials();
            //Username password needs Encoding
            String encodedAuthString = Base64.encodeBase64String((user + ":" + pass).getBytes());
            HttpGet httpGet = new HttpGet(url);
            // add request header
            httpGet.addHeader("User-Agent", USER_AGENT);
            httpGet.addHeader("Authorization", "Basic " + encodedAuthString);

            HttpResponse response = client.execute(httpGet);
            int resCode = response.getStatusLine().getStatusCode();
            log.info("Response Code : " + resCode);

            if (resCode != 200) {
                log.info(resCode);
                System.exit(1);
            }

            BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            StringBuffer result = new StringBuffer();
            String line = "";
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            jsonData = result.toString();
        } catch (Exception e) {
            log.error(e);
        }
        return jsonData;
    }

    public String executeHttpPost(String url) throws Exception {

        try {
            getTestLodgeCredentials();
            //Username password needs Encoding
            String encodedAuthString = Base64.encodeBase64String((user + ":" + pass).getBytes());
            // add request header
            HttpPost httpPost = new HttpPost(url);
            httpPost.addHeader("Content-type", "application/json");
            httpPost.addHeader("Authorization", "Basic " + encodedAuthString);
            String postData = "step: {\n" +
                    "        title: 'Title',\n" +
                    "        description: 'Thebodytext',\n" +
                    "    }";

            StringEntity params = new StringEntity(postData);
            httpPost.setEntity(params);

            HttpResponse response = client.execute(httpPost);
            log.info("\nSending 'POST' request to URL : " + url);
            int resCode = response.getStatusLine().getStatusCode();
            log.info("Response Code : " + resCode);

            if (resCode != 200) {
                System.exit(1);
            }
            BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

            StringBuffer result = new StringBuffer();
            String line = "";
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            log.info(result.toString());

        } catch (Exception e) {
            log.error(e);
        }
        return jsonData;
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

    @Test
    public void runMain() throws Exception {

        //        HttpClientExample.getInstance().executeHttpGet(url);
        //        HttpClientExample.getInstance().getProjectsList();
        // Existing Project Id = 10019
        // Created Smoke Suite id = 58074
        //TestLodgeMethods.getInstance().showTestSuiteDetails("10019", "58074");

        TestLodgeMethods.getInstance().createTestCases("10019", "58074");


    }
}
