package com.qa.shopkick.pages;

import com.qa.shopkick.appium.ScreenBaseClass;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class FirstUseAlternateScreen extends ScreenBaseClass {

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/skip_button\")")
    public static WebElement continueAsGuestButton;
    @iOSFindBy(uiAutomator = ".buttons()[\"Sign Up/Sign In\"]")
    private static WebElement iOsSignInSignUpButton;

    public static void clickOnContinueAsGuestButton() {
        continueAsGuestButton.click();
        PageFactory.initElements(new AppiumFieldDecorator(driver), new MicrophonePermissionPage());
        PageFactory.initElements(new AppiumFieldDecorator(driver), new LeftNavBar());
        PageFactory.initElements(new AppiumFieldDecorator(driver), new LandingPage());
    }

    public static void clickOnSingSignUp() {
        iOsSignInSignUpButton.click();
        PageFactory.initElements(new AppiumFieldDecorator(driver), new SignInPage());
    }
}
