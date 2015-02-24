package com.qa.shopkick.pages;

import com.qa.shopkick.utils.AbstractPage;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class DeleteAccountPage extends AbstractPage{

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/app_screen_header\").text(\"Delete Your Account\")")
	private static WebElement deleteAccountHeader;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/delete_acct_password\")")
	private static WebElement deleteConfirmWithPassword;
		
	public static void clickAndDeleteAccountWithPassword(){
		deleteConfirmWithPassword.click();
		deleteConfirmWithPassword.clear();
		deleteConfirmWithPassword.sendKeys("sktest123");
	}
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/right_header_delete_account_next\")")
	private static WebElement deleteAccountButton;
	
	public static void clickToProceedDelete(){
		deleteAccountButton.click();
		//init next page
		PageFactory.initElements(new AppiumFieldDecorator(driver),new ConfirmDeleteAccountPage());
	}
	
}
