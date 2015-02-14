package com.qa.shopkick.pages;

import com.qa.shopkick.utils.AbstractPage;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class EmailSignInPage extends AbstractPage {
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/title_text\").text(\"Create your login information.\")")
	private static WebElement emailsigninCreateYourLoginInformation;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/email\").text(\"Email Address.\")")
	private static WebElement emailsigninEmailAddress;
	
	public static void clickemailsigninEmailAddress(){
		emailsigninEmailAddress.click();
	}
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/password\").text(\"Password.\")")
	private static WebElement emailsigninPassword;
	
	public static void clickemailsigninPassword(){
		emailsigninPassword.click();
	}
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/button_text\").text(\"SIGN IN OR SIGN UP\")")
	private static WebElement emailsigninSignInOrSignUpButton;
	
	public static void clickemailsigninSignInOrSignUpButton(){
		emailsigninSignInOrSignUpButton.click();
	}
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/forgot_password\").text(\"Forgot your password?\")")
	private static WebElement emailsigninForgotYourPassword;
	
	public static void clickemailsigninForgotYourPassword(){
		emailsigninForgotYourPassword.click();
	}
	

}
