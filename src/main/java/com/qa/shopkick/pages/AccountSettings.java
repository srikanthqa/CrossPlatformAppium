package com.qa.shopkick.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import com.qa.shopkick.utils.AbstractPage;

public class AccountSettings extends AbstractPage {
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/user_email_text\")")
	private static WebElement AccountSettingsEmail;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/update_phone_num_text\")")
	private static WebElement AccountSettingsPhoneNumber;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/update_zip_text\")")
	private static WebElement AccountSettingsZipCode;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/button_text\").text(\"VERIFY YOUR PHONE NUMBER\")")
	private static WebElement AccountSettingsVerifyPhoneNumber;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/button_text\").text(\"CHANGE PASSWORD\")")
	private static WebElement AccountSettingsChangePassword;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/button_text\").text(\"LOG OUT\")")
	private static WebElement AccountSettingsLogOut;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/button_text\").text(\"DELETE ACCOUNT\")")
	private static WebElement AccountSettingsDeleteAccount;
	
}
