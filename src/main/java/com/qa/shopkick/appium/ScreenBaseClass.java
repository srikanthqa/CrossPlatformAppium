package com.qa.shopkick.appium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

/**
 * Created by Manish on 10/28/15.
 */
public class ScreenBaseClass {

    final private static Logger log = Logger.getLogger(ScreenBaseClass.class);
    public static AppiumDriver driver = AbstractTestCase.driver;

    public ScreenBaseClass() {
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/button_text\")")
    protected static WebElement guestIcon;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/button_image\")")
    protected static WebElement userIcon;
    //com.shopkick.app:id/button_image

    public static boolean waitTillGuestIconPresent() {
        try {
            do {
                Thread.sleep(300);
            } while (!guestIcon.isDisplayed());
            return true;
        } catch (Exception e) {
            log.info(e);
            return false;
        }
    }

    public static boolean waitTillUserIconPresent() {
        try {
            int count = 0;
            do {
                Thread.sleep(300);
            } while (count == 10 || userIcon.isDisplayed());
            return true;
        } catch (Exception e) {
            log.info(e);
            return false;
        }
    }

    public static void pressBack() {
        log.info("pressBack");
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
