package com.qa.shopkick.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import com.qa.shopkick.utils.AbstractPage;

public class AccountSettings extends AbstractPage {

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/user_email_text\")")
	private static WebElement accountSettingsEmail;

	public static void clickAccountSettingsEmail(){
		accountSettingsEmail.click();
	}

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/update_phone_num_text\")")
	private static WebElement accountSettingsPhoneNumber;

	public static void clickUpdatePhoneNumber(){
		accountSettingsEmail.click();
	}

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/update_zip_text\")")
	private static WebElement accountSettingsZipCode;

	public static void clickAccountSettingsZipCode(){
		accountSettingsZipCode.click();
	}

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/button_text\").text(\"VERIFY YOUR PHONE NUMBER\")")
	private static WebElement accountSettingsVerifyPhoneNumber;

	public static void clickAccountSettingsVerifyPhoneNumber(){
		accountSettingsVerifyPhoneNumber.click();
	}

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/button_text\").text(\"CHANGE PASSWORD\")")
	private static WebElement accountSettingsChangePassword;

	public static void clickAccountSettingsChangePassword(){
		accountSettingsChangePassword.click();
	}

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/button_text\").text(\"LOG OUT\")")
	private static WebElement accountSettingsLogOut;

	public static void clickAccountSettingsLogOut(){
		accountSettingsLogOut.click();
	}

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/button_text\").text(\"DELETE ACCOUNT\")")
	private static WebElement accountSettingsDeleteAccount;

	public static void clickAccountSettingsDeleteAccount(){
		accountSettingsDeleteAccount.click();
	}
}
