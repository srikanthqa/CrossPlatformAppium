package com.qa.shopkick.utils;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by mmadhusoodan on 10/26/15.
 */
public class QaReportProcessor {
    public static Logger log = Logger.getLogger(QaReportProcessor.class);

    private String reportName = "";
    private String reportDir = "";
    private String testrailReportPath = "";
    private String TestrailURL = "";
    private String testResult = "";
    private String passed = "";
    private String failed = "";
    private String percentagePass = "";
    private String averybuildNo = "";
    private String reportTime = "";
    private boolean failuresFlag = false;
    private String userName = "testrailreporter@lyveminds.com";
    private String password = "2vhSJ5982Ge77d8pwW6H";
    WebDriver driver = null;
    String fromEmail = "avery-automation@seagate.com";
    String fromName = "Avery Automation";
    String toEmail = "manish@shopkick.com";
    String toName = "LM-Avery-Automation";

    public String getRailsReportName() {
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader(QaConstants.TEST_LODGE_RESULT_JSON + File.separator + QaConstants.TEST_LODGE_RESULT_JSON));
            JSONObject jsonObject = (JSONObject) obj;
            reportName = (String) jsonObject.get("reportName");
            log.info("reportName: " + reportName);
        } catch (FileNotFoundException e) {
            log.error(e);
        } catch (Exception e) {
            log.error(e);
        }
        return reportName;
    }

    /**
     * launch Testrails and SignIn and go to the test results pace and
     * take a screen and place it in the reports directory
     */

    public String LaunchTestRailsAndScreenGrab() throws Exception {

        reportName = getRailsReportName();

        if (!reportName.isEmpty()) {
            try {
                //                System.setProperty("webdriver.chrome.driver", QaConstants.MAC_CHROME_DRIVER_LOCATION);
                driver = new FirefoxDriver();

                WebDriverWait wait = new WebDriverWait(driver, 5);
                averybuildNo = reportName.split("_")[0];
                averybuildNo = averybuildNo.split("-")[3];
                reportDir = reportName.split("_t")[0].trim();
                reportDir = reportDir.replace(":", "_");
                QaScreenshot screenShot = new QaScreenshot(driver);
                String BaseURL = "https://testrail.blackpearlsystems.com/index.php?/projects/overview/16";

                driver.navigate().to(BaseURL);
                driver.manage().window().maximize();

                driver.findElement(By.name("name")).sendKeys(userName);
                driver.findElement(By.name("password")).sendKeys(password);

                driver.findElement(By.className("positive")).click(); // SignIn button is called positive :)
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("id")));

                assertEquals("P16", driver.findElement(By.className("id")).getText().trim());

                assertEquals("Report Not Present", true, driver.findElement(By.linkText(reportName)).isDisplayed());

                driver.findElement(By.linkText(reportName)).click();
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("breadcrumb")));

                //get the Pass percentage pass and fail
                List<WebElement> wLabels = driver.findElements(By.className("title"));
                passed = wLabels.get(4).getText().trim();
                failed = wLabels.get(7).getText().trim();
                percentagePass = wLabels.get(8).getText().trim();

                if (null != failed && Integer.valueOf(failed.split(" ")[0]) > 0) {
                    failuresFlag = true;
                }
                testResult = passed + "\n" + failed + "\n\n" + "Pass Percentage: " + percentagePass + "\n";
                String testStatus = passed.toUpperCase() + "\n" + failed.toLowerCase();
                log.info("testStatus: " + testStatus);

                QaFileWriter.appendToFile(QaConstants.BUILD_STATUS, testResult);
                String TestReportRun = driver.findElement(By.id("breadcrumb")).getText().trim();
                TestrailURL = driver.getCurrentUrl();
                log.info("TestrailURL: " + TestrailURL);

                if (TestReportRun.isEmpty() || !TestReportRun.contains(reportName)) {
                    log.info("Something went wring with testRails");
                } else {

                    testrailReportPath = screenShot.reportCapture(driver, reportDir);
                    log.info("testrailReportPath: " + testrailReportPath);
                }
            } catch (NoSuchElementException nse) {
                log.info(reportName + " Not Found, Probably report was not uploaded ... Exiting");
            } catch (Exception e) {
                log.error(e);
            } finally {
                driver.quit();
            }
        } else {
            log.info("reportName is Empty check testrails.json");
        }
        return testrailReportPath;
    }

    public String getHumanReadableReportTime(String reportScreenshotPath) {

        try {
            reportTime = (reportScreenshotPath.split("/screenshot")[0]);
            reportTime = reportTime.split("reports//avery-dogfood-debug-")[1];
            reportTime = reportTime.split(averybuildNo + "_")[1];
            reportTime = reportTime.replace("_", ":");
            reportTime = reportTime.split("-")[3];
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
            String execTime = qaFileReader.getExecutionTimeInHHMMSSFromTestrailsJSON();
            return execTime;
        }
    */
    public void sendFailedEmail() throws Exception {

        try {
            reportTime = getHumanReadableReportTime(testrailReportPath);
            String subject = "[ " + failed.toUpperCase() + " ] " + reportTime + " Avery Automation FAILED";
            String body = "<html><font face='verdana' size='2'><b>Lyve Suite Automation Run:</b> " + reportTime + "\n\n";
            body += "Failed Test Cases\n\n";
            //            body += getEmailBodyWithFailedTestCases();
            body += "</html>";

            reportName = getRailsReportName();
            QaEmail qaEmail = new QaEmail();
            if (failuresFlag)
                qaEmail.sendEmail(fromEmail, fromName, toEmail, toName, subject, body);
        } catch (Exception e) {
            log.error(e);
            System.exit(1);
        }
    }

    @Test
    public void sendEmailWithAttachment() throws Exception {

        testrailReportPath = LaunchTestRailsAndScreenGrab();
        if ("".equalsIgnoreCase(testrailReportPath)) {
            log.info("Reports Path is empty, possibly not found on testrail ...NO EMAIL would be sent ... exiting ");
        } else {
            String subject = "";
            String body = "";
            try {
                reportTime = getHumanReadableReportTime(testrailReportPath);
                //                subject = "Avery " + QaProperties.getSuiteType() + " Automation Results: [" + QaProperties.getStack() + "] [Build: " + averybuildNo + "] [" + percentagePass + " Pass] ";
                body = "<html><font face='verdana' size='2'><b>Avery Automation Time of Execution:</b> " + reportTime + "\n\n";
                body += "<b><u>Environment:</b></u>" + "\n";
                //                body += "Stack: " + QaProperties.getStack() + "\n";
                body += "Avery Build #: " + averybuildNo + "\n";
                //                body += "Execution Time: " + getExecutionTime() + "\n\n";
                body += "<b><u>Test Results</b></u>" + "\n";
                body += testResult + "\n";
                if (failuresFlag) {
                    body += "<b><u>Failed Test Cases</b></u> \n\n";
                    //                    body += getEmailBodyWithFailedTestCases() + "\n";
                }
                body += "For complete execution details, use the link below:\n" + TestrailURL + "\n\n";
                body += "<b><u>TestRails SignIn:</b></u>\n" + "Username: trguest2@blackpearlsystems.com \nPassword: TRGuestUser2\n";
                body += "</html>";
                reportName = getRailsReportName();
                QaEmail qaEmail = new QaEmail();
                qaEmail.sendEmailAttachment(fromEmail, fromName, toEmail, toName, subject, body, testrailReportPath);
            } catch (Exception e) {
                log.error(e);
                System.exit(1);
            } finally {
                //                sendFailedEmail();
            }
        }
    }
}