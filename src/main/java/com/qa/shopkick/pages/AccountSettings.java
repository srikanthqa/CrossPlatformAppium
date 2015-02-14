package com.qa.shopkick.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import com.qa.shopkick.utils.AbstractPage;

public class AccountSettings extends AbstractPage {
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/user_email_text\")")
	private static WebElement AccountSettingsEmail;
	
	public static void clickAccountSettingsEmail(){
		AccountSettingsEmail.click();
	}
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/update_phone_num_text\")")
	private static WebElement AccountSettingsPhoneNumber;
	
	public static void clickUpdatePhoneNumber(){
		AccountSettingsEmail.click();
	}
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/update_zip_text\")")
	private static WebElement AccountSettingsZipCode;
	
	public static void clickAccountSettingsZipCode(){
		AccountSettingsZipCode.click();
	}
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/button_text\").text(\"VERIFY YOUR PHONE NUMBER\")")
	private static WebElement AccountSettingsVerifyPhoneNumber;
	
	public static void clickAccountSettingsVerifyPhoneNumber(){
		AccountSettingsVerifyPhoneNumber.click();
	}
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/button_text\").text(\"CHANGE PASSWORD\")")
	private static WebElement AccountSettingsChangePassword;
	
	public static void clickAccountSettingsChangePassword(){
		AccountSettingsChangePassword.click();
	}
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/button_text\").text(\"LOG OUT\")")
	private static WebElement AccountSettingsLogOut;
	
	public static void clickAccountSettingsLogOut(){
		AccountSettingsLogOut.click();
	}
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/button_text\").text(\"DELETE ACCOUNT\")")
	private static WebElement AccountSettingsDeleteAccount;
	
	public static void clickAccountSettingsDeleteAccount(){
		AccountSettingsDeleteAccount.click();
	}
}
