package com.qa.shopkick.reports;

import com.qa.shopkick.utils.QaEmail;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertTrue;

/**
 * Created by mmadhusoodan on 10/21/15.
 */
public class UpdateTestLodgeSendEmail {

    final private static Logger log = Logger.getLogger(UpdateTestLodgeSendEmail.class);
    String fromEmail = "manish@shopkick.com";
    String fromName = "Appium Automation";
    String toEmail = "manish@shopkick.com";
    String toName = "SK-Appium-Automation";
    QaReportProcessor qaReportProcessor = new QaReportProcessor();
    private String testLodgeReportPath = "";
    private String reportName = "";
    private String reportDir = "";
    private String reportTime = "";
    private String TestLodgeURL = "";
    private String testResult = "";
    private String passed = "";
    private String failed = "";
    private String percentagePass = "";
    private boolean failuresFlag = false;

    String projectId = "10019";
    String suiteId = "58074";
    public String testRunId = "176141";
    public String testRunName = "Android_4.7.5_10/30_10:45";

    public void uploadResultsToTestLodge() {

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
    }

    @Test
    public void sendEmailWithAttachment() throws Exception {

        uploadResultsToTestLodge();

        String testLodgeUrl = "http://shopkick.testlodge.com/projects/" + projectId + "/runs/" + testRunId;
        testLodgeReportPath = qaReportProcessor.LaunchTestLodgeAndGrabValues(testLodgeUrl, testRunName);
        log.info(testLodgeReportPath);
        if ("".equalsIgnoreCase(testLodgeReportPath)) {
            log.info("Reports Path is empty, possibly not found on testLodge ...NO EMAIL would be sent ... exiting ");
        } else {
            String subject = "";
            String body = "";
            try {
                reportTime = qaReportProcessor.getHumanReadableReportTime(testLodgeReportPath);
                log.info("reportTime: " + reportTime);
                subject = "Appium " + " Automation Results: [Build: " + "BuildNo" + "] [" + percentagePass + " Pass] ";
                body = "<html><font face='verdana' size='2'><b>Appium Automation Time of Execution:</b> " + reportTime + "\n\n";
                body += "<b><u>Environment:</b></u>" + "\n";
                //                body += "Stack: " + QaProperties.getStack() + "\n";
                //                body += "Execution Time: " + getExecutionTime() + "\n\n";
                body += "<b><u>Test Results</b></u>" + "\n";
                body += testResult + "\n";
                if (failuresFlag) {
                    body += "<b><u>Failed Test Cases</b></u> \n\n";
                    //                    body += getEmailBodyWithFailedTestCases() + "\n";
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
                //                sendFailedEmail();
            }
        }
    }

    @Test
    public void sendEmail() {
        try {
            QaEmail qaEmail = new QaEmail();
            testLodgeReportPath = "Android_10-30-02_17/screenshot427682324976688115.png";
            qaEmail.sendEmail(fromEmail, fromName, toEmail, toName, "abc", "Abc");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}