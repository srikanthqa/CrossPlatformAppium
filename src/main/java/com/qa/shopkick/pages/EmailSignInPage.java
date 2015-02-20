package com.qa.shopkick.pages;

import com.qa.shopkick.utils.AbstractPage;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class EmailSignInPage extends AbstractPage {

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/title_text\").text(\"Create your login information.\")")
	private static WebElement emailsigninCreateYourLoginInformation;

	//@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/email\").className(\"android.widget.EditText\").text(\"Email Address.\")")
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/email\").className(\"android.widget.EditText\")")
	private static WebElement emailsigninEmailAddress;
	
	private static MobileElement emailAddress = (MobileElement) driver.findElement(By.id("com.shopkick.app:id/email"));
			
	public static void clickEmailAddress(){
		emailAddress.click();
		emailAddress.clear();
		//emailsigninEmailAddress.click();
	}
	public static void enterNewEmailAddress(){
		
		emailAddress.sendKeys("trest1@sk.com");
		//emailsigninEmailAddress.sendKeys("trest1@sk.com");
	}

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/password\").text(\"Password.\")")
	private static WebElement emailsigninPassword;

	public static void clickPassword(){
		emailsigninPassword.click();
	}

	public static void enterPassword(){
		emailsigninPassword.sendKeys("sktest123");
		PageFactory.initElements(new AppiumFieldDecorator(driver),new EmailSignInPage());
	}

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/password_confirmation\")")
	private static WebElement emailConfirmPassword;

	public static void enterConfirmPassword(){
		emailConfirmPassword.click();
		emailConfirmPassword.sendKeys("sktest123");
		PageFactory.initElements(new AppiumFieldDecorator(driver),new EmailSignInPage());
	}


	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/button_text\").text(\"SIGN IN OR SIGN UP\")")
	private static WebElement emailsigninSignInOrSignUpButton;

	public static void clickSignInOrSignUpButton(){
		emailsigninSignInOrSignUpButton.click();
		PageFactory.initElements(new AppiumFieldDecorator(driver),new LinkPhonePage());
	}

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/first_name\").text(\"First name\")")
	private static WebElement emailSignUpFirstName;

	public static void clickAndEnterFirstName(){
		emailSignUpFirstName.click();
		emailSignUpFirstName.sendKeys("Name");
	}

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/last_name\").text(\"Last name\")")
	private static WebElement emailSignUpLastName;

	public static void clickAndEnterLastName(){
		emailSignUpLastName.click();
		emailSignUpLastName.sendKeys("Laster");
	}

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/forgot_password\").text(\"Forgot your password?\")")
	private static WebElement emailsigninForgotYourPassword;

	public static void clickemailsigninForgotYourPassword(){
		emailsigninForgotYourPassword.click();
	}


}
