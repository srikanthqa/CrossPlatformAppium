package com.qa.shopkick.tests;

import com.qa.shopkick.utils.QaConstants;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileReader;
import java.util.logging.Logger;

/**
 * Created by mmadhusoodan on 10/21/15.
 */
public class HelloSK {


    final private static Logger log = Logger.getLogger("");

    public static void main(String[] args) {
        try {
            JSONParser parser = new JSONParser();
            File file = new File(QaConstants.TEST_LODGE_DIR + "/" + QaConstants.TEST_LODGE_RESULT_JSON);
            Object obj = parser.parse(new FileReader(file));
            JSONObject level1Object = (JSONObject) obj;
            JSONArray resultsList = (JSONArray) level1Object.get("resultsList");

            for (int i = 0; i < resultsList.size(); i++) {

                ((JSONObject) resultsList.get(i)).get("runStatus").toString();
                ((JSONObject) resultsList.get(i)).get("testName").toString();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}