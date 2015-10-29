package com.qa.shopkick.tests;

import com.qa.shopkick.pages.*;
import com.qa.shopkick.appium.AbstractTestCase;
import com.qa.shopkick.utils.CustomHooks;
import org.junit.Test;
import org.openqa.selenium.By;

public class SmokeOneIphone extends AbstractTestCase {

    @Test
    public void firstUseFlow() {
        FirstUseDealsEducationPage.clickGetStartedButton();

        if (driver.findElement(By.name("Tell us where you want to see deals.")).isDisplayed()) {
            CountryPickerPage.clickCountryUSA();
            CountryPickerPage.clickCountryUSA();
            CountryPickerPage.clickNextButton();
            //CountryPickerPage.clickGetStartedButton();
        }
        FirstUseWalkinEducationPage.clickNextButton();

        FirstUseRewardsEducationPage.clickPickARewardButton();

        //Pick default reward
        RewardsPickerPage.clickSelectRewardButton();

        FirstUseRegistrationIntroPage.clickNoThanksButton();

        MicrophonePermissionPage.clickOKButton();

        CustomHooks.waitFor(4);

        LeftNavBar.clickGuestUserButton();

        LeftNavBar.clickOnFaceBookSignIn();


    }

}
