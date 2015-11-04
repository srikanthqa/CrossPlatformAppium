package com.qa.shopkick.tests.Authentication;

import com.qa.shopkick.appium.AbstractTestCase;
import com.qa.shopkick.pages.*;
import com.qa.shopkick.utils.CustomHooks;
import junit.framework.TestCase;
import org.apache.log4j.Logger;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static com.thoughtworks.selenium.SeleneseTestCase.assertNotEquals;
import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class EmailAuthentication extends AbstractTestCase {
    final private static Logger log = Logger.getLogger((EmailAuthentication.class));
    final private static String EXPECTED_ERROR = "Oh no, that email/password isn't right. Try again or tap to reset password.";

    @Test
    public void Test1_LoginWithEmailAccount() {
        testSectionName = "EmailAuthentication";
        testName = "EmailAuthentication.Test1_LoginWithEmailAccount";

        //Go thorough first use
        LoginHooks.GoThroughFirstUse();
        FirstUseRegistrationIntroPage.clickLoginButton();

        String expectedEmail = LoginHooks.loginWithEmail();
        String ACTUAL_ERROR = EmailSignInPage.getEmailPasswordError();
        assertNotEquals(EXPECTED_ERROR, ACTUAL_ERROR);
        String actualKicks = LandingPage.getKicksOnLandingPage();
        log.info("You have " + actualKicks + " kicks");

        CustomHooks.gotoAccountSettings();
        String actualEmail = AccountSettings.getUserEmail();

        assertEquals("Emails don't match in the Accounts Screen ", expectedEmail, actualEmail);
        log.info("All is well, going to log out");
        TestCase.assertTrue("Logout failed ", CustomHooks.logMeOut());
        assertTrue("Error Some buttons missing", SignInPage.areFacebookGoogleEmailButtonsVisible());
        runStatus = "passed";
    }

    @Test
    public void Test2_CreateAccountWithEmailAccount() {
        testSectionName = "EmailAuthentication";
        testName = "EmailAuthentication.Test2_CreateAccountWithEmailAccount";

        LoginHooks.GoThroughFirstUse();
        FirstUseRegistrationIntroPage.CreateAccountButton();
        String expectedEmail = LoginHooks.CreateAccountWithEmail();
        String ACTUAL_ERROR = EmailSignInPage.getEmailPasswordError();
        assertNotEquals(EXPECTED_ERROR, ACTUAL_ERROR);

        String actualKicks = LandingPage.getKicksOnLandingPage();
        log.info("You have " + actualKicks + " kicks");

        CustomHooks.gotoAccountSettings();
        String actualEmail = AccountSettings.getUserEmail();

        assertEquals("Emails don't match in the Accounts Screen ", expectedEmail, actualEmail);
        log.info("All is well, going to log out");
        CustomHooks.logMeOut();
        assertTrue("Error Some buttons missing", SignInPage.areFacebookGoogleEmailButtonsVisible());
        runStatus = "passed";
    }
}