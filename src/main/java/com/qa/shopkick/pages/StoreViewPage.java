package com.qa.shopkick.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;

import org.openqa.selenium.WebElement;

import com.qa.shopkick.utils.AbstractPage;

public class StoreViewPage extends AbstractPage {
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/app_screen_header\")")
	private static WebElement StoreViewPageAppScreenHeader;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/app_screen_back\")")
	private static WebElement StoreViewPageAppScreenBack;
	
	public static void clickStoreViewPageAppScreenBack(){
		StoreViewPageAppScreenBack.click();
	}

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/promo_image\")")
	private static WebElement StoreViewPagePromoImage;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/chain_logo_image\")")
	private static WebElement StoreViewPageChainLogoImage;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/store_address_field\")")
	private static WebElement StoreViewPageStoreAddressField;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/store_distance_field\")")
	private static WebElement StoreViewPageStoreDistanceField;
	
	public static void clickStoreViewPageStoreDistanceField(){
		StoreViewPageStoreDistanceField.click();
	}
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/kicks_summary_walkin_view\")")
	private static WebElement StoreViewPageKicksSummaryWalkinView;
	
	public static void clickStoreViewPageKicksSummaryWalkinView(){
		StoreViewPageKicksSummaryWalkinView.click();
	}
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/kicks_summary_scan_view\")")
	private static WebElement StoreViewPageKicksSummaryScanView;
	
	public static void clickStoreViewPageKicksSummaryScanView(){
		StoreViewPageKicksSummaryScanView.click();
	}
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/kicks_summary_bnc_view\")")
	private static WebElement StoreViewPageKicksSummaryBNCView;
	
	public static void clickStoreViewPageKicksSummaryBNCView(){
		StoreViewPageKicksSummaryBNCView.click();
	}

	
}
