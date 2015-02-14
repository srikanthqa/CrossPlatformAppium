package com.qa.shopkick.pages;

import com.qa.shopkick.utils.AbstractPage;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class SignInPage extends AbstractPage {
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/title_text\").text(\"Sign in or sign up\")")
	private static WebElement signInOrSignUp;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/button_text\").text(\"FACEBOOK\")")
	private static WebElement signInFacebookSignIn;
	
	public static void clicksignInFacebookSignIn(){
		signInFacebookSignIn.click();
	}
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/button_text\").text(\"GOOGLE\")")
	private static WebElement signInGooglePlusSignIn;
	
	public static void clicksignInGooglePlusSignIn(){
		signInGooglePlusSignIn.click();
	}
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/button_text\").text(\"EMAIL\")")
	private static WebElement signInEmailSignIn;
	
	public static void clicksignInEmailSignIn(){
		signInEmailSignIn.click();
		PageFactory.initElements(new AppiumFieldDecorator(driver),new EmailSignInPage());
	}
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/facebook_flow_text\").text(\"We will never post anything without your permission.\")")
	private static WebElement signInFacebookFlowText;
	
}
