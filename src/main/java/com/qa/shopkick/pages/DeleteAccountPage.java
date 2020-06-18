package com.qa.shopkick.pages;

import com.qa.shopkick.appium.ScreenBaseClass;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class DeleteAccountPage extends ScreenBaseClass {

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/app_screen_header\").text(\"Delete Your Account\")")
    private static WebElement deleteAccountHeader;

    @iOSFindBy(uiAutomator = ".secureTextFields().firstWithPredicate(\"value like 'Confirm using password'")
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/delete_acct_password\")")
    private static WebElement deleteConfirmWithPassword;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/right_header_delete_account_next\")")
    @iOSFindBy(uiAutomator = ".buttons()[\"forward arrow v2\"]")
    private static WebElement deleteAccountButton;

    public static void clickAndDeleteAccountWithPassword() {
        deleteConfirmWithPassword.click();
        deleteConfirmWithPassword.clear();
        deleteConfirmWithPassword.sendKeys("sktest123");
    }

    public static void clickToProceedDelete() {
        deleteAccountButton.click();
        PageFactory.initElements(new AppiumFieldDecorator(driver), new ConfirmDeleteAccountPage());
    }

}
