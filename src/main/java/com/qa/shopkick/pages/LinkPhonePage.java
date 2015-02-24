package com.qa.shopkick.pages;

import static junit.framework.TestCase.assertTrue;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.qa.shopkick.utils.AbstractPage;

public class LinkPhonePage extends AbstractPage{

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/title_text\").text(\"Link your phone to your account\")")
	private static WebElement linkPhoneTitleText;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/phone_number\")")
	private static WebElement enterPhoneToLink;
	
	public static void clickAndEnterPhoneNumber(){
		enterPhoneToLink.click();
		enterPhoneToLink.clear();
		enterPhoneToLink.sendKeys("6507438891");
	}
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/zip_code\").text(\"Zip Code\")")
	private static WebElement enterZipCode;
	
	public static void clickAndEnterZipcode(){
		enterZipCode.click();
		enterZipCode.sendKeys("95131");
	}
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/button_text\").text(\"COMPLETE REGISTRATION\")")
	private static WebElement completeRegistration;
	
	public static void clickOnCompleteRegistration(){
		completeRegistration.click();
	}

}
