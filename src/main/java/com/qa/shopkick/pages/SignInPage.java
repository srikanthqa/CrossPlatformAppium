package com.qa.shopkick.pages;

import com.qa.shopkick.utils.ScreenBaseClass;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class SignInPage extends ScreenBaseClass {
    final private static Logger log = Logger.getLogger((SignInPage.class));
    //@iOSFindBy()
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/title_text\").text(\"Choose your login method\").className(\"android.widget.TextView\")")
    @iOSFindBy(uiAutomator = ".staticTexts()[\"Sign in or sign up\"]")
    private static WebElement signInMethodText;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/button_text\").text(\"EMAIL\")")
    @iOSFindBy(uiAutomator = ".buttons()[\"Email\"]")
    private static WebElement signInEmailSignIn;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/button_text\").text(\"FACEBOOK\")")
    @iOSFindBy(uiAutomator = ".buttons()[\"Facebook\"]")
    private static MobileElement signInFacebookSignIn;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/button_text\").text(\"GOOGLE\")")
    @iOSFindBy(uiAutomator = ".buttons()[\"Google\"]")
    private static WebElement signInGooglePlusSignIn;

    public static boolean isFacebookLoginAvail() {
        if (signInFacebookSignIn.isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }

    public static void clickFacebookSignInButton() {
        try {
            signInFacebookSignIn.click();
            log.info("click  clickFacebookSignInButton");
            waitFor(5);
            PageFactory.initElements(new AppiumFieldDecorator(driver), new FacebookSignInPage());
        } catch (Exception e) {
            log.error(e);
        }
    }

    public static void clicksignInGooglePlusSignInButton() {
        try {
            signInGooglePlusSignIn.click();
            log.info("signInGooglePlusSignIn.click()");
            PageFactory.initElements(new AppiumFieldDecorator(driver), new LandingPage());
            PageFactory.initElements(new AppiumFieldDecorator(driver), new DidYouKnowPage());
        } catch (Exception e) {
            log.error(e);
        }
    }


    public static void clickSignInEmailSignInButton() {
        signInEmailSignIn.click();
        log.info("Click clickSignInEmailSignInButton");
        PageFactory.initElements(new AppiumFieldDecorator(driver), new EmailSignInPage());
        PageFactory.initElements(new AppiumFieldDecorator(driver), new EmailSignUp());
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/facebook_flow_text\").text(\"We will never post anything without your permission.\")")
    private static WebElement signInFacebookFlowText;

}
