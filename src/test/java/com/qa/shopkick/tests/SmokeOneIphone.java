package com.qa.shopkick.tests;

import org.junit.Test;

import com.qa.shopkick.pages.CountryPickerPage;
import com.qa.shopkick.pages.FirstUseDealsEducationPage;
import com.qa.shopkick.pages.FirstUseWalkinEducationPage;
import com.qa.shopkick.utils.AbstractTest;

public class SmokeOneIphone extends AbstractTest{
	
	@Test
	public void firstUseFlow(){
		FirstUseDealsEducationPage.clickNextButton();
		
		if(CountryPickerPage.clickAndProceedUSA() && !(FirstUseWalkinEducationPage.isGetPointsScreen())) 
		{
			CountryPickerPage.clickCountryUSA();
			CountryPickerPage.clickCountryUSA();
			CountryPickerPage.clickNextButton();
			//CountryPickerPage.clickNextButton();
		}
	}

}
