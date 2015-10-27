package com.qa.shopkick.tests;

import com.qa.shopkick.pages.*;
import com.qa.shopkick.utils.AbstractTest;
import com.qa.shopkick.utils.CustomHooks;
import org.junit.Test;
import org.openqa.selenium.By;

public class SmokeSuiteThree extends AbstractTest{

	@Test
	public void SuiteThree(){

		CustomHooks.dismissPotHoleError();

		//User logs in via email
		SignInPage.clickEmailSignInButton();

		//Element issues, using two different methods to sign in

		if (platformType.equalsIgnoreCase("Android")) {

			//add email address
			EmailSignInPage.typeEmailANDROID("a@b.com");
			//add password
			EmailSignInPage.typePasswordANDROID("aaaaaa");
		}
		else{
			EmailSignInPage.clickAndEnterEmailIOS("a@b.com");

			EmailSignInPage.clickAndEnterPasswordIOS("aaaaaa");
		}

		CustomHooks.dismissMultiLoginMessage();

		if(driver.findElement(By.name("Your settings")).isDisplayed()){
			CustomHooks.pressBack();
		}

		//Goes to kick center
		StoresPage.clickStoresPageKicksCenter();

		//Learn how to get kicks
		KicksCenterRewadsPage.clickOnLearnHowToGetKicks();

		if(platformType.equalsIgnoreCase("Android")){
			//on screen back button 
			LearnHowGetMoreKicks.clickOnBackButton();
		}
		else{
			//if iOS
			CustomHooks.pressBack();
		}

		//Verify change rewards
		KicksCenterRewadsPage.clickOnChangeReward();

		driver.scrollTo("1875000");

		RewardsPickerPage.clickVespaReward();

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

		if(platformType.equalsIgnoreCase("Android")){
			//on screen back button 
			InviteAndGetKicksPage.clickOnBackButton();
		}
		else{
			//if iOS
			CustomHooks.pressBack();
		}


		//Logout
		LandingPage.openLeftNavSignedIn();

		driver.scrollTo("Settings");

		LeftNavBar.clickOnSettingsLeftNav();

		LeftNavSettings.clicksettingsAccountSettings();

		AccountSettings.clickAccountSettingsLogOut();
	}
}
