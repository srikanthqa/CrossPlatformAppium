package com.qa.shopkick.pages;

import com.qa.shopkick.utils.ScreenBaseClass;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class WalkInTutorialPage extends ScreenBaseClass {
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/app_screen_header\").text(\"Walk-in information\")")
	private static WebElement walkinTutorialHeader;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/tutorial_details_header_text\").text(\"Get kicks just for walking into stores.\")")
	private static WebElement walkinTutorialDetails;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/tutorial_details_step_1_text\").text(\"In shopkick, find stores with walk-in kicks.\")")
	private static WebElement walkinTutorialStep1;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/tutorial_details_step_2_text\").text(\"Make sure your Bluetooth is on.\")")
	private static WebElement walkinTutorialStep2;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/tutorial_details_step_3_text\").text(\"Open shopkick at the store entrance and get kicks.\")")
	private static WebElement walkinTutorialStep3;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/tutorial_details_link\").text(\"SEE STORES WITH WALK-INS\")")
	private static WebElement seeStoresWithWalkins;
	
	public static void verifyHowToWalkInUiElements(){
		if(walkinTutorialDetails.isDisplayed())
		{
			if(seeStoresWithWalkins.isDisplayed()){
				seeStoresWithWalkins.click();
				PageFactory.initElements(new AppiumFieldDecorator(driver), new StoresPage());
			}
		}
		else{
				Assert.fail();
		}
	}
}
