package com.qa.shopkick.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;

import org.openqa.selenium.WebElement;

import com.qa.shopkick.utils.AbstractPage;

public class DidYouKnowPage extends AbstractPage{
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Did you know?\")")
	private static WebElement didYouKnowText;
	
	public static void tapOnDidYouKnow(){
		didYouKnowText.click();
	}
}
