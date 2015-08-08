package com.qa.shopkick.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.qa.shopkick.utils.AbstractPage;

public class RewardsMallPage extends AbstractPage {

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/app_screen_header\").Text(\"Rewards\")")
	private static WebElement RewardsMallPageRewardsMallHeader;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/button_icon\")")
	private static WebElement RewardsMallPageMyRewards;
	
	public static void clickOnRewardsMallPageMyRewards(){
		RewardsMallPageMyRewards.click();
		PageFactory.initElements(new AppiumFieldDecorator(driver),new MyRewardsPage());
	}
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/rewards_mall_kicks_label\")")
	private static WebElement RewardsMallPageKicksLabel;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/reward_milestone_image\")")
	private static WebElement RewardsMallPageMilestoneImage;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/cost_group_header_text\").Text(\"Redeem now\")")
	private static WebElement RewardsMallPageRedeemNowText;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/featured_reward_image\")")
	private static WebElement RewardsMallPageFeaturedRewardImage;
	
	public static void clickOnRewardsMallPageFeaturedRewardImage(){
		RewardsMallPageFeaturedRewardImage.click();
	}
		
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/featured_description\")")
	private static WebElement RewardsMallPageFeaturedDescription;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/reward_image\")")
	private static WebElement RewardsMallPageRewardImage;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/reward_cell_kick_amount\")")
	private static WebElement RewardsMallPageRewardCellKickAmount;
	
	
}
