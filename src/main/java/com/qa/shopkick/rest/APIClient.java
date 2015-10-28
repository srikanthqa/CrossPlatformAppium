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
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;

/**
 * Created by mmadhusoodan on 10/27/15.
 */
public class APIClient {

    private Logger log = Logger.getLogger(TestLodgeMethods.class);

    protected String baseURL = "";
    protected String user = "";
    protected String pass = "";
    protected final String USER_AGENT = "Mozilla/5.0";
    protected HttpClient client = HttpClientBuilder.create().build();
    protected String jsonData = "";

    public void getTestLodgeCredentials() {
        JSONParser parser = new JSONParser();

        try {
            File file = new File(QaConstants.TEST_LODGE_DIR + "/" + QaConstants.TEST_LODGE_CRED_JSON);
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
}
