package com.qa.shopkick.pages;

import com.qa.shopkick.appium.ScreenBaseClass;
import com.qa.shopkick.overlay.WalkInBubble;
import com.qa.shopkick.utils.CustomHooks;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Srikanth on 12/16/14.
 */
public class FirstUseRegistrationIntroPage extends ScreenBaseClass {


    final private static Logger log = Logger.getLogger((AccountSettings.class));
    @iOSFindBy(uiAutomator = ".buttons()[\"No, thanks\"]")
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/button_text\").text(\"NO, THANKS\")")
    private static MobileElement noThanksButton;

    @iOSFindBy(uiAutomator = ".buttons()[\"Sign Up/Sign In\"]")
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/button_text\").text(\"SIGN UP/SIGN IN\")")
    private static WebElement signUpOrSignInButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/button_text\")")
    private static WebElement createAccountButton;

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

    public static void CreateAccountButton() {
        try {
            createAccountButton.click();
            PageFactory.initElements(new AppiumFieldDecorator(driver), new WalkInBubble());
            //HACK , because we login as Guest by default via automation
            WalkInBubble.handleWalkBubble();
            CustomHooks.gotoSignInOrSignUp();
            waitFor(4);
            PageFactory.initElements(new AppiumFieldDecorator(driver), new CreateAccountPage());
            log.info("Create Account Button clicked ");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void clickLoginButton() {
        try {
            logInButton.click();
            PageFactory.initElements(new AppiumFieldDecorator(driver), new SignInPage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
