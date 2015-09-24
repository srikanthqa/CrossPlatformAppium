package com.qa.shopkick.tests.Authentication;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.qa.shopkick.pages.CountryPickerPage;
import com.qa.shopkick.pages.FirstUseDealsEducationPage;
import com.qa.shopkick.pages.FirstUseRegistrationIntroPage;
import com.qa.shopkick.pages.FirstUseRewardsEducationPage;
import com.qa.shopkick.pages.FirstUseWalkinEducationPage;
import com.qa.shopkick.pages.RewardsPickerPage;
import com.qa.shopkick.utils.AbstractTest;
import com.qa.shopkick.utils.CustomHooks;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FacebookAuthentication extends AbstractTest{
	
	@Test 
	public void Test1_FirstUseFlow(){
		//Go through the first use flow
		FirstUseDealsEducationPage.clickNextButton();
		CustomHooks.waitFor(2);

		if(PlatformType.equals("IOS")){
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
	}

	@Test
	public void Test2_LoginWithFacebook(){
		LoginHooks.LoginWithfacebook();
	}
	
	@Test
	public void Test3_logOutOfFacebook(){
		CustomHooks.LogMeOut();
	}
}
