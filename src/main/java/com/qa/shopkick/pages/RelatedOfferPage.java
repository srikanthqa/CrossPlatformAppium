package com.qa.shopkick.pages;

import com.qa.shopkick.utils.AbstractPage;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class RelatedOfferPage extends AbstractPage{
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/button_image\")")
	private static WebElement RelatedOfferSaveOffer;
	
	public static void clickRelatedOfferSaveOffer(){
		RelatedOfferSaveOffer.click();
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