package com.qa.shopkick.pages;

import com.qa.shopkick.appium.ScreenBaseClass;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class NuxSignIn extends ScreenBaseClass {

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/name\")")
    private static WebElement FullName;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/email\")")
    private static WebElement Email;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/password\")")
    private static WebElement Password;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/button_image\")")
    private static WebElement CreateAccount;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/button_text\")")
    private static WebElement ConnectWithFacebook;

    public static void clickOnFullName() {
        FullName.click();
    }

    public static void clickOnEmail() {
        Email.click();
    }

    public static void clickOnPassword() {
        Password.click();
    }

    public static void clickOnCreateAccount() {
        CreateAccount.click();
    }

    public static void clickOnConnectWithFacebook() {
        ConnectWithFacebook.click();
    }

}
