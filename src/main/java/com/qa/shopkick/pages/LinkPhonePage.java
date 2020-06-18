package com.qa.shopkick.pages;

import com.qa.shopkick.appium.ScreenBaseClass;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LinkPhonePage extends ScreenBaseClass {

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/title_text\").text(\"Link your phone to your account\")")
    private static WebElement linkPhoneTitleText;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/phone_number\")")
    @iOSFindBy(uiAutomator = ".textFields().firstWithPredicate(\"value like 'Phone Number'\")")
    private static WebElement enterPhoneToLink;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/zip_code\").text(\"Zip Code\")")
    @iOSFindBy(uiAutomator = ".textFields().firstWithPredicate(\"value like 'Zip Code'\")")
    private static WebElement enterZipCode;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/button_text\").text(\"COMPLETE REGISTRATION\")")
    @iOSFindBy(uiAutomator = ".buttons()[\"Complete registration\"]")
    private static WebElement completeRegistration;

    public static void clickAndEnterPhoneNumber(String ph) {
        try {
            enterPhoneToLink.click();
            enterPhoneToLink.clear();
            enterPhoneToLink.sendKeys(ph);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void clickAndEnterZipcode() {
        try {
            enterZipCode.click();
            enterZipCode.sendKeys("94040");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void clickOnCompleteRegistration() {
        try {
            if (completeRegistration.isEnabled())
                completeRegistration.click();
            waitFor(5);
            PageFactory.initElements(new AppiumFieldDecorator(driver), new VerifyMobileNumber());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
