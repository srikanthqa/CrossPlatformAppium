package com.qa.shopkick.pages;

import com.qa.shopkick.utils.AbstractPage;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.WebElement;

public class RelatedOfferPage extends AbstractPage{
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/button_image\")")
	@iOSFindBy(uiAutomator = ".buttons()[\"icon heart brown\"]")
	private static WebElement RelatedOfferSaveOffer;
	
	public static void clickRelatedOfferSaveOffer(){
		RelatedOfferSaveOffer.click();
	}
	
	@iOSFindBy(uiAutomator = ".tableViews()[0].cells()[0]")
	private static WebElement firstItemInTrending;
	
	public static void clickOnFirstTrendingItem(){
		firstItemInTrending.click();
	}

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/button_text\").text(\"BUY NOW\")")
	private static WebElement RelatedOfferBuyNow;
	
	public static void clickRelatedOfferBuyNow(){
		RelatedOfferBuyNow.click();
	}
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/offer_image\")")
	private static WebElement RelatedOfferOfferImage;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/chain_logo\")")
	private static WebElement RelatedOfferChainLogo;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/distance_text\")")
	private static WebElement RelatedOfferDistanceButton;
	
	
}
