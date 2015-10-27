package com.qa.shopkick.pages;

import com.qa.shopkick.utils.AbstractPage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Srikanth on 12/16/14.
 */
public class FirstUseRegistrationIntroPage extends AbstractPage {

    @iOSFindBy(uiAutomator = ".buttons()[\"No, thanks\"]")
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/button_text\").text(\"NO, THANKS\")")
    private static MobileElement noThanksButton;

    @iOSFindBy(uiAutomator = ".buttons()[\"Sign Up/Sign In\"]")
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/button_text\").text(\"SIGN UP/SIGN IN\")")
    private static WebElement signUpOrSignInButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/login\").text(\"Have an account? Log In\")")
    private static WebElement logInButton;

    public static boolean isItLegacySignUpScreen() {
        if (noThanksButton.isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }

    public static void clickNoThanksButton() {
        noThanksButton.click();
        PageFactory.initElements(new AppiumFieldDecorator(driver), new MicrophonePermissionPage());
        PageFactory.initElements(new AppiumFieldDecorator(driver), new LeftNavBar());
    }

    public static void clickSignUpOrSignInButton() {
        try {
            signUpOrSignInButton.click();
            PageFactory.initElements(new AppiumFieldDecorator(driver), new SignInPage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void clickLoginButton() {
        logInButton.click();
        PageFactory.initElements(new AppiumFieldDecorator(driver), new SignInPage());
    }

}
