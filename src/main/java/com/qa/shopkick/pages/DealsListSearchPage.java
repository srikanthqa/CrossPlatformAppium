package com.qa.shopkick.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;

import org.openqa.selenium.WebElement;

import com.qa.shopkick.utils.AbstractPage;

public class DealsListSearchPage extends AbstractPage{
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/deals_inside\").text(\"Deals available\")")
	private static WebElement dealsAvailableButton;

	public static void clickOnDealsAvailable(){
		dealsAvailableButton.click();

	}

}
