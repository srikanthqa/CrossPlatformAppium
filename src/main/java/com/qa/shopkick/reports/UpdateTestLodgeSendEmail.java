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
    private String tesLodgeReportPath = "";
    private String reportName = "";
    private String reportDir = "";
    private String reportTime = "";
    private String TestrailURL = "";
    private String testResult = "";
    private String passed = "";
    private String failed = "";
    private String percentagePass = "";
    private boolean failuresFlag = false;

    @Test
    public void TestHello() {
    }

    @Test
    public void TestSetTestCaseStatus() {
        String projectId = "10019";
        String suiteId = "58074";
        String testRunId = "";
        QaTestLodge testLodge = new QaTestLodge();
        testRunId = testLodge.createTestRun(projectId, suiteId);
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
        tesLodgeReportPath = qaReportProcessor.LaunchTestLodgeAndScreenGrab();
        if ("".equalsIgnoreCase(tesLodgeReportPath)) {
            log.info("Reports Path is empty, possibly not found on testLodge ...NO EMAIL would be sent ... exiting ");
        } else {
            String subject = "";
            String body = "";
            try {
                reportTime = qaReportProcessor.getHumanReadableReportTime(tesLodgeReportPath);
                //                subject = "Avery " + QaProperties.getSuiteType() + " Automation Results: [" + QaProperties.getStack() + "] [Build: " + averybuildNo + "] [" + percentagePass + " Pass] ";
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
                body += "For complete execution details, use the link below:\n" + TestrailURL + "\n\n";
                //                body += "<b><u>TestRails SignIn:</b></u>\n" + "Username: trguest2@blackpearlsystems.com \nPassword: TRGuestUser2\n";
                body += "</html>";
                reportName = qaReportProcessor.getTestLodgeReportName();
                QaEmail qaEmail = new QaEmail();
                qaEmail.sendEmailAttachment(fromEmail, fromName, toEmail, toName, subject, body, tesLodgeReportPath);
            } catch (Exception e) {
                log.error(e);
                System.exit(1);
            } finally {
                //                sendFailedEmail();
            }
        }
    }


}