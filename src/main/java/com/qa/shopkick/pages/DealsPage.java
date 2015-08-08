package com.qa.shopkick.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.qa.shopkick.utils.AbstractPage;

public class DealsPage extends AbstractPage {

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/store_search_dummy_field\").text(\"Find stores near you\")")
	private static WebElement DealsPageStoreSearch;

	public static void clickOnSearchBar(){
		DealsPageStoreSearch.click();
		PageFactory.initElements(new AppiumFieldDecorator(driver), new DealsListSearchPage());
	}
	
	public static void searchInStoresSearchBar(String StoreName){
		DealsPageStoreSearch.clear();
		DealsPageStoreSearch.sendKeys(StoreName);
	}

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/chain_logo_image\")")
	private static WebElement DealsPageChainLogoImage;

	public static void clickDealsPageMichales(){
		MobileElement michaelsDealTile = (MobileElement) driver.findElement(By.name("Michaels"));
		michaelsDealTile.click();
		PageFactory.initElements(new AppiumFieldDecorator(driver), new DealAggregationPage());
	}
	
	@iOSFindBy(uiAutomator = ".visibleCells()[\"Michaels\"]")
	private static WebElement michaelsIOSElement;
	
	public static void clickOnMichaelsIOS(){
		michaelsIOSElement.click();
		PageFactory.initElements(new AppiumFieldDecorator(driver), new DealAggregationPage());
	}
	
	public static void clickDealsPageOldNavy(){
		MobileElement michaelsDealTile = (MobileElement) driver.findElement(By.name("Old Navy"));
		michaelsDealTile.click();
		PageFactory.initElements(new AppiumFieldDecorator(driver), new DealAggregationPage());
	}
	
	public static void clickDealsPageCarters(){
		MobileElement DealsPageChainCarters = (MobileElement) driver.findElement(By.name("Carter's"));
		DealsPageChainCarters.click();
		PageFactory.initElements(new AppiumFieldDecorator(driver), new DealAggregationPage());
	}
	
	public static void clickDealsPageAerie(){
		MobileElement DealsPageChainCarters = (MobileElement) driver.findElement(By.name("Aerie"));
		DealsPageChainCarters.click();
		PageFactory.initElements(new AppiumFieldDecorator(driver), new DealAggregationPage());
	}
	
	public static void clickDealsPageTarget(){
		MobileElement DealsPageChainCarters = (MobileElement) driver.findElement(By.name("Target"));
		DealsPageChainCarters.click();
		PageFactory.initElements(new AppiumFieldDecorator(driver), new DealAggregationPage());
	}

}
