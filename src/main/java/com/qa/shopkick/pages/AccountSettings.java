package com.qa.shopkick.pages;

import com.qa.shopkick.utils.ScreenBaseClass;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class AccountSettings extends ScreenBaseClass {

    final private static Logger log = Logger.getLogger((AccountSettings.class));
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/user_email_text\")")
    private static WebElement accountSettingsEmail;

    public static void clickAccountSettingsEmail() {
        accountSettingsEmail.click();
    }

    public static String getUserEmail() {
        try {
            String email = accountSettingsEmail.getText().toString();
            log.info("UserEmail " + email);
            pressBack();
            pressBack();
            return email;
        } catch (Exception e) {
            log.error(e);
            return "";
        }
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/update_phone_num_text\")")
    private static WebElement accountSettingsPhoneNumber;

    public static void clickUpdatePhoneNumber() {
        accountSettingsPhoneNumber.click();
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/update_zip_text\")")
    private static WebElement accountSettingsZipCode;

    public static void clickAccountSettingsZipCode() {
        accountSettingsZipCode.click();
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/button_text\").text(\"VERIFY YOUR PHONE NUMBER\")")
    private static WebElement accountSettingsVerifyPhoneNumber;

    public static void clickAccountSettingsVerifyPhoneNumber() {
        accountSettingsVerifyPhoneNumber.click();
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/button_text\").text(\"CHANGE PASSWORD\")")
    private static WebElement accountSettingsChangePassword;

    public static void clickAccountSettingsChangePassword() {
        accountSettingsChangePassword.click();
    }

    @iOSFindBy(uiAutomator = ".buttons()[\"Log Out\"]")
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/button_text\").text(\"LOG OUT\")")

    private static WebElement accountSettingsLogOut;

    public static void clickAccountSettingsLogOut() {
        accountSettingsLogOut.click();
        //initiate signInSignUp
        PageFactory.initElements(new AppiumFieldDecorator(driver), new SignInPage());
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/button_text\").text(\"DELETE ACCOUNT\")")
    @iOSFindBy(uiAutomator = ".buttons()[\"Delete Account\"]")
    private static WebElement accountSettingsDeleteAccount;

    public static void clickAccountSettingsDeleteAccount() {
        accountSettingsDeleteAccount.click();
        PageFactory.initElements(new AppiumFieldDecorator(driver), new DeleteAccountPage());
    }
}
