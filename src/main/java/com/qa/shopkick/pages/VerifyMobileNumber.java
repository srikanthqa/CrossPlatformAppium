package com.qa.shopkick.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.qa.shopkick.utils.AbstractPage;

public class VerifyMobileNumber extends AbstractPage{

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/verify_title_text\").text(\"Verify your mobile number to redeem rewards!\")")
	private static WebElement linkPhoneTitleText;

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/verify_edit_phone_button\")")
	private static WebElement verifyPhoneToLink;

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/verify_not_now_button\").text(\"Not right now\")")
	private static WebElement verifyPhoneNotRightNow;

	public static void clickyNotNowForVerifyPhone(){
		verifyPhoneNotRightNow.click();
		//TODO: Initialize home page from this click
		PageFactory.initElements(new AppiumFieldDecorator(driver),new LandingPage());
	}
}

