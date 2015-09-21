package com.qa.shopkick.tests;

import org.testng.annotations.Test;
import javax.management.DescriptorKey;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.support.PageFactory;

import com.qa.shopkick.pages.CountryPickerPage;
import com.qa.shopkick.pages.FirstUseDealsEducationPage;
import com.qa.shopkick.pages.FirstUseRegistrationIntroPage;
import com.qa.shopkick.pages.FirstUseRewardsEducationPage;
import com.qa.shopkick.pages.FirstUseWalkinEducationPage;
import com.qa.shopkick.pages.LandingPage;
import com.qa.shopkick.pages.MicrophonePermissionPage;
import com.qa.shopkick.pages.RewardsPickerPage;
import com.qa.shopkick.pages.SignInPage;
import com.qa.shopkick.utils.AbstractTest;
import com.qa.shopkick.utils.CustomHooks;


public class AuthenticationTests extends AbstractTest{

	@Test
	void FirstUseFlow(){
		//Go through the first use flow
		FirstUseDealsEducationPage.clickNextButton();
		CustomHooks.waitFor(2);

		if(PlatformType.equals("IOS")){
			CountryPickerPage.clickCountryUSA();
			CountryPickerPage.clickNextButton();
		}
		FirstUseWalkinEducationPage.clickNextButton();
		FirstUseRewardsEducationPage.clickPickARewardButton();

		//Pick default reward
		RewardsPickerPage.clickSelectRewardButton();
	}

	@Test
	void LoginWithFacebook(){
	PageFactory.initElements(new AppiumFieldDecorator(driver), new FirstUseRegistrationIntroPage());
		
		FirstUseRegistrationIntroPage.clickSignUpOrSignInButton();

		SignInPage.clicksignInFacebookSignIn();

		CustomHooks.waitFor(5);

		CustomHooks.dismissMultiLoginMessage();

		CustomHooks.waitFor(5);

		if (PlatformType.equalsIgnoreCase("IOS")) {
			if (MicrophonePermissionPage.isMicroPhonePermissionRequired()) {
				//if iOS and if mic permission is asked, give the permission
				MicrophonePermissionPage.clickOKButton();
			}
		}
		LandingPage.openLeftNavSignedIn();
	}

}
