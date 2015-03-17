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
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/list_view\")")
	@iOSFindBy(uiAutomator = ".cells()[0]")
	private static WebElement MySavesOfferTile;
	
	public static void clickMySavesANYOfferTile(){
		MySavesOfferTile.click();
		PageFactory.initElements(new AppiumFieldDecorator(driver),new OfferPage());
	}
	
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/app_screen_back_button\")")
	
	private static WebElement MySavebackButton;
	
	public static void clickOnBackButton(){
		MySavebackButton.click();
		PageFactory.initElements(new AppiumFieldDecorator(driver), new LandingPage());
		PageFactory.initElements(new AppiumFieldDecorator(driver), new ProductsPage());
	}
	

}
