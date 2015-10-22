package com.qa.shopkick.utils;

import com.qa.shopkick.pages.FirstUseDealsEducationPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AbstractTest {
    final private static Logger log = Logger.getLogger(String.valueOf(AbstractTest.class));

    @Rule
    public TestName name = new TestName();
    public static AppiumDriver driver;
    public String elapsedSec = "";
    protected String runStatus = "failed";
    protected String testSectionName = "";
    protected String testName = "";
    protected static String fileName = QaConstants.TEST_LODGE_FILE_JSON;
    private static String testLodgeDir = "testrail_scripts/";
    protected static String filePath = testLodgeDir + File.separator + fileName;
    protected static File file = new File(filePath);

//    private static JSONObject railsTestJSON = new org.json.simple.JSONObject();
//    private static JSONArray resultsList = new JSONArray();
    private static QaCalendar calendar = QaCalendar.getInstance();
    private static String testrailDir = "testrail_scripts/";
    private static FileWriter fileWriter = null;
    private static String port = "4725";

    //Commented for debug purpose
    //    public static String DeviceName=System.getProperty("deviceName");
    //    public static String PlatformType=System.getProperty("platformType");
    //    public static String PlatformVersion=System.getProperty("platformVersion");
    //    public static String DeviceUDID=System.getProperty("deviceUDID");

    public static String DeviceName = "LGD";
    public static String PlatformType = "Android";
    public static String PlatformVersion = "4.4.2";
    public static String DeviceUDID = "null";

    public static String ServerURL = "http://0.0.0.0:4723/wd/hub";
    public static String BundleID = "com.shopkick.debug-qa";
    public static String PackageName = "com.shopkick.app";
    public static String LauncherActivity = PackageName + "." + "activity.AppScreenActivity";

    public static AppiumDriver createAppiumDriver() {

        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, DeviceName);
            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, PlatformType);
            capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, PlatformVersion);
            capabilities.setCapability("newCommandTimeout", 7200);

            switch (PlatformType) {
                case "IOS": {
                    capabilities.setCapability("udid", DeviceUDID);
                    capabilities.setCapability("bundleId", BundleID);
                    driver = new IOSDriver(new URL(ServerURL), capabilities);
                    log.info("Created IOS Driver");
                    break;
                }
                case "Android": {
                    capabilities.setCapability("appActivity", LauncherActivity);
                    capabilities.setCapability("appPackage", PackageName);
                    capabilities.setCapability("noSign", true);

                    driver = new AndroidDriver(new URL(ServerURL), capabilities);
                    log.info("Created Android Driver");
                    break;
                }
            }

            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            PageFactory.initElements(new AppiumFieldDecorator(driver), new FirstUseDealsEducationPage());
        } catch (UnreachableBrowserException ube) {
            log.info(ube);
            System.exit(1);
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

        String reportName = "";
        try {
            if (!file.exists()) {
                log.info(fileName + " doesn't exist : So creating it at " + filePath);
                file.createNewFile();
                log.info(fileName + " filed created ");
            }
            fileWriter = new FileWriter(filePath);
//            railsTestJSON.put("resultsList", resultsList);
//            reportName = "" + "_" + calendar.getCaptureTime() + "_" + QaConstants.TEST_LODGE_FILE_JSON;
//            railsTestJSON.put("reportName", reportName);
//            log.info("reportName: " + reportName);

            //            railsTestJSON.put("buildNo", QaProperties.getAPKVersion());
            //
            //            log.info("buildNo: " + QaProperties.getAPKVersion());

            createAppiumDriver();

        } catch (IOException e) {
            log.info(e);
        }
    }

    @AfterClass
    public static void tearEnvironment() {
        //driver.quit();
        //driver.resetApp();

    }
}
