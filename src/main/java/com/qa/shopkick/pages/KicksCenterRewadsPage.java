package com.qa.shopkick.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.qa.shopkick.utils.AbstractPage;

public class KicksCenterRewadsPage extends AbstractPage{

	//Declaring all static texts in page first, parts we wont click

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/kicks_center_title\").text(\"Kicks Center\")")
	private static WebElement kickCenterHeader;

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/kicks_center_unit\").text(\"KICKS\")")
	private static WebElement kickCenterUserKicks;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/kc_widget_change_reward_text\").text(\"CHANGE REWARD\")")
	private static WebElement kickCenterChangeReward;
	
	public static void clickOnChangeReward(){
		kickCenterChangeReward.click();
		PageFactory.initElements(new AppiumFieldDecorator(driver),new RewardsPickerPage());
	}
		
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/kicks_center_tutorial_or_pending\").text(\"GET MORE KICKS. LEARN HOW.\")")
	private static WebElement getMoreKicksLearnHow;
	
	public static void clickOnLearnHowToGetKicks(){
		getMoreKicksLearnHow.click();
		PageFactory.initElements(new AppiumFieldDecorator(driver),new LearnHowGetMoreKicks());
	}
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/kicks_center_all_rewards_full_width_text\").text(\"SEE ALL REWARDS\")")
	private static WebElement seeAllRewardsFullWidth;
	
	public static void clickOnseeAllRewardsFullWidth(){
		seeAllRewardsFullWidth.click();
		PageFactory.initElements(new AppiumFieldDecorator(driver),new RewardsMallPage());
	}

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/kicks_center_all_rewards_half_width_text\").text(\"SEE ALL REWARDS\")")
	private static WebElement seeAllRewardsHalfWidth;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/kicks_center_screen_back\")")
	private static WebElement closeKickCenter;
	
	//FOR 4.5.7 and above
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/button_text\").text(\"CLOSE\")")
	private static WebElement kickCenterCloseButton;
		
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/kicks_center_my_rewards_text\").text(\"MY REWARDS\")")
	private static WebElement kickCenterMyRewards;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/kicks_counter\")")
	private static WebElement ProductsPageKicksCounter;
	

}
