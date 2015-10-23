package com.qa.shopkick.tests.Authentication;

import com.qa.shopkick.pages.EmailSignInPage;
import com.qa.shopkick.pages.SignInPage;
import com.qa.shopkick.utils.AbstractTest;
import org.apache.log4j.Logger;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static com.thoughtworks.selenium.SeleneseTestCase.assertNotEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class EmailAuthentication extends AbstractTest {
    final private static Logger log = Logger.getLogger((EmailAuthentication.class));
    final private static String EXPECTED_ERROR = "Oh no, that email/password isn't right. Try again or tap to reset password.";

//    @Test
//    public void Test1_LoginWrongEmailAccount() {
//
//        testName = "Test1_LoginWrongEmailAccount";
//        //Go thorough first use
//        LoginHooks.GoThroughFirstUse();
//
//        //From logout screen hit on email to create an account
//        SignInPage.clicksignInEmailSignIn();
//
//        //CREATE ACCOUNT
//        //add email address
//        EmailSignInPage.clickAndEnterEmailANDROID("trest2@sk.com");
//
//        //add password
//        EmailSignInPage.clickAndEnterPswdANDROID("sktest123");
//
//        //Hit sign in
//        EmailSignInPage.clickLoginButton();
//
//        String ACTUAL_ERROR = EmailSignInPage.getEmailPasswordError();
//        assertEquals("ERROR! " + EXPECTED_ERROR, ACTUAL_ERROR, EXPECTED_ERROR);
//        CustomHooks.pressBack();
//        CustomHooks.pressBack();
//        runStatus = "passed";
//    }

    @Test
    public void Test2LoginWithEmailAccount() {

        testName = "Test2LoginWithEmailAccount";
        //Go thorough first use
        LoginHooks.GoThroughFirstUse();

        //From logout screen hit on email to create an account
        SignInPage.clicksignInEmailSignIn();

        //CREATE ACCOUNT
        //add email address
        EmailSignInPage.clickAndEnterEmailANDROID("qa_auto1@gmail.com");

        //add password
        EmailSignInPage.clickAndEnterPswdANDROID("123456");

        //Hit sign in
        EmailSignInPage.clickLoginButton();

        String ACTUAL_ERROR = EmailSignInPage.getEmailPasswordError();
        assertNotEquals(ACTUAL_ERROR, EXPECTED_ERROR);

        //make sure you see the Kicks Count on the top center
        runStatus = "passed";
    }


/*    @Test
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
*/
}
