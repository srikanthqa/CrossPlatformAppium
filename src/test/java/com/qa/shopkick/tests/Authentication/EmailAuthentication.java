package com.qa.shopkick.tests.Authentication;

import com.qa.shopkick.pages.*;
import com.qa.shopkick.utils.AbstractTest;
import com.qa.shopkick.utils.CustomHooks;
import org.apache.log4j.Logger;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;

import static com.thoughtworks.selenium.SeleneseTestCase.assertNotEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class EmailAuthentication extends AbstractTest {
    final private static Logger log = Logger.getLogger((EmailAuthentication.class));
    final private static String EMAIL_PASSWORD_ERROR = "Oh no, that email/password isn't right. Try again or tap to reset password.";

    @Test
    public void Test_LoginWrongEmailAccount_1() {

        testName = "Test_LoginWrongEmailAccount_1";
        //Go thorough first use
        LoginHooks.GoThroughFirstUse();

        //From logout screen hit on email to create an account
        SignInPage.clicksignInEmailSignIn();

        //CREATE ACCOUNT
        //add email address
        EmailSignInPage.clickAndEnterEmailANDROID("trest2@sk.com");

        //add password
        EmailSignInPage.clickAndEnterPswdANDROID("sktest123");

        //Hit sign in
        EmailSignInPage.clickLoginButton();

        String error = EmailSignInPage.getEmailPasswordError();
        assertNotEquals(error, EMAIL_PASSWORD_ERROR);
        runStatus = "passed";
    }

    @Test
    public void Test2CreateEmailAccount() {
        //Go thorough first use
        LoginHooks.GoThroughFirstUse();

        //From logout screen hit on email to create an account
        SignInPage.clicksignInEmailSignIn();

        //CREATE ACCOUNT
        //add email address
        EmailSignInPage.clickAndEnterEmailANDROID("trest2@sk.com");

        //add password
        EmailSignInPage.clickAndEnterPswdANDROID("sktest123");

        //Hit sign in
        EmailSignInPage.clickLoginButton();

        String error = EmailSignInPage.getEmailPasswordError();
        assertNotEquals(error, EMAIL_PASSWORD_ERROR);
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
    public void Test3_DeleteEmailAccount() {
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

        //Comfirm delete account
        ConfirmDeleteAccountPage.clickOnDeleteAccountConfirm();
    }

    @Test
    public void Test3_LoginWithEmail() {
        LoginHooks.EmailLogin();

    }

    @Test
    public void Test4_logOutOfEmail() {
        CustomHooks.LogMeOut();
    }
}
