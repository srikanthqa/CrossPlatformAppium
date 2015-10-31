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

import static junit.framework.TestCase.assertEquals;

/**
 * Created by mmadhusoodan on 10/26/15.
 */
public class QaReportProcessor {
    public static Logger log = Logger.getLogger(QaReportProcessor.class);
    public String projectId = System.getProperty("projectId");
    WebDriver driver = null;
    private String testLodgeReportDir = "";
    private String testLodgeReportPath = "";
    private String reportScreenshotPath = "";
    private String TestrailURL = "";
    private String testResult = "";
    private String passed = "";
    private String reportName = "";
    private String failed = "";
    private String percentagePass = "";
    private String averybuildNo = "";
    private String reportTime = "";
    private boolean failuresFlag = false;
    private String userName = "manish@shopkick.com";
    private String password = "shopkick123";
    public static String platformType = "Android";
//            System.getProperty("platformType");

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

    /**
     * launch TestLodge and SignIn and go to the test results pace and
     * take a screen and place it in the reports directory
     */

    public String LaunchTestLodgeAndGrabValues(String url, String testRunName) throws Exception {

        reportName = getTestLodgeReportName();
        QaScreenshot screenShot = new QaScreenshot(driver);
        if (!reportName.isEmpty()) {
            try {
                testLodgeReportDir = reportName.split("_t")[0].trim();
                testLodgeReportDir = testLodgeReportDir.replace(":", "_");
                System.setProperty("webdriver.chrome.driver", QaConstants.MAC_CHROME_DRIVER_LOCATION);
                driver = new ChromeDriver();
                WebDriverWait wait = new WebDriverWait(driver, 5);
                driver.navigate().to("http://shopkick.testlodge.com/projects/10019/runs/176127");
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
                String notRun = driver.findElements(By.className("count_cont")).get(0).getText().trim();
                String passed = driver.findElements(By.className("count_cont")).get(1).getText().trim();
                String failed = driver.findElements(By.className("count_cont")).get(2).getText().trim();

                testResult = "\npassed: " + passed + "\n" + "failed " + failed + "\n" + "notRun " + notRun + "\n";
                reportScreenshotPath = screenShot.reportCapture(driver, testLodgeReportDir);

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
        return reportScreenshotPath;
    }

    public String getHumanReadableReportTime(String reportScreenshotPath) {

        try {
            reportTime = (reportScreenshotPath.split("/screenshot")[0]);
            reportTime = reportTime.split(platformType+"_")[1];
            reportTime = reportTime.replace("_", ":");
        } catch (Exception e) {
            log.error(e);
        }
        return reportTime;
    }

    /*    public String getEmailBodyWithFailedTestCases() {

            QaFileReader qaFileReader = new QaFileReader();
            String body = "";
            List<String> testcaseList = qaFileReader.getFailedTestCaseListFromTestrailJSON();

            Iterator<String> iterator = testcaseList.iterator();
            while (iterator.hasNext()) {
                body = body + iterator.next() + "\n";
            }

            return body;
        }

        public String getExecutionTime() {

            QaFileReader qaFileReader = new QaFileReader();
            String execTime = qaFileReader.getExecutionTimeInHHMMSSFromTestLodgeJSON();
            return execTime;
        }
    */
/*    public void sendFailedEmail() throws Exception {

        try {
            reportTime = getHumanReadableReportTime(testLodgeReportPath);
            String subject = "[ " + failed.toUpperCase() + " ] " + reportTime + " Avery Automation FAILED";
            String body = "<html><font face='verdana' size='2'><b>Lyve Suite Automation Run:</b> " + reportTime + "\n\n";
            body += "Failed Test Cases\n\n";
            //            body += getEmailBodyWithFailedTestCases();
            body += "</html>";

            reportName = getTestLodgeReportName();
            QaEmail qaEmail = new QaEmail();
            if (failuresFlag)
                qaEmail.sendEmail(fromEmail, fromName, toEmail, toName, subject, body);
        } catch (Exception e) {
            log.error(e);
            System.exit(1);
        }
    }
*/
}