package com.qa.shopkick.tests;

import org.junit.Test;

import com.qa.shopkick.pages.CountryPickerPage;
import com.qa.shopkick.pages.FirstUseDealsEducationPage;
import com.qa.shopkick.pages.FirstUseRegistrationIntroPage;
import com.qa.shopkick.pages.FirstUseRewardsEducationPage;
import com.qa.shopkick.pages.FirstUseWalkinEducationPage;
import com.qa.shopkick.pages.LandingPage;
import com.qa.shopkick.pages.LeftNavBar;
import com.qa.shopkick.pages.MicrophonePermissionPage;
import com.qa.shopkick.pages.RelatedOfferPage;
import com.qa.shopkick.pages.RewardsPickerPage;
import com.qa.shopkick.pages.StoreViewPage;
import com.qa.shopkick.pages.StoresPage;
import com.qa.shopkick.pages.ToolTipsPage;
import com.qa.shopkick.utils.AbstractTest;

public class SmokeSuiteTwo extends AbstractTest{
	
	@Test
	public void GooglePlusFlow(){
		
		//Go through the first use flow
		FirstUseDealsEducationPage.clickNextButton();
		if(PlatformType.equals("IOS")){
			CountryPickerPage.clickCountryUSA();
			CountryPickerPage.clickNextButton();
		}
		FirstUseWalkinEducationPage.clickNextButton();
		FirstUseRewardsEducationPage.clickNextButton();
		
		//Pick default reward
		RewardsPickerPage.clickNextButton();

		FirstUseRegistrationIntroPage.clickNoThanksButton();
				
		//if iOS and if mic permission is asked, give the permission
		if(PlatformType.equals("IOS")){
			MicrophonePermissionPage.clickOKButton();
		}

		//tap on the 'Guest' button to open left nav bar
		LeftNavBar.clickGuestUserButton();

		LeftNavBar.clickOnGooglePlusSignIn();
		
		//Go to Stores
		LandingPage.openLeftNavSignedIn();
		
		//Open a store
		StoresPage.clickStoresPageNameAndKickInformation();
		
		////Verify tool tips and store elements
		
		/*
		 * CustomHooks.waitFor(5);
		 * 
		 * if( (driver.findElement(By.name("WALK-INS")).isDisplayed()) &&
		 * scans
		 * purchases
		 * 
		 * */
		
		//Close tool tips
		ToolTipsPage.clickToolTipCloseButton();
		
		//Go to product
		StoresPage.clickStoresPageOfferCellLeft();
		
		//Save product
		RelatedOfferPage.clickRelatedOfferSaveOffer();
	
		////Does this need to be RelatedOfferPage?
		StoreViewPage.clickStoreViewPageAppScreenBack();
		
		StoreViewPage.clickStoreViewPageAppScreenBack();
		
		//Go to Deals Tab
		LandingPage.clicktabTitleDeals();
		
		
		//Tap aggregate deals
		

		
	    }
	
}
				
