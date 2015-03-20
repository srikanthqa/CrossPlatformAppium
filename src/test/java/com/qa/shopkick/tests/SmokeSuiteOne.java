package com.qa.shopkick.tests;

import org.junit.Test;
import org.openqa.selenium.By;

import com.qa.shopkick.pages.AccountSettings;
import com.qa.shopkick.pages.ConfirmDeleteAccountPage;
import com.qa.shopkick.pages.CountryPickerPage;
import com.qa.shopkick.pages.DeleteAccountPage;
import com.qa.shopkick.pages.EmailSignInPage;
import com.qa.shopkick.pages.FirstUseAlternateScreen;
import com.qa.shopkick.pages.FirstUseDealsEducationPage;
import com.qa.shopkick.pages.FirstUseRegistrationIntroPage;
import com.qa.shopkick.pages.FirstUseRewardsEducationPage;
import com.qa.shopkick.pages.FirstUseWalkinEducationPage;
import com.qa.shopkick.pages.LandingPage;
import com.qa.shopkick.pages.LeftNavBar;
import com.qa.shopkick.pages.LeftNavSettings;
import com.qa.shopkick.pages.LinkPhonePage;
import com.qa.shopkick.pages.MicrophonePermissionPage;
import com.qa.shopkick.pages.RewardsPickerPage;
import com.qa.shopkick.pages.SignInPage;
import com.qa.shopkick.pages.VerifyMobileNumber;
import com.qa.shopkick.utils.AbstractTest;
import com.qa.shopkick.utils.CustomHooks;

public class SmokeSuiteOne extends AbstractTest{

	@Test
	public void FirstUseFlow(){

		//Go through the first use flow
		FirstUseDealsEducationPage.clickNextButton();
		
		if(!CountryPickerPage.clickAndProceedUSA()==false){
			CountryPickerPage.clickCountryUSA();
			CountryPickerPage.clickNextButton();
		}

		FirstUseWalkinEducationPage.clickNextButton();
		FirstUseRewardsEducationPage.clickNextButton();

		//Pick default reward
		RewardsPickerPage.clickNextButton();

		if(driver.findElement(By.name("No, thanks")).isDisplayed())
		{
			FirstUseRegistrationIntroPage.clickSignUpOrSignInButton();
		}
		SignInPage.clicksignInFacebookSignIn();

		CustomHooks.waitFor(8);

		CustomHooks.dismissMultiLoginMessage();

		CustomHooks.waitFor(5);
		//
		//			if (driver.findElement(By.name("Let your")).isDisplayed())
		//			{
		//				//if iOS and if mic permission is asked, give the permission
		//				MicrophonePermissionPage.clickOKButton();
		//			}
		LandingPage.openLeftNavSignedIn();


		CustomHooks.waitFor(3);
		driver.scrollTo("Settings");
		//click on settings

		LeftNavBar.clickOnSettingsLeftNav();

		//Go to Account settings
		LeftNavSettings.clicksettingsAccountSettings();

		//perform a logout
		AccountSettings.clickAccountSettingsLogOut();

		//From logout screen hit on email to create an account
		SignInPage.clicksignInEmailSignIn();

		//CREATE ACCOUNT

		if (PlatformType.equalsIgnoreCase("Android")) {

			//add email address
			EmailSignInPage.clickAndEnterEmailANDROID("trest2@sk.com");
			//add password
			EmailSignInPage.clickAndEnterPswdANDROID("sktest123");
		}
		else{
			EmailSignInPage.clickAndEnterEmailIOS("trest2s@sk.com");

			EmailSignInPage.clickAndEnterPasswordIOS("sktest123");
		}
		//confirm password
		EmailSignInPage.enterConfirmPassword();

		//Add first and last name
		EmailSignInPage.clickAndEnterFirstName();
		EmailSignInPage.clickAndEnterLastName();

		driver.hideKeyboard();

		if (PlatformType.equalsIgnoreCase("Android")) {
			//Hit sign up
			EmailSignInPage.clickOnSignUpButton();
		}
		else{
			EmailSignInPage.clickSignInIOS();
		}
		CustomHooks.waitFor(5);

		//Phone number screen

		//add phone number
		LinkPhonePage.clickAndEnterPhoneNumber();

		//Add zipcode
		LinkPhonePage.clickAndEnterZipcode();

		driver.hideKeyboard();

		//hit continue
		LinkPhonePage.clickOnCompleteRegistration();

		CustomHooks.waitFor(10);

		//Hit Not right now in verify phone number page
		VerifyMobileNumber.clickNotNowForVerifyPhone();

		//From landing page [stores tab]

		if(!driver.findElement(By.name("Your settings")).isDisplayed()){
			//Go to left nav bar
			LandingPage.openLeftNavSignedIn();

			//Go to settings
			LeftNavBar.clickOnSettingsLeftNav();

		}

		//Go to Account settings
		LeftNavSettings.clicksettingsAccountSettings();

		//Tap on delete account
		AccountSettings.clickAccountSettingsDeleteAccount();

		//In delete account tap on confirm delete account
		DeleteAccountPage.clickAndDeleteAccountWithPassword();

		CustomHooks.waitFor(3);
		//Tap on top left corner to proceed with delete
		DeleteAccountPage.clickToProceedDelete();

		CustomHooks.waitFor(5);

		if (PlatformType.equalsIgnoreCase("Android")) {
			//Comfirm delete account
			ConfirmDeleteAccountPage.clickOnDeleteAccountConfirm();
		}
		else{
			ConfirmDeleteAccountPage.clickOnConfirmDeleteIOS();
		}
	}

}
