package com.qa.shopkick.tests;

import org.junit.Test;
import org.openqa.selenium.By;

import com.qa.shopkick.pages.CountryPickerPage;
import com.qa.shopkick.pages.FirstUseDealsEducationPage;
import com.qa.shopkick.pages.FirstUseRegistrationIntroPage;
import com.qa.shopkick.pages.FirstUseRewardsEducationPage;
import com.qa.shopkick.pages.FirstUseWalkinEducationPage;
import com.qa.shopkick.pages.LeftNavBar;
import com.qa.shopkick.pages.MicrophonePermissionPage;
import com.qa.shopkick.pages.RewardsPickerPage;
import com.qa.shopkick.pages.SignInPage;
import com.qa.shopkick.utils.AbstractTest;

public class SmokeOneIphone extends AbstractTest{
	
	@Test
	public void firstUseFlow(){
		FirstUseDealsEducationPage.clickNextButton();
		
		if(driver.findElement(By.name("USA")).isDisplayed()) 
		{
			CountryPickerPage.clickCountryUSA();
			CountryPickerPage.clickCountryUSA();
			CountryPickerPage.clickNextButton();
			//CountryPickerPage.clickNextButton();
		}
		FirstUseWalkinEducationPage.clickNextButton();
		
		FirstUseRewardsEducationPage.clickNextButton();

		//Pick default reward
		RewardsPickerPage.clickNextButton();

		FirstUseRegistrationIntroPage.clickNoThanksButton();
		
		MicrophonePermissionPage.clickOKButton();
		
		LeftNavBar.clickGuestUserButton();
		
		LeftNavBar.clickOnFaceBookSignIn();
		
		
		
	}

}
