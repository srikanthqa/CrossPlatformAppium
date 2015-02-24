package com.qa.shopkick.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.qa.shopkick.utils.AbstractPage;

public class ConfirmDeleteAccountPage extends AbstractPage{

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/app_screen_header\").text(\"Confirm Account Deletion\")")
	private static WebElement deleteAccountHeader;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/button_text\")text(\"DELETE\")")
	private static WebElement deleteAccountButton;
	
	public static void clickOnDeleteAccountConfirm(){
		deleteAccountButton.click();
		PageFactory.initElements(new AppiumFieldDecorator(driver),new SignInPage());
	}
	
}
