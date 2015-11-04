package com.qa.shopkick.appium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by mmadhusoodan on 10/26/15.
 */
public class AppiumManager {
    final private static Logger log = Logger.getLogger(AppiumManager.class);
    //Commented for debug purpose
    public static String deviceName = System.getProperty("deviceName");
    public static String platformType = System.getProperty("platformType");
    public static String platformVersion = System.getProperty("platformVersion");
    public static String deviceUDID = System.getProperty("deviceUDID");
    protected static String appPackage = "com.shopkick.app";
    protected static String appActivity = appPackage + "." + "activity.AppScreenActivity";
    protected static String bundleID = "com.shopkick.debug-qa";
    //    protected static String deviceName = "S5";
    //    protected static String platformVersion = "5.0.1";
    private static String ipAddress = "http://127.0.0.1:";
    private static String port = "4723";
    private static int dCount = 0;
    private DesiredCapabilities capabilities = new DesiredCapabilities();

    /**
     * Create Android Driver port and APK name
     */
    public AppiumDriver createAndroidDriver(AppiumDriver driver) {
        dCount++;
        try {
            log.info("Going to Create createAppiumDriver() ..." + dCount + " time ");
            File userDir = new File(System.getProperty("user.dir"));
            File appDir = new File(userDir, "APK/");
            String apk = "Shopkick_debug_qa_70b2e40ff42f020af518358c84000b07f7dbc793.apk";
            log.info("Using: " + apk);
            File app = new File(appDir, apk);
            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("deviceName", deviceName);
            capabilities.setCapability("app", app.getAbsolutePath());
            capabilities.setCapability(CapabilityType.VERSION, "");
            capabilities.setCapability("app-package", appPackage);
            capabilities.setCapability("app-activity", appActivity);
            capabilities.setCapability("newCommandTimeout", 7200);

            log.info("Android" + " : " + deviceName + " : " + platformVersion);
            log.info("Wait till the App gets installed .... ");
            if (null == driver || driver.getSessionId() == null)
                driver = new AndroidDriver(new URL(ipAddress + port + "/wd/hub"), capabilities);
            log.info("Created Android Driver SessionId: " + driver.getSessionId());
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
        return driver;
    }

    /**
     * Commented for Now Untill further notice
     * Create IOS Driver
     */
    public AppiumDriver createIOSDriver(AppiumDriver driver) {
        //        dCount++;
        //        try {
        //            log.info("Going to Create createAppiumDriver() ..." + dCount + " time ");
        //            File userDir = new File(System.getProperty("username.dir"));
        //            File appDir = new File(userDir, "APK/");
        //            String ipa = "Shopkick_release_production_v_4_7_6_Beta2.ipa";
        //            log.info("Using: " + ipa);
        //            log.info("Some times you got to play the waiting game    ");
        //            File app = new File(appDir, ipa);
        //
        //            capabilities.setCapability("platformName", "Android");
        //            capabilities.setCapability("app", app.getAbsolutePath());
        //            capabilities.setCapability(CapabilityType.VERSION, "");
        //            capabilities.setCapability("app-package", appPackage);
        //            capabilities.setCapability("app-activity", appActivity);
        //            capabilities.setCapability("newCommandTimeout", 7200);
        //
        //            log.info("IOS" + " : " + deviceName + " : " + platformVersion);
        //            driver = new AndroidDriver(new URL(ipAddress + port + "/wd/hub"), capabilities);
        //            log.info("Created Android Driver SessionId: " + driver.getSessionId());
        //            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //        } catch (Exception e) {
        //            log.error(e);
        //            System.exit(1);
        //        }
        return driver;
    }
}