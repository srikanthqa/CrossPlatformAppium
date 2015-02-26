package com.qa.shopkick.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;

import org.openqa.selenium.WebElement;

import com.qa.shopkick.utils.AbstractPage;

public class DidYouKnowPage extends AbstractPage{
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/main_overlay_view\")")
	private static WebElement didYouKnowText;
	
	public static void tapOnDidYouKnow(){
		didYouKnowText.click();
	}
}
