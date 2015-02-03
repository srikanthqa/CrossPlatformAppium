package com.qa.shopkick.utils;

import com.qa.shopkick.pages.FirstUseDealsEducationPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by Srikanth on 12/16/14.
 */
public class AbstractTest {
    public static AppiumDriver driver;
    public static String DeviceName=System.getProperty("deviceName");
    public static String PlatformType=System.getProperty("platformType");
    public static String PlatformVersion=System.getProperty("platformVersion");
    public static String DeviceUDID=System.getProperty("deviceUDID");
    public static String ServerURL="http://0.0.0.0:4723/wd/hub";
    public static String BundleID="com.shopkick.debug-qa";
    public static String PackageName="com.shopkick.app";
    public static String LauncherActivity="com.shopkick.app.activity.AppScreenActivity";

    @BeforeClass
    public static void createEnvironment(){
        DesiredCapabilities capabilities=new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,DeviceName);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,PlatformType);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,PlatformVersion);
        if(PlatformType.equalsIgnoreCase("IOS")){
            capabilities.setCapability("udid",DeviceUDID);
            capabilities.setCapability("bundleId",BundleID);
            try {
                driver=new IOSDriver(new URL(ServerURL),capabilities);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }else if(PlatformType.equalsIgnoreCase("Android")){
            capabilities.setCapability("appActivity",LauncherActivity);
            capabilities.setCapability("appPackage",PackageName);
            try {
                driver=new AndroidDriver(new URL(ServerURL),capabilities);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        PageFactory.initElements(new AppiumFieldDecorator(driver), new FirstUseDealsEducationPage());
        
    }

    @AfterClass
    public static void tearEnvironment(){
        driver.quit();
    }
}
