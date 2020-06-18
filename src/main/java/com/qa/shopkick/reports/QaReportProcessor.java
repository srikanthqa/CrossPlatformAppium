package com.qa.shopkick.reports;

import com.qa.shopkick.utils.QaConstants;
import com.qa.shopkick.utils.QaScreenshot;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

/**
 * Created by mmadhusoodan on 10/26/15.
 */
public class QaReportProcessor {
    public static Logger log = Logger.getLogger(QaReportProcessor.class);
    //    public String projectId = System.getProperty("projectId");
    WebDriver driver = null;
    private String testLodgeReportDir = "";
    private String reportScreenshotPath = "";
    private String userName = "manish@shopkick.com";
    private String password = "shopkick123";
    public static String platformType = "Android";
    private String reportName = "";
    private String reportTime = "";
    private String TestLodgeURL = "";
    private static String testResult = "";
    String projectId = "10019";
    String suiteId = "58074";
    public String testRunId = "";
    public String testRunName = "";
    String passed, failed, notRun = "";


    //            System.getProperty("platformType");

    /**
     * Creates a TestRun and uploads the results
     *
     * @return String TestRunId
     */
    public String uploadResultsToTestLodge() {
        try {
            QaTestLodge testLodge = new QaTestLodge();
            String run = testLodge.createTestRun("Android", projectId, suiteId);
            testRunId = run.split(":")[0];
            testRunName = run.split(":")[1];
            log.info("Test Run Created with testRunId: " + testRunId);
            ArrayList<String> testCaseList = testLodge.getTestResult();

            for (int i = 0; i < testCaseList.size(); i++) {
                String testCaseName = testCaseList.get(i).split(":")[0];
                String runStatus = testCaseList.get(i).split(":")[1];
                assertTrue("Uploading results to Test Lodge Failed ", testLodge.setTestCaseStatus(testRunId, testCaseName, runStatus));
            }
            return testRunId;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public String getTestLodgeReportName() {
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader(QaConstants.TEST_LODGE_DIR + File.separator + QaConstants.TEST_LODGE_RESULT_JSON));
            JSONObject jsonObject = (JSONObject) obj;
            reportName = (String) jsonObject.get("reportName");
            log.info("reportName: " + reportName);
        } catch (Exception e) {
            log.error(e);
        }
        return reportName;
    }

    public String getTestLodgeResults() {
        try {

            testResult = "\npassed: " + passed + "\n" + "failed " + failed + "\n" + "notRun " + notRun + "\n";
        } catch (Exception e) {
            log.error(e);
            return "";
        }
        return testResult;
    }

    /**
     * launch TestLodge and SignIn and go to the test results pace and
     * take a screen and place it in the reports directory
     */
    public HashMap<String, String> LaunchTestLodgeAndGrabValues(String url, String testRunName) throws Exception {

        HashMap<String, String> resultMap = new HashMap<>();
        reportName = getTestLodgeReportName();
        QaScreenshot screenShot = new QaScreenshot(driver);
        if (!reportName.isEmpty()) {
            try {
                testLodgeReportDir = reportName.split("_t")[0].trim();
                testLodgeReportDir = testLodgeReportDir.replace(":", "_");
                System.setProperty("webdriver.chrome.driver", QaConstants.MAC_CHROME_DRIVER_LOCATION);
                driver = new ChromeDriver();
                WebDriverWait wait = new WebDriverWait(driver, 5);
                driver.navigate().to(url);
                driver.manage().window().maximize();

                driver.findElement(By.name("email")).sendKeys(userName);
                driver.findElement(By.name("password")).sendKeys(password);
                driver.findElement(By.className("submit")).click();

                Thread.sleep(5000);
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("second")));

                assertEquals("Welcome", driver.findElement(By.className("first")).getText().trim());
                log.info(driver.findElement(By.className("first")).getText() + " " + driver.findElement(By.className("second")).getText());
                String a = driver.findElement(By.className("test_run")).getText().trim();

                assertEquals("Report NOT Complete", "Complete", driver.findElement(By.className("details")).getText().trim());

                log.info("Report is Complete");
                notRun = driver.findElements(By.className("count_cont")).get(0).getText().trim();
                passed = driver.findElements(By.className("count_cont")).get(1).getText().trim();
                failed = driver.findElements(By.className("count_cont")).get(2).getText().trim();

                Integer percentagePass = 100 * Integer.parseInt(passed) / (Integer.parseInt(notRun) + Integer.parseInt(passed) + Integer.parseInt(failed));
                testResult = "\npassed: " + passed + "\n" + "failed " + failed + "\n" + "notRun " + notRun + "\n";
                reportScreenshotPath = screenShot.reportCapture(driver, testLodgeReportDir);
                resultMap.put("notRun", notRun);
                resultMap.put("passed", passed);
                resultMap.put("failed", failed);
                resultMap.put("percentagePass", percentagePass.toString());
                resultMap.put("reportScreenshotPath", reportScreenshotPath);
                log.info(testResult);
            } catch (NoSuchElementException nse) {
                log.info(reportName + " Not Found, Probably report was not uploaded ... Exiting");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (driver != null)
                    driver.quit();
            }
        } else {
            log.info("reportName is Empty check testLodge.json");
        }
        return resultMap;
    }

    public String getHumanReadableReportTime(String reportScreenshotPath) {

        try {
            reportTime = (reportScreenshotPath.split("/screenshot")[0]);
            reportTime = reportTime.split(platformType + "_")[1];
            reportTime = reportTime.replace("_", ":");
        } catch (Exception e) {
            log.error(e);
        }
        return reportTime;
    }

    //    public String getEmailBodyWithFailedTestCases() {
    //
    //        QaFileReader qaFileReader = new QaFileReader();
    //        String body = "";
    //        List<String> testcaseList = qaFileReader.getFailedTestCaseListFromTestrailJSON();
    //
    //        Iterator<String> iterator = testcaseList.iterator();
    //        while (iterator.hasNext()) {
    //            body = body + iterator.next() + "\n";
    //        }
    //
    //        return body;
    //    }
    /*
        public String getExecutionTime() {

            QaFileReader qaFileReader = new QaFileReader();
            String execTime = qaFileReader.getExecutionTimeInHHMMSSFromTestLodgeJSON();
            return execTime;
        }
*/

}