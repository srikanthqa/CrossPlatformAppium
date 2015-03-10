package com.qa.shopkick.pages;

import org.openqa.selenium.WebElement;

import io.appium.java_client.pagefactory.AndroidFindBy;

import com.qa.shopkick.utils.AbstractPage;

public class DealDetailpage extends AbstractPage{

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/button_text\").text(\"SAVE\")")
	private static WebElement saveOfferButton;

	public static void clickOnSaveDeal(){
		saveOfferButton.click();
	}

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/button_text\").text(\"SAVED\")")
	private static WebElement unSaveOfferButton;

	public static void unSaveDeal(){
		unSaveOfferButton.click();
	}

}
