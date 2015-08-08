package com.qa.shopkick.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

import org.openqa.selenium.WebElement;

import com.qa.shopkick.utils.AbstractPage;

public class LookbookPage extends AbstractPage {
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/lookbook_cover\")")
	private static WebElement LookbookPageLookbookCover;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/button_image\")")
	private static WebElement LookbookPageSaveHeart;
	
	public static void clickToSaveLookBook(){
		LookbookPageSaveHeart.click();
	}
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/offer_image\")")
	private static WebElement LookbookPageOfferImage;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/fave_icon\")")
	@iOSFindBy(uiAutomator = ".collectionViews()[0].cells()[1].buttons()[\"icon heart brown\"]")
	private static WebElement LookbookPageLookbookOfferSaveHeart;

	
	//use offerlikebutton
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/offer_like_button\")")
	private static WebElement saveOfferLookBook;
	
	public static void clickToSaveLookBookTile(){
		saveOfferLookBook.click();
	}
	
	
	public static void clickLookbookPageLookbookOfferSaveHeart(){
		LookbookPageLookbookOfferSaveHeart.click();
	}
}
