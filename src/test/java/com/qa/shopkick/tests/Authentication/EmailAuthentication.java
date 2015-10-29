package com.qa.shopkick.tests.Authentication;

import com.qa.shopkick.pages.AccountSettings;
import com.qa.shopkick.pages.EmailSignInPage;
import com.qa.shopkick.pages.LandingPage;
import com.qa.shopkick.pages.SignInPage;
import com.qa.shopkick.utils.AbstractTest;
import com.qa.shopkick.utils.CustomHooks;
import org.apache.log4j.Logger;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static com.thoughtworks.selenium.SeleneseTestCase.assertNotEquals;
import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class EmailAuthentication extends AbstractTest {
    final private static Logger log = Logger.getLogger((EmailAuthentication.class));
    final private static String EXPECTED_ERROR = "Oh no, that email/password isn't right. Try again or tap to reset password.";

    @Test
    public void Test1_LoginWithEmailAccount() {
        testSectionName = "EmailAuthentication";
        testName = "Test1_LoginWithEmailAccount";

        //Go thorough first use
        LoginHooks.GoThroughFirstUse();

        String expectedEmail = LoginHooks.loginWithEmail();
        String ACTUAL_ERROR = EmailSignInPage.getEmailPasswordError();
        assertNotEquals(EXPECTED_ERROR, ACTUAL_ERROR);
        String actualKicks = LandingPage.getKicksOnLandingPage();
        log.info("You have " + actualKicks + " kicks");

        CustomHooks.gotoAccountSettings();
        String actualEmail = AccountSettings.getUserEmail();

        assertEquals("Email's don't match in the Accounts Screen ", expectedEmail, actualEmail);
        CustomHooks.LogMeOut();
        assertTrue("Error Some buttons missing", SignInPage.areFacebookGoogleEmailButtonsVisible());
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
        LoginHooks.loginWithEmail();

    }
*/

}
