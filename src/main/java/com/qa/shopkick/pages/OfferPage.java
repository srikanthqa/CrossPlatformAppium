package com.qa.shopkick.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

import org.openqa.selenium.WebElement;

public class OfferPage {
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/offer_image\")")
	private static WebElement OfferPageOfferImage;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/chain_logo\")")
	private static WebElement OfferPageChainLogo;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/offer_title\")")
	private static WebElement OfferPageOfferTitle;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/button_image\")")
	@iOSFindBy(uiAutomator = ".visibleCells()[1].buttons()[\"icon heart pink\"]")
	private static WebElement OfferPageOfferSaveButton;
	
	public static void clickOfferPageOfferSaveButton(){
		OfferPageOfferSaveButton.click();
	}
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/find_more_text\").text(\"BEAM ME BACK\")")
	private static WebElement OfferPageBeamMeBack;

}
