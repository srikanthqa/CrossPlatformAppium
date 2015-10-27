package com.qa.shopkick.pages;

import com.qa.shopkick.utils.ScreenBaseClass;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class NuxSignIn extends ScreenBaseClass {
	
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
