package com.qa.shopkick.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.qa.shopkick.utils.AbstractPage;

public class DealsPage extends AbstractPage {

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/store_search_dummy_field\").text(\"Find stores near you\")")
	private static WebElement DealsPageStoreSearch;

	public static void clickOnSerahcBar(){
		DealsPageStoreSearch.click();
		PageFactory.initElements(new AppiumFieldDecorator(driver), new DealAggregationPage());
	}

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/chain_logo_image\")")
	private static WebElement DealsPageChainLogoImage;

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/deals_inside\").text(\"Deals available\")")
	private static WebElement dealsAvailableButton;

	public static void clickOnDealsAvailable(){
		dealsAvailableButton.click();

	}

}
