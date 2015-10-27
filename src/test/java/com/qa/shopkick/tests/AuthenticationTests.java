package com.qa.shopkick.tests;

import com.qa.shopkick.pages.*;
import com.qa.shopkick.utils.AbstractTest;
import com.qa.shopkick.utils.CustomHooks;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;


public class AuthenticationTests extends AbstractTest{

	@Test
	void FirstUseFlow(){
		//Go through the first use flow
		FirstUseDealsEducationPage.clickGetStartedButton();
		CustomHooks.waitFor(2);

		if(platformType.equals("IOS")){
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

		SignInPage.clickFacebookSignInButton();

		CustomHooks.waitFor(5);

		CustomHooks.dismissMultiLoginMessage();

		CustomHooks.waitFor(5);

		if (platformType.equalsIgnoreCase("IOS")) {
			if (MicrophonePermissionPage.isMicroPhonePermissionRequired()) {
				//if iOS and if mic permission is asked, give the permission
				MicrophonePermissionPage.clickOKButton();
			}
		}
		LandingPage.openLeftNavSignedIn();
	}

}
