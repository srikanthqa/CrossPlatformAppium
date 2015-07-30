package com.qa.shopkick.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.qa.shopkick.utils.AbstractPage;

public class LearnHowGetMoreKicks extends AbstractPage{

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/app_screen_header\").text(\"Get more kicks\")")
	private static WebElement getMoreKicksHeader;

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/app_screen_header\").text(\"Use kicks to get gift cards in shopkick.\")")
	private static WebElement getMoreKicksTutorial;

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/tutorial_button_walkin\")")
	private static WebElement walkinTutorialButton;

	public static void clickOnWalkinTutorial(){
		if(walkinTutorialButton.isDisplayed())
		{
			walkinTutorialButton.click();
			PageFactory.initElements(new AppiumFieldDecorator(driver),new WalkInTutorialPage());
		}
	}

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/tutorial_button_scan\")")
	private static WebElement scanTutorialButton;

	public static void clickOnScanTutorial(){
		if(scanTutorialButton.isDisplayed())
		{
			scanTutorialButton.click();
			PageFactory.initElements(new AppiumFieldDecorator(driver),new ScanTutorialPage());
		}
	}

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/tutorial_button_purchases\")")
	private static WebElement purchasesTutorialButton;

	public static void clickOnPurchaseTutorial(){
		if(purchasesTutorialButton.isDisplayed())
		{
		purchasesTutorialButton.click();
		PageFactory.initElements(new AppiumFieldDecorator(driver),new PurchaseKicksPage());
		}
	}

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/tutorial_button_invite\")")
	private static WebElement inviteTutorialButton;

	public static void clickOnInviteTutorial(){
		if(inviteTutorialButton.isDisplayed())
		{
		inviteTutorialButton.click();
		PageFactory.initElements(new AppiumFieldDecorator(driver),new InviteAndGetKicksPage());
		}
	}

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/app_screen_back_button\")")
	private static WebElement onScreenBackBoutton;

	public static void clickOnBackButton(){
		onScreenBackBoutton.click();
		PageFactory.initElements(new AppiumFieldDecorator(driver), new KicksCenterRewadsPage());
	}
}
