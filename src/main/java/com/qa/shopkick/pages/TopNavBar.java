package com.qa.shopkick.pages;

import com.qa.shopkick.appium.AbstractTestCase;
import com.qa.shopkick.appium.ScreenBaseClass;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by mmadhusoodan on 11/9/15.
 */
public class TopNavBar extends ScreenBaseClass {

    final private static Logger log = Logger.getLogger(TopNavBar.class);
    public static AppiumDriver driver = AbstractTestCase.driver;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/button_text\").text(\"GUEST\")")
    @iOSFindBy(uiAutomator = ".buttons()[\"guest username circle\"]")
    private static WebElement guestLeftNavBar;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/nav_header\")")
    protected static WebElement navHeader;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/kicks_counter\")")
    protected static WebElement kicksCounterIcon;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/heart\")")
    protected static WebElement heartIcon;


    public static boolean isNavHeaderDisplayed() {
        try {
            do {
                Thread.sleep(100);
            } while (!navHeader.isDisplayed());
            return true;
        } catch (Exception e) {
            log.info(e);
            return false;
        }
    }

    public static boolean isKicksCounterDisplayed() {
        try {
            do {
                Thread.sleep(100);
            } while (!kicksCounterIcon.isDisplayed());
            return true;
        } catch (Exception e) {
            log.info(e);
            return false;
        }
    }

    public static boolean isHeartIconDisplayed() {
        try {
            do {
                Thread.sleep(100);
            } while (!heartIcon.isDisplayed());
            return true;
        } catch (Exception e) {
            log.info(e);
            return false;
        }
    }

    public static void clickGuestUserButton() {

        guestLeftNavBar.click();
        PageFactory.initElements(new AppiumFieldDecorator(driver), new LeftNavBar());
    }

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
            } while (count == 10 || !userIcon.isDisplayed());
            return true;
        } catch (Exception e) {
            log.info(e);
            return false;
        }
    }


}
