package com.qa.shopkick.tests.BackLogTests;

import com.qa.shopkick.appium.AbstractTestCase;
import com.qa.shopkick.pages.*;
import com.qa.shopkick.utils.CustomHooks;
import org.junit.Test;
import org.openqa.selenium.By;

import java.util.logging.Logger;

public class SmokeSuiteOne extends AbstractTestCase {
    final private static Logger log = Logger.getLogger(String.valueOf(SmokeSuiteOne.class));

    @Test
    public void FirstUseFlow() {

        //Go through the first use flow
        FirstUseDealsEducationPage.clickGetStartedButton();

        if (platformType.equals("IOS")) {
            if (CountryPickerPage.clickAndProceedUSA() || !(FirstUseWalkinEducationPage.isGetPointsScreen())) {
                CountryPickerPage.clickCountryUSA();
                CountryPickerPage.clickCountryUSA();
                CountryPickerPage.clickNextButton();
                //CountryPickerPage.clickGetStartedButton();
            }
        }

        FirstUseWalkinEducationPage.clickNextButton();
        FirstUseRewardsEducationPage.clickPickARewardButton();

        log.info("Pick default reward"); //Pick default reward
        RewardsPickerPage.clickSelectRewardButton();

        FirstUseRegistrationIntroPage.clickSignUpOrSignInButton();

        //        if (!SignInPage.isFacebookLoginAvail()) {
        //            FirstUseRegistrationIntroPage.clickSignUpOrSignInButton();
        //        }

        SignInPage.clickFacebookSignInButton();

        CustomHooks.waitFor(10);

        CustomHooks.dismissMultiLoginMessage();

        CustomHooks.waitFor(5);

        if (driver.findElement(By.name("OK")).isDisplayed()) {
            //if iOS and if mic permission is asked, give the permission
            MicrophonePermissionPage.clickOKButton();
        }
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
        SignInPage.clickEmailSignInButton();

        //CREATE ACCOUNT

        if (platformType.equalsIgnoreCase("Android")) {

            //add email address
            EmailSignInPage.typeEmailANDROID("trest2@sk.com");
            //add password
            EmailSignInPage.typePasswordANDROID("sktest123");
        } else {
            EmailSignInPage.clickAndEnterEmailIOS("trest2s@sk.com");

            EmailSignInPage.clickAndEnterPasswordIOS("sktest123");
        }
        //confirm password
        EmailSignInPage.enterConfirmPassword();

        //Add first and last name
        EmailSignInPage.clickAndEnterFirstName("FN");
        EmailSignInPage.clickAndEnterLastName("LN");

        driver.hideKeyboard();

        if (platformType.equalsIgnoreCase("Android")) {
            //Hit sign up
            EmailSignInPage.clickOnSignUpButton();
        } else {
            EmailSignInPage.clickSignInIOS();
        }
        CustomHooks.waitFor(5);

        //Phone number screen

        //add phone number
        LinkPhonePage.clickAndEnterPhoneNumber("12345665");

        //Add zipcode
        LinkPhonePage.clickAndEnterZipcode();

        driver.hideKeyboard();

        //hit continue
        LinkPhonePage.clickOnCompleteRegistration();

        CustomHooks.waitFor(10);

        //Hit Not right now in verify phone number page
        VerifyMobileNumber.clickNotNowForVerifyPhone();

        //From landing page [stores tab]

        if (!driver.findElement(By.name("Your settings")).isDisplayed()) {
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

        if (platformType.equalsIgnoreCase("Android")) {
            //Comfirm delete account
            ConfirmDeleteAccountPage.clickOnDeleteAccountConfirm();
        } else {
            ConfirmDeleteAccountPage.clickOnConfirmDeleteIOS();
        }
    }

}
