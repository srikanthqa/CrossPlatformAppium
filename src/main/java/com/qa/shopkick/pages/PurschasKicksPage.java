package com.qa.shopkick.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;

import org.openqa.selenium.WebElement;

import com.qa.shopkick.utils.AbstractPage;

public class PurschasKicksPage extends AbstractPage{
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/app_screen_header\").text(\"Kicks When You Buy\")")
	private static WebElement purchaseTutorialHeader;

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/tutorial_details_header_text\").text(\"Get kicks when you purchase with a linked card.\")")
	private static WebElement purchaseTutorialDetails;

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/tutorial_details_step_1_text\").text(\"In shopkick, link your Visa or MasterCard card. We never store your info, so it's safe.\")")
	private static WebElement purchaseTutorialStep1;

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/tutorial_details_step_2_text\").text(\"In shopkick, look for stores with Kicks When You Buy.\")")
	private static WebElement purchaseTutorialStep2;

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/tutorial_details_step_3_text\").text(\"At the store, make purchases with your linked card and get kicks.\")")
	private static WebElement purchaseTutorialStep3;

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/tutorial_details_link\").text(\"LINK YOUR CARD\")")
	private static WebElement seeStoresWithPurchases;

}
