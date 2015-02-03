package com.qa.shopkick.tests;

import com.qa.shopkick.pages.*;
import com.qa.shopkick.utils.AbstractTest;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Srikanth on 12/16/14.
 */
public class LaunchTest extends AbstractTest {

    @Test
    public void RegistrationFlow(){
        FirstUseDealsEducationPage.clickNextButton();
        if(PlatformType.equals("IOS")){
            CountryPickerPage.clickCountryUSA();
            CountryPickerPage.clickNextButton();
        }
        FirstUseWalkinEducationPage.clickNextButton();
        FirstUseRewardsEducationPage.clickNextButton();
        RewardsPickerPage.clickNextButton();
        FirstUseRegistrationIntroPage.clickNoThanksButton();
        MicrophonePermissionPage.clickOKButton();

    }
    
    @After
    public void teardown(){
    	//Call all testlodge methods to update the test run result
    	
    }

}
