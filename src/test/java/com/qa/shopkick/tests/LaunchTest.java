package com.qa.shopkick.tests;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Test;

import com.qa.shopkick.pages.AccountSettings;
import com.qa.shopkick.pages.CountryPickerPage;
import com.qa.shopkick.pages.EmailSignInPage;
import com.qa.shopkick.pages.EmailSignUp;
import com.qa.shopkick.pages.FirstUseAlternateScreen;
import com.qa.shopkick.pages.FirstUseDealsEducationPage;
import com.qa.shopkick.pages.FirstUseRegistrationIntroPage;
import com.qa.shopkick.pages.FirstUseRewardsEducationPage;
import com.qa.shopkick.pages.FirstUseWalkinEducationPage;
import com.qa.shopkick.pages.LeftNavBar;
import com.qa.shopkick.pages.LeftNavSettings;
import com.qa.shopkick.pages.LinkPhonePage;
import com.qa.shopkick.pages.MicrophonePermissionPage;
import com.qa.shopkick.pages.RewardsPickerPage;
import com.qa.shopkick.pages.SignInPage;
import com.qa.shopkick.pages.VerifyMobileNumber;
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

		//Pick default reward
		RewardsPickerPage.clickNextButton();

		FirstUseRegistrationIntroPage.clickNoThanksButton();
		
		//if iOS and if mic permission is asked, give the permission
		if(PlatformType.equals("IOS")){
			MicrophonePermissionPage.clickOKButton();
		}

		//tap on the 'Guest' button to open left nav bar
		LeftNavBar.clickGuestUserButton();

		//Read current kicks so you can compare if the user has signed in and the kicks have been updated

		currentKicksBeforeLogin = LeftNavBar.getCurrentKicksCount();

		LeftNavBar.clickOnFaceBookSignIn();

		//Verify kicks have been updated
		currentKicksAfterLogin = LeftNavBar.getCurrentKicksCount();

		LeftNavBar.clickOnSettingsLeftNav();
		
		//Go to Account settings
		LeftNavSettings.clicksettingsAccountSettings();

		//perform a logout
		AccountSettings.clickAccountSettingsLogOut();
		
		//From logout screen hit on email to create an account
		SignInPage.clicksignInEmailSignIn();
		
		//CREATE ACCOUNT
		
		EmailSignInPage.clickOnEmailAdrressMobileElements();
		
		//add email
/*		EmailSignInPage.clickEmailAddress();
		EmailSignInPage.enterNewEmailAddress();*/
		
		//add password
		EmailSignInPage.clickOnPasswordMobileElement();
		
		//confirm password
		EmailSignInPage.enterConfirmPassword();
		
		//Add first and last name
		EmailSignInPage.clickAndEnterFirstName();
		EmailSignInPage.clickAndEnterLastName();
		
		//Hit sign up
		EmailSignUp.clickOnSignUpButton();
		
	/*	//Phone number screen
		
		//add phone number
		LinkPhonePage.clickAndEnterPhoneNumber();
		
		//Add zipcode
		LinkPhonePage.clickAndEnterZipcode();
		
		//hit continue
		LinkPhonePage.clickOnCompleteRegistration();
		
		
		//Hit Not right now in verify phone number page
		VerifyMobileNumber.clickyNotNowForVerifyPhone();
		*/
		
		//From landing page [stores tab]
		//Go to left nav bar
		//Verify user is signed in
		//Go to settings
		//Go to Account settings
		//Tap on delete account
		
	}

	@After
	public void teardown(){
		//Call all testlodge methods to update the test run result

	}

}
