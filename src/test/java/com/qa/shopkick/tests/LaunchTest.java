package com.qa.shopkick.tests;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Test;

import com.qa.shopkick.pages.CountryPickerPage;
import com.qa.shopkick.pages.FirstUseAlternateScreen;
import com.qa.shopkick.pages.FirstUseDealsEducationPage;
import com.qa.shopkick.pages.FirstUseRegistrationIntroPage;
import com.qa.shopkick.pages.FirstUseRewardsEducationPage;
import com.qa.shopkick.pages.FirstUseWalkinEducationPage;
import com.qa.shopkick.pages.LeftNavBar;
import com.qa.shopkick.pages.MicrophonePermissionPage;
import com.qa.shopkick.pages.RewardsPickerPage;
import com.qa.shopkick.utils.AbstractTest;

/**
 * Created by Srikanth on 12/16/14.
 */
public class LaunchTest extends AbstractTest {

	public static String currentKicksBeforeLogin, currentKicksAfterLogin;

	@Test
	public void RegistrationFlow(){

		//Go through the first use flow
		FirstUseDealsEducationPage.clickNextButton();
		if(PlatformType.equals("IOS")){
			CountryPickerPage.clickCountryUSA();
			CountryPickerPage.clickNextButton();
		}
		FirstUseWalkinEducationPage.clickNextButton();
		FirstUseRewardsEducationPage.clickNextButton();

		//Pick
		RewardsPickerPage.clickNextButton();

		FirstUseRegistrationIntroPage.clickNoThanksButton();

		/* TODO: Figure out more effective way to verify which page is going to be displayed
		 * 
		if(driver.findElementByPartialLinkText("NO THANKS").isDisplayed()){
			FirstUseRegistrationIntroPage.clickNoThanksButton();
		}
		else{
			FirstUseAlternateScreen.clickOnContinueAsGuestButton();
		}

		//Logic to determine which first use flow we run into
		if(FirstUseRegistrationIntroPage.firstUseFlowLessScreen()==true)
		{
			FirstUseRegistrationIntroPage.clickNoThanksButton();
		}

		if(FirstUseAlternateScreen.firstUseFlowLessScreen()==true)
		{
			FirstUseAlternateScreen.clickOnContinueAsGuestButton();
		}

		//if iOS and if mic permission is asked, give the permission
		if(PlatformType.equals("IOS")){
			MicrophonePermissionPage.clickOKButton();
		}
		 */

		//tap on the 'Guest' button to open left nav bar
		LeftNavBar.clickGuestUserButton();

		//Read current kicks so you can compare if the user has signed in and the kicks have been updated

		currentKicksBeforeLogin = LeftNavBar.getCurrentKicksCount();

		/*	TODO: Figure out a betetr way to verify all elements	
		 * //Ensure user is not signed in
		if(LeftNavBar.verifyNotSignedIn() == true)
		{
			//Tap on sign in with facebook
			LeftNavBar.clickOnFaceBookSignIn();			
		}
		else{
			//If a user is signed in on fresh install, Fail the test 
			fail();
		}*/

		LeftNavBar.clickOnFaceBookSignIn();

		//Verify kicks have been updated
		currentKicksAfterLogin = LeftNavBar.getCurrentKicksCount();

		if(currentKicksAfterLogin == currentKicksBeforeLogin)
		{
			//if kicks seems the same, then fail the test
			fail();
		}

		//verify that we don't see the login mechanisms on the left nav bar
		else if (LeftNavBar.verifyNotSignedIn() == true)
		{
			fail();
		}
		else{
			//Go to browse rewards

			//Scroll down

			//Redeem reward
		}

		//verify rewards was redeemed
		//Go to settings > Logout
		//From settings > email register a new account
		//Delete account
	}

	@After
	public void teardown(){
		//Call all testlodge methods to update the test run result

	}

}
