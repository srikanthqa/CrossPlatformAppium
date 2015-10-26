package com.qa.shopkick.utils;

import com.qa.shopkick.pages.FirstUseDealsEducationPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.log4j.Logger;
import org.junit.*;
import org.junit.rules.TestName;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AbstractTest {
    final private static Logger log = Logger.getLogger(String.valueOf(AbstractTest.class));
    private static QaCalendar calendar = QaCalendar.getInstance();
    private static int dCount = 1;
    private static FileWriter fileWriter = null;
    private static String port = "4723";
    private long startTime = 0;

    @Rule
    public TestName name = new TestName();
    protected String elapsedSec = "";
    protected String runStatus = "failed";
    protected String testSectionName = "";
    protected String testName = "";
    protected static String fileName = QaConstants.TEST_LODGE_FILE_JSON;
    protected static String testLodgeDir = "testLodge_script";
    protected static String filePath = testLodgeDir + File.separator + fileName;
    protected static File file = new File(filePath);
    protected static String reportName = "";
    protected static AppiumDriver driver;
    private static JSONObject testLodgeJSON = new org.json.simple.JSONObject();
    private static JSONArray resultsList = new JSONArray();

    //Commented for debug purpose
    public static String deviceName = System.getProperty("deviceName");
    public static String platformType = System.getProperty("platformType");
    public static String platformVersion = System.getProperty("platformVersion");
    public static String deviceUDID = System.getProperty("deviceUDID");

    //    protected static String platformType = "Android";
    //    protected static String deviceName = "LGG3";
    //    protected static String platformVersion = "5.0.1";
    //    protected static String deviceUDID = "null";

    protected static String serverURL = "http://0.0.0.0:" + port + "/wd/hub";
    protected static String bundleID = "com.shopkick.debug-qa";
    protected static String packageName = "com.shopkick.app";
    protected static String launcherActivity = packageName + "." + "activity.AppScreenActivity";

    public static AppiumDriver createAppiumDriver() {
        log.info("Going to Create createAppiumDriver() ...");
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, platformType);
            capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);
            capabilities.setCapability("appActivity", launcherActivity);
            capabilities.setCapability("appPackage", packageName);
            capabilities.setCapability("noSign", true);
            capabilities.setCapability("newCommandTimeout", 7200);

            switch (platformType) {
                case "IOS": {
                    capabilities.setCapability("udid", deviceUDID);
                    capabilities.setCapability("bundleId", bundleID);
                    driver = new IOSDriver(new URL(serverURL), capabilities);
                    log.info("Created IOS Driver: " + dCount++);
                    log.info(driver.getTitle());
                    break;
                }
                case "Android": {

                    log.info(platformType + " : " + deviceName + " : " + platformVersion);
                    String apk = "Shopkick_debug_qa_e80a4cd5f375938343f5a8f91d51763b6339c89f.apk";
                    log.info("using: " + apk);
                    log.info("Some times you got to play the waiting game    ");
                    File userDir = new File(System.getProperty("user.dir"));
                    File appDir = new File(userDir, "APK/");
                    File app = new File(appDir, apk);

                    capabilities.setCapability("app", app.getAbsolutePath());
                    //Don't create driver for subsequent tests. As appium server is still running
                    //                    if (driver == null)
                    driver = new AndroidDriver(new URL(serverURL), capabilities);
                    log.info("Created Android Driver: " + dCount++);
                    break;
                }
            }
            log.info("Now Installing .... so hold your Horses:");
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            PageFactory.initElements(new AppiumFieldDecorator(driver), new FirstUseDealsEducationPage());
        } catch (SessionNotCreatedException e) {
            log.info(e);
            System.exit(1);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
        return driver;
    }

    @BeforeClass
    public static void createEnvironment() {
        //        createAppiumDriver();
        try {
            if (!file.exists()) {
                log.info(fileName + " doesn't exist : So creating it at " + filePath);
                file.createNewFile();
                log.info(fileName + " filed created ");
            }
            fileWriter = new FileWriter(filePath);
            testLodgeJSON.put("resultsList", resultsList);
            reportName = "Android" + "_" + calendar.getCurrentDate() + "_" + QaConstants.TEST_LODGE_FILE_JSON;
            testLodgeJSON.put("reportName", reportName);
            log.info("reportName: " + reportName);
            testLodgeJSON.put("buildNo", "1112");
            log.info("buildNo: " + "4.7.6");
        } catch (IOException e) {
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
            log.info("Result JSON Created ");
        } catch (Exception e) {
            log.error(e);
        } finally {
            if (driver != null) {
                log.info("Going to Quit Driver");
                driver.quit();
            }
            log.info("<--------- End tearDownEnvironment() Test --------->");
        }
    }

    @Before
    public void beforeMethod() {
        log.info("<--------- Start beforeMethod() Test ------------------------------------------------------>");
        try {
            createAppiumDriver();
            //Initialize all the variables
            runStatus = "failed";
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
            JSONObject eachResult = new org.json.simple.JSONObject();
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
        } finally {
            log.info("Going to Quit Driver");
            driver.quit();
        }
        log.info("<--------- End afterMethod() Test --------------------------------------------------------->");
    }
}