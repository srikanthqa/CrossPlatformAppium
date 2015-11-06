package com.qa.shopkick.tests.Authentication;

import com.qa.shopkick.appium.AbstractTestCase;
import com.qa.shopkick.pages.*;
import com.qa.shopkick.utils.CustomHooks;
import org.apache.log4j.Logger;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static junit.framework.Assert.assertTrue;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FacebookAuthentication extends AbstractTestCase {

    final private static Logger log = Logger.getLogger((FacebookAuthentication.class));
    @Test
    public void Test1_LoginWithFacebookAccount() {

        testSectionName = "FacebookAuthentication";
        testName = "Test1_LoginWithFacebookAccount";

        //Go through the first use flow
        FirstUseDealsEducationPage.clickGetStartedButton();

        if (platformType.equals("IOS")) {
            CountryPickerPage.clickCountryUSA();
            CountryPickerPage.clickNextButton();
        }
        //Redeem your kicks for rewards screen
        FirstUseWalkinEducationPage.clickNextButton();

        //User has to tap on pick a reward
        FirstUseRewardsEducationPage.clickPickARewardButton();

        //Pick default reward
        RewardsPickerPage.clickSelectRewardButton();

        //Click on Login button
        FirstUseRegistrationIntroPage.clickLoginButton();

        LoginHooks.loginWithFacebook();

//        assertNotEquals(EXPECTED_ERROR, ACTUAL_ERROR);
        String actualKicks = LandingPage.getKicksOnLandingPage();
        log.info("You have " + actualKicks + " kicks");

        CustomHooks.gotoAccountSettings();
        String actualEmail = AccountSettings.getUserEmail();

//        assertEquals("Emails don't match in the Accounts Screen ", expectedEmail, actualEmail);
        log.info("all is well, going to log out");
        CustomHooks.logMeOut();
        assertTrue("Error Some buttons missing", SignInPage.areFacebookGoogleEmailButtonsVisible());
        runStatus = "passed";
        //set run status as passed
        runStatus = "Passed";
    }

    @Test
    public void Test2_logOutOfFacebook() {

        testSectionName = "FacebookAuthentication";
        testName = "Test2_logOutOfFacebook";
        CustomHooks.logMeOut();
        runStatus = "Passed";
    }
}
