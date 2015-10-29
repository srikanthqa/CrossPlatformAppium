package com.qa.shopkick.pages;

import com.qa.shopkick.appium.ScreenBaseClass;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Srikanth on 12/16/14.
 */
public class MicrophonePermissionPage extends ScreenBaseClass {

    @iOSFindBy(uiAutomator = ".buttons()[\"OK\"]")
    private static WebElement okButton;

    public static boolean isMicroPhonePermissionRequired() {

        if (okButton.isDisplayed()) {
            return true;
        } else {
            return false;
        }

    }

    public static void clickOKButton() {
        okButton.click();
        PageFactory.initElements(new AppiumFieldDecorator(driver), new LandingPage());
    }
}
