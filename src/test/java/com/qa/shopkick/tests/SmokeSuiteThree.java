package com.qa.shopkick.tests;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;

import com.qa.shopkick.pages.AccountSettings;
import com.qa.shopkick.pages.EmailSignInPage;
import com.qa.shopkick.pages.FacebookInvitePage;
import com.qa.shopkick.pages.InviteAndGetKicksPage;
import com.qa.shopkick.pages.KicksCenterRewadsPage;
import com.qa.shopkick.pages.LandingPage;
import com.qa.shopkick.pages.LearnHowGetMoreKicks;
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

		CustomHooks.dismissPotHoleError();

		//User logs in via email
		SignInPage.clicksignInEmailSignIn();
		EmailSignInPage.clickOnEmailAdrressMobileElements("a@b.com");
		EmailSignInPage.clickOnPasswordMobileElement("aaaaaa");
		EmailSignInPage.clickOnSignUpButton();

		CustomHooks.dismissMultiLoginMessage();

		//Goes to kick center
		StoresPage.clickStoresPageKicksCenter();

		//Learn how to get kicks
		KicksCenterRewadsPage.clickOnLearnHowToGetKicks();

		//
		LearnHowGetMoreKicks.clickOnBackButton();

		//Verify change rewards
		KicksCenterRewadsPage.clickOnChangeReward();

		driver.scrollTo("1875000");
		RewardsPickerPage.clickVespaReward();

		/*		else{
			driver.scrollTo("1875000");
			RewardsPickerPage.clickVespaReward();
		}*/


		RewardsPickerPage.clickOnBackButton();

		//Verify rewards displayed

		KicksCenterRewadsPage.clickOnseeAllRewardsHalfWidth();

		//Rewards Mall 
		//Scroll to bottom
		driver.scrollTo("SOLD OUT");
		//Scroll back to top
		driver.scrollTo("You earned");

		//Go back
		CustomHooks.pressBack();

		//Go back
		CustomHooks.pressBack();

		//Redeem a reward (from kick center)
		//TODO: Redeem reward flo

		//Open left nav
		LandingPage.openLeftNavSignedIn();

		CustomHooks.waitFor(3);

		//Go to invite friends
		LeftNavBar.clickOnInviteLeftNav();

		CustomHooks.waitFor(3);

		InviteAndGetKicksPage.clickOninviteFrendsButton();

		//Verify all elements
		FacebookInvitePage.clickOnBackButton();
		
		InviteAndGetKicksPage.clickOnBackButton();

		//Logout
		LandingPage.openLeftNavSignedIn();

		driver.scrollTo("Settings");

		LeftNavBar.clickOnSettingsLeftNav();

		LeftNavSettings.clicksettingsAccountSettings();

		AccountSettings.clickAccountSettingsLogOut();
	}
}
