package com.qa.shopkick.pages;

import com.qa.shopkick.utils.AbstractPage;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LeftNavBar extends AbstractPage{

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/button_text\").text(\"GUEST\")")
	private static WebElement guestLeftNavBar;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/top_text\").text(\"Give your kicks a home.\")")
	private static WebElement guestUserProfileHEader;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/button_text\").text(\"SIGN IN WITH FACEBOOK\")")
	private static WebElement signInWithFacebookLeftNav;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/button_text\").text(\"SIGN IN WITH GOOGLE\")")
	private static WebElement signInWithGoogleLeftNav;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/button_text\").text(\"ENTER MANUALLY\")")
	private static WebElement signInManuallyLeftNav;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/current_kicks_text\").text(\"ENTER MANUALLY\")")
	private static WebElement currentKicksLeftNav;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/all_time_kicks_text\").text(\"ENTER MANUALLY\")")
	private static WebElement allTimeKicksLeftNav;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/row_text\").text(\"My profile\")")
	private static WebElement myProfileLeftNav;

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/row_text\").text(\"My saves\")")
	private static WebElement mySavesLeftNav;

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/row_text\").text(\"Browse rewards\")")
	private static WebElement browseRewardsLeftNav;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/row_text\").text(\"My redeemed rewards\")")
	private static WebElement myRedeemedRewardsLeftNav;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/row_text\").text(\"Invite & get kicks\")")
	private static WebElement inviteAndGetKicksLeftNav;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/row_text\").text(\"My friends\")")
	private static WebElement myFriendsLeftNav;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/row_text\").text(\"Questions?\")")
	private static WebElement questionsLeftNav;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/row_text\").text(\"Settings\")")
	private static WebElement settingsLeftNav;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/current_kicks_count\").text(\"ENTER MANUALLY\")")
	private static WebElement currentKicksCountLeftNav;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/all_time_kicks_count\").text(\"ENTER MANUALLY\")")
	private static WebElement allTimeKicksCountLeftNav;	
}
