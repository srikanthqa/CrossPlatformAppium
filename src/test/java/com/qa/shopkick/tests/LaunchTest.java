package com.qa.shopkick.tests;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Test;

import com.qa.shopkick.pages.CountryPickerPage;
import com.qa.shopkick.pages.FirstUseDealsEducationPage;
import com.qa.shopkick.pages.FirstUseRegistrationIntroPage;
import com.qa.shopkick.pages.FirstUseRewardsEducationPage;
import com.qa.shopkick.pages.FirstUseWalkinEducationPage;
import com.qa.shopkick.pages.LeftNavBar;
import com.qa.shopkick.pages.MicrophonePermissionPage;
import com.qa.shopkick.pages.RewardsPickerPage;
import com.qa.shopkick.utils.AbstractTest;

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
		if(PlatformType.equals("IOS")){
			MicrophonePermissionPage.clickOKButton();
		}

		LeftNavBar.clickGuestUserBUtton();
		if(LeftNavBar.verifyNotSignedIn() == true)
		{

		}
		else{
			fail();
		}
	}

	@After
	public void teardown(){
		//Call all testlodge methods to update the test run result

	}

}
