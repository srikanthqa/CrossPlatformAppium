package com.qa.shopkick.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.NetworkConnectionSetting;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

/**
 * Created by Srikanth on 12/17/14.
 */
public class NetworkTest {

    //Only work for Android

    public static void main(String[] args) throws Exception{
        DesiredCapabilities capabilities=new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"SAMSUNG-SM-G900A");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"4.4.2");
        //capabilities.setCapability("udid","3cf2131efb10bb528591697f6981b075ff5a6af7");
        //capabilities.setCapability("bundleId","com.shopkick.debug-qa");
        capabilities.setCapability("appActivity","com.shopkick.app.activity.AppScreenActivity");
        capabilities.setCapability("appPackage","com.shopkick.app");
        AppiumDriver driver=new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),capabilities);
        //NetworkConnectionSetting nc=new NetworkConnectionSetting(true,true,true);
        NetworkConnectionSetting nc=((AndroidDriver)driver).getNetworkConnection();
        nc.setAirplaneMode(true);
        ((AndroidDriver) driver).setNetworkConnection(nc);

        Thread.sleep(5000);
        driver.quit();

    }
}
