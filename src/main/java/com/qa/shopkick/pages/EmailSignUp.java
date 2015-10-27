package com.qa.shopkick.pages;

import com.qa.shopkick.utils.ScreenBaseClass;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class EmailSignUp extends ScreenBaseClass {
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/title_text\").text(\"Create your login information.\")")
	private static WebElement emailsigninCreateYourLoginInformation;
	
	@iOSFindBy(uiAutomator = ".textFields().firstWithPredicate(\"value like 'Email Address'\")")
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/email\").text(\"Email Address.\")")
	private static WebElement emailsigninEmailAddress;
	
	public static void clickEmailSigninEmailAddress(){
		emailsigninEmailAddress.click();
	}
	
	@iOSFindBy(uiAutomator = ".textFields().firstWithPredicate(\"value like 'Password'\")")
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/password\").text(\"Password.\")")
	private static WebElement emailsigninPassword;
	
	public static void clickEmailSigninPassword(){
		emailsigninPassword.click();
	}
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/password_confirmation\").text(\"Confirm Password.\")")
	private static WebElement emailsigninConfirmPassword;
	
	public static void emailSigninConfirmPassword(){
		emailsigninConfirmPassword.click();
	}

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/first_name\").text(\"First name.\")")
	private static WebElement emailsigninFirstName;
	
	public static void emailSigninFirstName(){
		emailsigninFirstName.click();
	}
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/last_name\").text(\"Last name.\")")
	private static WebElement emailsigninLastName;
	
	public static void emailSigninLastName(){
		emailsigninLastName.click();
	}
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/button_text\").text(\"SIGN UP\")")
	private static WebElement emailsigninSignUpButton;
	
	public static void clickEmailSignUpButton(){
		emailsigninSignUpButton.click();
	}
	
	public static void clickOnSignUpButton(){
		MobileElement signUpSubmitButton = (MobileElement) driver.findElement(By.id("com.shopkick.app:id/submit"));
		signUpSubmitButton.click();
	}
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/forgot_password\").text(\"Forgot your password?\")")
	private static WebElement emailsigninForgotYourPassword;
	
	public static void clickEmailSigninForgotYourPassword(){
		emailsigninForgotYourPassword.click();
	}
	
	
}
