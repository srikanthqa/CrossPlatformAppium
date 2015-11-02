package com.qa.shopkick.tests;

import com.qa.shopkick.reports.QaReportProcessor;
import com.qa.shopkick.utils.QaEmail;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;

import static junit.framework.Assert.assertNotNull;

/**
 * Created by mmadhusoodan on 11/2/15.
 */
public class QaEmailProcessor {

    public static Logger log = Logger.getLogger(QaEmailProcessor.class);

    private String fromEmail = "Appium.Automation@shopkick.com";
    private String fromName = "Appium Automation";
    private String toEmail = "manish@shopkick.com";
    private String toName = "Appium-Automation";
    private String reportDir = "";
    private String passed = "";
    private String failed = "";
    private String percentagePass = "";
    private boolean failuresFlag = false;
    private String projectId = "10019";
    private String suiteId = "58074";

    private String reportName = "";
    private String reportTime = "";
    private String TestLodgeURL = "";
    private String testLodgeResult = "";

    private String testLodgeReportPath = "";
    private String testRunId = "";
    private String testRunName = "";

    private String buildNo = "1125";

    @Test
    public void sendEmailWithAttachment() throws Exception {

        QaReportProcessor qaReportProcessor = new QaReportProcessor();

        testRunId = qaReportProcessor.uploadResultsToTestLodge();
        assertNotNull("TestRun Empty ", testRunId);
        String testLodgeUrl = "http://shopkick.testlodge.com/projects/" + projectId + "/runs/" + testRunId;

        HashMap<String, String> resultMap = qaReportProcessor.LaunchTestLodgeAndGrabValues(testLodgeUrl, testRunName);
        percentagePass = resultMap.get("percentagePass");
        testLodgeReportPath = resultMap.get("reportScreenshotPath");
        log.info(testLodgeReportPath);
        if ("".equalsIgnoreCase(testLodgeReportPath)) {
            log.info("Reports Path is empty, possibly not found on testLodge ...NO EMAIL would be sent ... exiting ");
        } else {
            String subject = "";
            String body = "";
            try {
                reportTime = qaReportProcessor.getHumanReadableReportTime(testLodgeReportPath);
                testLodgeResult = qaReportProcessor.getTestLodgeResults();
                assertNotNull("ReportTime Empty ", reportTime);
                log.info("reportTime: " + reportTime);
                subject = "Appium" + " Automation Results: [RC Build: " + buildNo + "] [" + percentagePass + "% Pass] ";
                body = "<html><font face='verdana' size='2'><b>Time of Execution:</b> " + reportTime + "\n\n";
                body += "[RC Build: " + buildNo + "]";
                body += "<b><u>Test Results</b></u>" + "\n";

                body += testLodgeResult + "\n";
                if (failuresFlag) {
                    body += "<b><u>Failed Test Cases</b></u> \n\n";
                    //  body += getEmailBodyWithFailedTestCases() + "\n";
                }
                body += "For complete execution details, use the link below:\n" + TestLodgeURL + "\n\n";
                body += "</html>";
                reportName = qaReportProcessor.getTestLodgeReportName();
                log.info("reportName: " + reportName);
                QaEmail qaEmail = new QaEmail();
                qaEmail.sendEmailAttachment(fromEmail, fromName, toEmail, toName, subject, body, testLodgeReportPath);
            } catch (Exception e) {
                log.error(e);
                System.exit(1);
            } finally {
                //sendFailedEmail();
            }
        }
    }

    /*
    @Test
    public void sendEmail() {
        try {
            QaEmail qaEmail = new QaEmail();
            String subject = "";
            String body = "";
            testLodgeReportPath = "reports/Android_10-30-02_17/screenshot427682324976688115.png";
            subject = "Appium " + " Automation Results: [Build: " + "BuildNo" + "] [" + percentagePass + " Pass] ";
            body = "<html><font face='verdana' size='2'><b>Appium Automation Time of Execution:</b> " + reportTime + "\n\n";
            body += "<b><u>Environment:</b></u>" + "\n";
            //  body += "Stack: " + QaProperties.getStack() + "\n";
            //  body += "Execution Time: " + getExecutionTime() + "\n\n";
            body += "<b><u>Test Results</b></u>" + "\n";
            body += testLodgeResult + "\n";
            if (failuresFlag) {
                body += "<b><u>Failed Test Cases</b></u> \n\n";
                //  body += getEmailBodyWithFailedTestCases() + "\n";
            }
            body += "For complete execution details, use the link below:\n" + TestLodgeURL + "\n\n";
            body += "</html>";

            //            qaEmail.sendEmail(fromEmail, fromName, toEmail, toName, subject, body);
            qaEmail.sendEmailAttachment(fromEmail, fromName, toEmail, toName, subject, body, testLodgeReportPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    */

    /*body += "<b><u>Environment:</b></u>" + "\n";
                  body += "Stack: " + QaProperties.getStack() + "\n";
                  body += "Execution Time: " + getExecutionTime() + "\n\n";
                */
}
