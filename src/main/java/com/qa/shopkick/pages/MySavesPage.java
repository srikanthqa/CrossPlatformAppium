package com.qa.shopkick.pages;

import com.qa.shopkick.utils.AbstractPage;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class MySavesPage extends AbstractPage {
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/app_screen_header\").text(\"My Saves\")")
	private static WebElement MySavesAppScreenHeader;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/tab_count\")")
	private static WebElement MySavesProductTabCount;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/tab_caption\")")
	private static WebElement MySavesProductTabCaption;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/tab_count\")")
	private static WebElement MySavesTabCollectionTabCount;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/tab_caption\")")
	private static WebElement MySavesTabCollectionTabCaption;
	
	public static void clickMySavesCollectionTabCaption(){
		MySavesTabCollectionTabCaption.click();
	}
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/tab_count\")")
	private static WebElement MySavesTabDealTabCount;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/tab_caption\")")
	private static WebElement MySavesTabDealTabCaption;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/tile_main_image\")")
	private static WebElement MySavesOfferTile;
	
	public static void clickMySavesOfferTile(){
		MySavesOfferTile.click();
	}
	
	

}
