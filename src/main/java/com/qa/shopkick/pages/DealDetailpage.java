package com.qa.shopkick.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

import com.qa.shopkick.utils.AbstractPage;

public class DealDetailpage extends AbstractPage{

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/save_button\")")
	@iOSFindBy(uiAutomator = ".elements()[6]")
	private static WebElement saveOfferButton;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/save_button\")")
	@iOSFindBy(uiAutomator = ".elements()[6]")
	private static WebElement unSaveOfferButton;

	public static void clickOnSaveDeal(){
		saveOfferButton.click();
	}
}
