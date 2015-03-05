package com.qa.shopkick.pages;

import com.qa.shopkick.utils.AbstractPage;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class StoresPage extends AbstractPage {
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/kicks_counter\")")
	private static WebElement StoresPageKicksCenter;
	
	public static void clickStoresPageKicksCenter(){
		StoresPageKicksCenter.click();
		PageFactory.initElements(new AppiumFieldDecorator(driver),new KicksCenterRewadsPage());
	}
		
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/button_icon\")")
	private static WebElement StoresPageMySaves;
	
	public static void clickStoresPageMySaves(){
		StoresPageMySaves.click();
	}
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/promo_image\")")
	private static WebElement StoresPagePromoImage;
	
	public static void clickStoresPagePromoImage(){
		StoresPagePromoImage.click();
	}
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/store_search_dummy_field\")")
	private static WebElement StoresPageStoreSearch;
	
	public static void clickStoresPageStoreSearch(){
		StoresPageStoreSearch.click();
	}
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/chain_name\").text(\"Old Navy\")")
	private static WebElement StoresPageNameAndKickInformation;
	
	public static void clickStoresPageNameAndKickInformation(){
		StoresPageNameAndKickInformation.click();
		PageFactory.initElements(new AppiumFieldDecorator(driver),new ToolTipsPage());
	}
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/group_header_see_all_field\")")
	private static WebElement StoresPageDealsAndSalesSeeAll;
	
	public static void clickStoresPageDealsAndSalesSeeAll(){
		StoresPageDealsAndSalesSeeAll.click();
	}
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/offer_cell_left\")")
	private static WebElement StoresPageOfferCellLeft;
	
	public static void clickStoresPageOfferCellLeft(){
		StoresPageOfferCellLeft.click();
		PageFactory.initElements(new AppiumFieldDecorator(driver),new RelatedOfferPage());
	}
	

}
