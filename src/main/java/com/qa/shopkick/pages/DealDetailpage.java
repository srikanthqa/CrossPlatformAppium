package com.qa.shopkick.pages;

import org.openqa.selenium.WebElement;

import io.appium.java_client.pagefactory.AndroidFindBy;

import com.qa.shopkick.utils.AbstractPage;

public class DealDetailpage extends AbstractPage{

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/save_button\")")
	private static WebElement saveOfferButton;

	public static void clickOnSaveDeal(){
		saveOfferButton.click();
	}
}
