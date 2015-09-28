package com.qa.shopkick.tests.Authentication;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;

import com.qa.shopkick.pages.AccountSettings;
import com.qa.shopkick.pages.ConfirmDeleteAccountPage;
import com.qa.shopkick.pages.DeleteAccountPage;
import com.qa.shopkick.pages.EmailSignInPage;
import com.qa.shopkick.pages.LandingPage;
import com.qa.shopkick.pages.LeftNavBar;
import com.qa.shopkick.pages.LeftNavSettings;
import com.qa.shopkick.pages.LinkPhonePage;
import com.qa.shopkick.pages.SignInPage;
import com.qa.shopkick.pages.VerifyMobileNumber;
import com.qa.shopkick.utils.AbstractTest;
import com.qa.shopkick.utils.CustomHooks;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmailAuthentication extends AbstractTest
{
	@Test
	public void Test1_createEmailAccount()
	{
		//Go thorough first use
		LoginHooks.GoThroughFirstUse();

		//From logout screen hit on email to create an account
		SignInPage.clicksignInEmailSignIn();

		//CREATE ACCOUNT
		//add email address
		EmailSignInPage.clickAndEnterEmailANDROID("trest2@sk.com");

		//add password
		EmailSignInPage.clickAndEnterPswdANDROID("sktest123");

		//Hit sign up
		EmailSignInPage.clickOnSignUpButton();

		CustomHooks.waitFor(5);

		//Phone number screen

		//add phone number
		LinkPhonePage.clickAndEnterPhoneNumber();

		//Add zipcode
		LinkPhonePage.clickAndEnterZipcode();

		//hit continue
		LinkPhonePage.clickOnCompleteRegistration();

		CustomHooks.waitFor(10);

		//Hit Not right now in verify phone number page
		VerifyMobileNumber.clickNotNowForVerifyPhone();
	}

	@Test
	public void Test2_DeleteEmailAccount(){
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

		//Comfirm delete account
		ConfirmDeleteAccountPage.clickOnDeleteAccountConfirm();
	}

	@Test
	public void Test3_LoginWithEmail(){
		LoginHooks.EmailLogin();

	}

	@Test
	public void Test4_logOutOfEmail(){
		CustomHooks.LogMeOut();
	}
}
