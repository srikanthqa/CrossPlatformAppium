package com.qa.shopkick.appium;

import com.qa.shopkick.pages.FirstUseDealsEducationPage;
import com.qa.shopkick.utils.QaCalendar;
import com.qa.shopkick.utils.QaConstants;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.*;
import org.junit.rules.TestName;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.FileWriter;
import java.util.concurrent.TimeUnit;

public class BaseTestCase {
    final private static Logger log = Logger.getLogger(String.valueOf(BaseTestCase.class));
    protected static String fileName = QaConstants.TEST_LODGE_RESULT_JSON;
    protected static String testLodgeDir = "testLodge_script";
    protected static String filePath = testLodgeDir + File.separator + fileName;
    protected static File file = new File(filePath);
    protected static String reportName = "";
    public static AppiumDriver driver = null;
    protected static String packageName = "com.shopkick.app";
    protected static String launcherActivity = packageName + "." + "activity.AppScreenActivity";
    protected static String platformType = "Android";
    protected static String deviceUDID = "null";
    private static QaCalendar calendar = QaCalendar.getInstance();
    private static FileWriter fileWriter = null;
    private static AppiumManager appiumManager = new AppiumManager();
    private static JSONObject testLodgeJSON = new org.json.simple.JSONObject();
    private static JSONArray resultsList = new JSONArray();
    private static String buildNo = "1112";
    private static File userDir = new File(System.getProperty("user.dir"));
    @Rule
    public TestName name = new TestName();
    protected String elapsedSec = "";
    protected String runStatus = "failed";
    protected String testSectionName = "";
    protected String testName = "";
    private long startTime = 0;

    public BaseTestCase() {

    }

    public static AppiumDriver createAppiumDriver() {

        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, platformType);
            capabilities.setCapability("appActivity", launcherActivity);
            capabilities.setCapability("appPackage", packageName);
            capabilities.setCapability("noSign", true);
            capabilities.setCapability("newCommandTimeout", 7200);

            switch (platformType) {
                case "IOS": {
                    driver = appiumManager.createAndroidDriver(driver);

                    break;
                }
                case "Android": {
                    driver = appiumManager.createAndroidDriver(driver); //app lauched here
                    break;
                }
            }
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            log.info("SessionId: " + driver.getSessionId());
            PageFactory.initElements(new AppiumFieldDecorator(driver), new FirstUseDealsEducationPage());
        } catch (UnreachableBrowserException ube) {
            log.info(ube.getMessage());
            System.exit(1);
        } catch (SessionNotCreatedException e) {
            e.getMessage();
            System.exit(1);
        } catch (Exception e) {
            log.error(e);
            System.exit(1);
        }
        return driver;
    }

    public static void closeAppiumDriver() {

        try {
            if (driver != null) {
                log.info("Going to Quit Driver");
                driver.closeApp();
                driver.quit();
                driver = null;
            }
        } catch (Exception e) {
            log.error(e);
        }
    }

    @BeforeClass
    public static void createEnvironment() {
        try {
            createAppiumDriver();
            if (!file.exists()) {
                log.info(fileName + " doesn't exist : So creating it at " + filePath);
                file.createNewFile();
                log.info(fileName + " filed created ");
            }
            fileWriter = new FileWriter(filePath);
            testLodgeJSON.put("resultsList", resultsList);
            reportName = "Android" + "_" + calendar.getCurrentDate() + "_" + QaConstants.TEST_LODGE_RESULT_JSON;
            testLodgeJSON.put("reportName", reportName);
            log.info("reportName: " + reportName);
            testLodgeJSON.put("buildNo", buildNo);
            log.info("buildNo: " + "4.7.6");
        } catch (Exception e) {
            log.info(e);
        }
    }

    @AfterClass
    public static void tearDownEnvironment() {
        log.info("<--------- Start tearDownEnvironment() Test --------->");
        try {
            fileWriter.append(testLodgeJSON.toString());
            fileWriter.flush();
            fileWriter.close();
            log.info("testLodgeJSON JSON Created ");
        } catch (Exception e) {
            log.error(e);
        } finally {
            closeAppiumDriver();
            log.info("<--------- End tearDownEnvironment() Test --------->");
        }
    }

    @Before
    public void beforeMethod() {
        log.info("<--------- Start beforeMethod() Test ------------------------------------------------------>");
        try {
            runStatus = "failed";
            log.info("SessionID : " + driver.getSessionId());
            testName = "";
            testSectionName = "";
            startTime = System.currentTimeMillis(); // Get the start Time
        } catch (Exception e) {
            log.error(e);
        }
        log.info("<--------- End beforeMethod() Test --------------------------------------------------------->");
    }

    @After
    public void afterMethod() {
        log.info("<--------- Start afterMethod() Test --------------------------------------------------------->");
        try {
            log.info("SessionID : " + driver.getSessionId());
            JSONObject eachResult = new JSONObject();
            testName = name.getMethodName();
            long endTime = System.currentTimeMillis();
            long elapsed = (endTime - startTime) / 1000;
            eachResult.put("elapsed", elapsed);
            eachResult.put("testSectionName", testSectionName);
            eachResult.put("runStatus", runStatus);
            eachResult.put("testName", testName);
            resultsList.add(eachResult);
            log.info(testName + " : " + runStatus + " : Took " + elapsed + " Seconds ");
        } catch (Exception e) {
            log.error(e);
        }
        log.info("<--------- End afterMethod() Test --------------------------------------------------------->");
    }
}