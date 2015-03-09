package com.qa.shopkick.pages;

import com.qa.shopkick.utils.AbstractPage;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class DealAggregationPage extends AbstractPage{

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/app_screen_header\")")
	private static WebElement DealAggregationPageAppScreenHeader;

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/deal_flag\")")
	private static WebElement DealAggregationDealFlag;

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/deal_title\")")
	private static WebElement DealAggregationDealTitle;

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/deal_subtitle\")")
	private static WebElement DealAggregationDealSubtitle;

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/heart\")")
	private static WebElement DealAggregationSaveHeart;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/deal_image\")")
	private static WebElement dealTileView;
	
	public static void clickOnDealTile(){
		//MobileElement dealTileDealDetails = (MobileElement)driver.findElement(By.)
		dealTileView.click();
		PageFactory.initElements(new AppiumFieldDecorator(driver),new DealDetailpage());
	}

	public static void clickDealAggregationSaveHeart(){
		DealAggregationSaveHeart.click();
	}


}
