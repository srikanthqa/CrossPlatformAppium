package com.qa.shopkick.pages;

import static junit.framework.TestCase.assertTrue;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.qa.shopkick.utils.AbstractPage;

public class LeftNavBar extends AbstractPage{

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/button_text\").text(\"GUEST\")")
	private static WebElement guestLeftNavBar;

	public static void clickGuestUserButton(){

		guestLeftNavBar.click();
		PageFactory.initElements(new AppiumFieldDecorator(driver), new LeftNavBar());
	}

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/top_text\").text(\"Give your kicks a home.\")")
	private static WebElement guestUserProfileHEader;

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/button_text\").text(\"SIGN IN WITH FACEBOOK\")")
	private static WebElement signInWithFacebookLeftNav;

	public static void clickOnFaceBookSignIn(){
		signInWithFacebookLeftNav.click();

	}

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/button_text\").text(\"SIGN IN WITH GOOGLE\")")
	private static WebElement signInWithGoogleLeftNav;

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/button_text\").text(\"ENTER MANUALLY\")")
	private static WebElement signInManuallyLeftNav;

	//Method TO VERIFY USER IS NOT SIGNED IN
	public static boolean verifyNotSignedIn(){

		if(
				(guestUserProfileHEader.isDisplayed()) &&
				(signInWithFacebookLeftNav.isDisplayed()) &&
				(signInWithGoogleLeftNav.isDisplayed()) &&
				(signInManuallyLeftNav.isDisplayed()))
			return true;
		else
			return false;
	}

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/current_kicks_text\").text(\"Current kicks\")")
	private static WebElement currentKicksLeftNav;

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/all_time_kicks_text\").text(\"All-time kicks\")")
	private static WebElement allTimeKicksLeftNav;

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/row_text\").text(\"My profile\")")
	private static WebElement myProfileLeftNav;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/row_text\").text(\"'s profile\")")
	private static WebElement signedInProfileLeftNav;

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/row_text\").text(\"My saves\")")
	private static WebElement mySavesLeftNav;

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/row_text\").text(\"Rewards\")")
	private static WebElement browseRewardsLeftNav;
	
	public static void clickOnRewardsButtonLeftNav(){
		browseRewardsLeftNav.click();
		PageFactory.initElements(new AppiumFieldDecorator(driver), new KicksCenterRewadsPage());
	}

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/row_text\").text(\"Invite & get kicks\")")
	private static WebElement inviteAndGetKicksLeftNav;
	
	public static void clickOnInviteLeftNav(){
		inviteAndGetKicksLeftNav.click();
		PageFactory.initElements(new AppiumFieldDecorator(driver), new InviteAndGetKicksPage());
	}

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/row_text\").text(\"My friends\")")
	private static WebElement myFriendsLeftNav;

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/row_text\").text(\"Questions?\")")
	private static WebElement questionsLeftNav;

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/row_text\").text(\"Settings\")")
	private static WebElement settingsLeftNav;
	
	public static void clickOnSettingsLeftNav(){
		settingsLeftNav.click();
		PageFactory.initElements(new AppiumFieldDecorator(driver),new LeftNavSettings());
	}

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/current_kicks_count\")")
	private static WebElement currentKicksCountLeftNav;

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/all_time_kicks_count\")")
	private static WebElement allTimeKicksCountLeftNav;	

	//Method TO read Current Kicks
	public static String getCurrentKicksCount(){
		String currentKicksCount = currentKicksCountLeftNav.getText(); 
		return currentKicksCount;
	}

	//Method to read All time kicks
	public static String getAllTimeKicksCount(){
		String allTimeKicksCount = allTimeKicksCountLeftNav.getText(); 
		return allTimeKicksCount;
	}
}
