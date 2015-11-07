package com.qa.shopkick.pages;

import com.qa.shopkick.appium.ScreenBaseClass;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.NoSuchElementException;

/**
 * Created by Srikanth on 12/16/14.
 */
public class CountryPickerPage extends ScreenBaseClass {

    final private static Logger log = Logger.getLogger((CountryPickerPage.class));

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/select_germany\")")
    @iOSFindBy(uiAutomator = ".buttons()[2]")
    private static WebElement countryGermany;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/select_usa\")")
    @iOSFindBy(uiAutomator = ".buttons()[3]")
    private static WebElement countryUSA;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/button_image\")")
    @iOSFindBy(uiAutomator = ".buttons()[\"Next\"]")
    private static WebElement nextButton;

    @iOSFindBy(uiAutomator = ".staticTexts()[\"Tell us where you want to see deals.\"]")
    private static MobileElement countryPickerText;

    public static boolean isCountryPickerPresent() {
        boolean flag = false;
        try {
            if (countryGermany.isDisplayed() && countryUSA.isDisplayed()) {
                flag = true;
                log.info("Country picker found ");
            }
        } catch (NoSuchElementException e) {
            log.info("Country Picker not found Cool");
            return false;
        } catch (Exception e) {
            return false;
        }
        return flag;
    }


    public static void clickCountryUSA() {
        countryUSA.click();
    }

    public static void clickCountryGermany() {
        countryGermany.click();
    }

    public static void clickNextButton() {
        try {
            nextButton.click();
            PageFactory.initElements(new AppiumFieldDecorator(driver), new FirstUseWalkinEducationPage());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //Check if both the items are present
    public static boolean clickAndProceedUSA() {
        try {
            if (countryGermany.isDisplayed() && countryUSA.isDisplayed()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
