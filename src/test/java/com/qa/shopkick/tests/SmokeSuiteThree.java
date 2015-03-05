package com.qa.shopkick.tests;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;

import com.qa.shopkick.pages.AccountSettings;
import com.qa.shopkick.pages.EmailSignInPage;
import com.qa.shopkick.pages.InviteAndGetKicksPage;
import com.qa.shopkick.pages.KicksCenterRewadsPage;
import com.qa.shopkick.pages.LandingPage;
import com.qa.shopkick.pages.LeftNavBar;
import com.qa.shopkick.pages.LeftNavSettings;
import com.qa.shopkick.pages.RewardsPickerPage;
import com.qa.shopkick.pages.SignInPage;
import com.qa.shopkick.pages.StoresPage;
import com.qa.shopkick.utils.AbstractTest;
import com.qa.shopkick.utils.CustomHooks;

public class SmokeSuiteThree extends AbstractTest{
	
	@Test
	public void SuiteThree(){
	//User logs in via email
	SignInPage.clicksignInEmailSignIn();
	EmailSignInPage.clickOnEmailAdrressMobileElements("a@b.com");
	EmailSignInPage.clickOnPasswordMobileElement("aaaaaa");
	EmailSignInPage.clickOnSignUpButton();
	
	//Goes to kick center
	StoresPage.clickStoresPageKicksCenter();
	
	//Learn how to get kicks
	KicksCenterRewadsPage.clickOnLearnHowToGetKicks();
	
	//verify all items are displayed
	//TODO: Figure out elements to verify in this flow
	
	//Go back
	CustomHooks.pressBack();
	
	//Verify change rewards
	KicksCenterRewadsPage.clickOnChangeReward();
	driver.scrollTo("3400");
	RewardsPickerPage.clickGasReward();
	
	//Verify rewards displayed
	CustomHooks.pressBack();
	
	KicksCenterRewadsPage.clickOnseeAllRewardsFullWidth();
	
	//Rewards Mall 
	//Scroll to bottom
	driver.scrollTo("1875000");
	//Scroll back to top
	driver.scrollTo("You earned");
	
	//Go back
	CustomHooks.pressBack();
	
	//Redeem a reward (from kick center)
	//TODO: Redeem reward flow
	
	//Go back
	CustomHooks.pressBack();
	
	//Open left nav
	LandingPage.openLeftNavSignedIn();
	
	//Go to invite friends
	LeftNavBar.clickOnInviteLeftNav();
	InviteAndGetKicksPage.clickOninviteFrendsButton();
	
	//Verify all elements
	
	//Logout
	CustomHooks.pressBack();
	CustomHooks.pressBack();
	LandingPage.openLeftNavSignedIn();

	driver.scrollTo("Settings");

	LeftNavBar.clickOnSettingsLeftNav();

	LeftNavSettings.clicksettingsAccountSettings();

	AccountSettings.clickAccountSettingsLogOut();
}
}
