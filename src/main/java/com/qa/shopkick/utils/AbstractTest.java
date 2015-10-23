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

import java.io.File;
import java.io.FileWriter;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AbstractTest {
    final private static Logger log = Logger.getLogger(String.valueOf(AbstractTest.class));
    private static QaCalendar calendar = QaCalendar.getInstance();
    private static int dCount = 1;
    private static String testrailDir = "testrail_scripts/";
    private static FileWriter fileWriter = null;
    private static String port = "4725";
    private long startTime = 0;
    private long endTime = 0;
    private long elapsed = 0;

    public TestName name = new TestName();
    protected String elapsedSec = "";
    protected String runStatus = "failed";
    protected String testSectionName = "";
    protected String testName = "";
    protected static String fileName = QaConstants.TEST_LODGE_FILE_JSON;
    protected static String testLodgeDir = "testLodge_scripts/";
    protected static String filePath = testLodgeDir + File.separator + fileName;
    protected static File file = new File(filePath);
    protected static String reportName = "";
    protected static AppiumDriver driver;
    //    private static JSONObject railsTestJSON = new org.json.simple.JSONObject();
    //    private static JSONArray resultsList = new JSONArray();

    //Commented for debug purpose
    //    public static String DeviceName=System.getProperty("deviceName");
    //    public static String PlatformType=System.getProperty("platformType");
    //    public static String PlatformVersion=System.getProperty("platformVersion");
    //    public static String DeviceUDID=System.getProperty("deviceUDID");

    protected static String PlatformType = "Android";
    protected static String DeviceName = "LGG3";
    protected static String PlatformVersion = "5.0.1";
    protected static String DeviceUDID = "null";
    protected static String ServerURL = "http://0.0.0.0:4723/wd/hub";
    protected static String BundleID = "com.shopkick.debug-qa";
    protected static String PackageName = "com.shopkick.app";
    protected static String LauncherActivity = PackageName + "." + "activity.AppScreenActivity";

    public static AppiumDriver createAppiumDriver() {
        log.info("Going to Create createAppiumDriver() ...");
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, DeviceName);
            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, PlatformType);
            capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, PlatformVersion);
            capabilities.setCapability("appActivity", LauncherActivity);
            capabilities.setCapability("appPackage", PackageName);
            capabilities.setCapability("noSign", true);
            capabilities.setCapability("newCommandTimeout", 7200);

            switch (PlatformType) {
                case "IOS": {
                    capabilities.setCapability("udid", DeviceUDID);
                    capabilities.setCapability("bundleId", BundleID);
                    driver = new IOSDriver(new URL(ServerURL), capabilities);
                    log.info("Created IOS Driver: " + dCount++);
                    log.info(driver.getTitle());
                    break;
                }
                case "Android": {
                    String apk = "Shopkick_debug_qa_ce22833c9da74fa6e98cb1e2cd23f9624b814266.apk";
                    log.info("using: " + apk);
                    log.info("Some times you got to play the waiting game    ");
                    File userDir = new File(System.getProperty("user.dir"));
                    File appDir = new File(userDir, "APK/");
                    File app = new File(appDir, apk);

                    capabilities.setCapability("app", app.getAbsolutePath());
                    driver = new AndroidDriver(new URL(ServerURL), capabilities);
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
     /*           try {
                    if (!file.exists()) {
                        log.info(fileName + " doesn't exist : So creating it at " + filePath);
                        file.createNewFile();
                        log.info(fileName + " filed created ");
                    }
                    fileWriter = new FileWriter(filePath);
                    railsTestJSON.put("resultsList", resultsList);
                    reportName = "" + "_" + calendar.getCaptureTime() + "_" + QaConstants.TEST_LODGE_FILE_JSON;
                    railsTestJSON.put("reportName", reportName);
                    log.info("reportName: " + reportName);

                                railsTestJSON.put("buildNo", QaProperties.getAPKVersion());

                                log.info("buildNo: " + QaProperties.getAPKVersion());


                } catch (IOException e) {
                    log.info(e);
                }
    */
    }

    @AfterClass
    public static void tearDown() {
        log.info("<--------- Start tearDown() Test --------->");
        try {
            //            fileWriter.append(railsTestJSON.toString());
            //            fileWriter.flush();
            //            fileWriter.close();
        } catch (Exception e) {
            log.error(e);
        }
        log.info("<--------- End tearDown() Test --------->");
    }

    @Before
    public void beforeMethod() {
        log.info("<--------- Start beforeMethod() Test ------------------------------------------------------>");
        try {
            createAppiumDriver();
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
            testName = name.getMethodName();
            endTime = System.currentTimeMillis(); // Get the end Time
            elapsed = (endTime - startTime) / 1000;
            //            eachResult.put("elapsed", elapsed);
            //            eachResult.put("testSectionName", testSectionName);
            //            eachResult.put("runStatus", runStatus);
            //            eachResult.put("testName", testName);
            //            resultsList.add(eachResult);
            log.info("runStatus = " + runStatus);
            log.info(testName + " : " + runStatus + " : " + elapsed + " Seconds ");
        } catch (Exception e) {
            log.error(e);
        } finally {
            log.info("Going to Quit Driver");
            driver.quit();
        }
        log.info("<--------- End afterMethod() Test --------------------------------------------------------->");
    }
}