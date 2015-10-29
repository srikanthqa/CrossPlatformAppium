package com.qa.shopkick.utils;

import org.apache.log4j.Logger;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by mmadhusoodan on 4/15/15.
 */
public class QaFileReader {

    public static Logger log = Logger.getLogger(QaFileReader.class);
    private static String testrailDir = "testrail_scripts";
    String fileName = QaConstants.TEST_LODGE_RESULT_JSON;
    String filePath = testrailDir + File.separator + fileName;
    File file = new File(filePath);
    //    JSONParser parser = new JSONParser();
    List<String> testcaseList = new ArrayList<String>();

    public static void main(String[] args) {
        QaFileReader qaFileReader = new QaFileReader();

        //        String body = "";
        //        List<String> testcaseList = qaFileReader.getFailedTestCaseListFromTestrailJSON();
        //        Iterator<String> iterator = testcaseList.iterator();
        //
        //        while (iterator.hasNext()) {
        //            body = body + iterator.next() + "\n";
        //        }
        //        log.info(body);

    }

    //    public List<String> getFailedTestCaseListFromTestrailJSON() {
    //        try {
    //            Object obj = parser.parse(new FileReader(file));
    //            JSONObject jsonObject = (JSONObject) obj;
    //            JSONArray testcaseArray = (JSONArray) jsonObject.get("resultsList");
    //
    //            for (int i = 0; i < testcaseArray.size(); i++) {
    //                JSONObject testcaseJSONObject = (JSONObject) testcaseArray.get(i);
    //                String runStatus = testcaseJSONObject.get("runStatus").toString();
    //                if ("failed".equalsIgnoreCase(runStatus)) {
    //                    testcaseList.add(testcaseJSONObject.get("testSectionName").toString() + " : " + testcaseJSONObject.get("testName").toString());
    //                }
    //            }
    //        } catch (Exception e) {
    //            log.error(e);
    //        }
    //        return testcaseList;
    //    }

    //    public String getExecutionTimeInHHMMSSFromTestrailsJSON() {
    //
    //                JSONParser parser = new JSONParser();
    //                long totalTime = 0l;
    //                String executionTime = "";
    //                try {
    //                    Object obj = parser.parse(new FileReader("testrail_scripts/testrail.json"));
    //                    JSONObject jsonObject = (JSONObject) obj;
    //                    JSONArray jsonArray = (JSONArray) jsonObject.get("resultsList");
    //                    for (int i = 0; i < jsonArray.size(); i++) {
    //                        jsonObject = (JSONObject) jsonArray.get(i);
    //                        long elapsed = (Long) (jsonObject.get("elapsed"));
    //                        totalTime += elapsed;
    //                    }
    //                    executionTime = QaCalendar.getInstance().getHHMMSSFromSeconds((int) totalTime);
    //                    log.info(executionTime);
    //
    //                } catch (Exception e) {
    //                    log.error(e);
    //                }
    //                return executionTime;
    //    }
}
