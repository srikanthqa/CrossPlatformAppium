package com.qa.shopkick.tests.Authentication;

import com.qa.shopkick.pages.*;
import com.qa.shopkick.utils.AbstractTest;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FacebookAuthentication extends AbstractTest {

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
        //set run status as passed
        runStatus = "Passed";
    }

    //	@Test
    //	public void Test2_LoginWithFacebook(){
    //
    //	}
    //
    //	@Test
    //	public void Test3_logOutOfFacebook(){
    //		CustomHooks.LogMeOut();
    //	}
}
