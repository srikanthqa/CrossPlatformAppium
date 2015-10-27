package com.qa.shopkick.utils;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Srikanth on 12/16/14.
 */
public class ScreenBaseClass {

    protected static AppiumDriver driver = AbstractTest.driver;

    public ScreenBaseClass() {

    }

    public ScreenBaseClass(AppiumDriver driver) {

        this.driver = driver;
        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
    }


    public static void pressBack() {
        driver.navigate().back();
    }

    public static void waitFor(int seconds) {
        int millSeconds = seconds * 1000;
        try {
            Thread.sleep(millSeconds);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
