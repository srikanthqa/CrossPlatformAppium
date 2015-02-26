package com.qa.shopkick.pages;

import com.qa.shopkick.utils.AbstractPage;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LookbookPage extends AbstractPage {
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/lookbook_cover\")")
	private static WebElement LookbookPageLookbookCover;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/button_icon\")")
	private static WebElement LookbookPageSaveHeart;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/offer_image\")")
	private static WebElement LookbookPageOfferImage;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/fave_icon\")")
	private static WebElement LookbookPageLookbookOfferSaveHeart;

	public static void clickLookbookPageLookbookOfferSaveHeart(){
		LookbookPageLookbookOfferSaveHeart.click();
	}
}
