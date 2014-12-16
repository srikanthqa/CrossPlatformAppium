package com.qa.shopkick.pages;

import com.qa.shopkick.utils.AbstractPage;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Srikanth on 12/16/14.
 */
public class FirstUseRegistrationIntroPage extends AbstractPage{

    @iOSFindBy(uiAutomator = ".buttons()[\"No, thanks\"]")
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/button_text\").text(\"NO, THANKS\")")
    private static WebElement noThanksButton;

    @iOSFindBy(uiAutomator = ".buttons()[\"Sign Up/Sign In\"]")
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/button_text\").text(\"SIGN UP/SIGN IN\")")
    private static WebElement signUpOrSignInButton;

    public static void clickNoThanksButton(){
        noThanksButton.click();
        PageFactory.initElements(new AppiumFieldDecorator(driver),new MicrophonePermissionPage());
    }

    public static void clickSignUpOrSignInButton(){
        signUpOrSignInButton.click();
    }


}
