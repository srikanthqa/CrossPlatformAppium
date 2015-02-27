package com.qa.shopkick.pages;

import com.qa.shopkick.utils.AbstractPage;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class DealsPage extends AbstractPage {
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/store_search_dummy_field\").text(\"Find stores near you\")")
	private static WebElement DealsPageStoreSearch;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/chain_logo_image\")")
	private static WebElement DealsPageChainLogoImage;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/chain_name\").text(\"Michaels\")")
	private static WebElement DealsPageChainMichales;
	
	public static void clickDealsPageMichales(){
		DealsPageChainMichales.click();
		PageFactory.initElements(new AppiumFieldDecorator(driver), new DealAggregationPage());
	}
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/chain_name\").text(\"Carter's\")")
	private static WebElement DealsPageChainCarters;
	
	public static void clickDealsPageCarters(){
		DealsPageChainCarters.click();
		PageFactory.initElements(new AppiumFieldDecorator(driver), new DealAggregationPage());
	}
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/deals_count\")")
	private static WebElement DealsPageDealsCount;

}
