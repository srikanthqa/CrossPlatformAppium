package com.qa.shopkick.pages;

import com.qa.shopkick.utils.AbstractPage;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class NuxSignIn extends AbstractPage{
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/name\")")
	private static WebElement FullName;
	
	public static void clickOnFullName(){
		FullName.click();
	}
	
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/email\")")
	private static WebElement Email;
	
	public static void clickOnEmail(){
		Email.click();
	}
		
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/password\")")
	private static WebElement Password;
	
	public static void clickOnPassword(){
		Password.click();
	}
	
	
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/button_image\")")
	private static WebElement CreateAccount;
	
	public static void clickOnCreateAccount(){
		CreateAccount.click();
	}

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/button_text\")")
	private static WebElement ConnectWithFacebook;
	
	public static void clickOnConnectWithFacebook(){
		ConnectWithFacebook.click();
	}
	
}
