package com.qa.shopkick.tests;

import org.junit.Test;

import com.qa.shopkick.pages.AccountSettings;
import com.qa.shopkick.pages.CountryPickerPage;
import com.qa.shopkick.pages.DealAggregationPage;
import com.qa.shopkick.pages.DealsPage;
import com.qa.shopkick.pages.FirstUseDealsEducationPage;
import com.qa.shopkick.pages.FirstUseRegistrationIntroPage;
import com.qa.shopkick.pages.FirstUseRewardsEducationPage;
import com.qa.shopkick.pages.FirstUseWalkinEducationPage;
import com.qa.shopkick.pages.LandingPage;
import com.qa.shopkick.pages.LeftNavBar;
import com.qa.shopkick.pages.LeftNavSettings;
import com.qa.shopkick.pages.LookbookPage;
import com.qa.shopkick.pages.MicrophonePermissionPage;
import com.qa.shopkick.pages.OfferPage;
import com.qa.shopkick.pages.ProductsPage;
import com.qa.shopkick.pages.RelatedOfferPage;
import com.qa.shopkick.pages.RewardsPickerPage;
import com.qa.shopkick.pages.StoreViewPage;
import com.qa.shopkick.pages.StoresPage;
import com.qa.shopkick.pages.ToolTipsPage;
import com.qa.shopkick.utils.AbstractTest;
import com.qa.shopkick.utils.CustomHooks;

public class SmokeSuiteTwo extends AbstractTest{
	
	@Test
	public void GooglePlusFlow(){
				
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
	
		//Go back to store view
		CustomHooks.pressBack();
		
		//Go back to store tab
		CustomHooks.pressBack();
		
		//Go to Deals Tab
		LandingPage.clicktabTitleDeals();
		
		//Tap aggregate deals
		DealsPage.clickDealsPageChainName();
		
		//Save deal
		DealAggregationPage.clickDealAggregationSaveHeart();
		
		//Back to Deals Tab
		CustomHooks.pressBack();
		
		//Go to Products Tab
		LandingPage.clicktabTitleProducts();
		
		//Open lookbook
		ProductsPage.clickProductsPageLookbookCover();
		
		//Save offer in lookbook
		LookbookPage.clickLookbookPageLookbookOfferSaveHeart();
		
		//Back to Products Tab
		CustomHooks.pressBack();
		
		//Tap My Saves
		ProductsPage.clickProductsPageMySaves();
		
		////Verify all Saved Products
		
		//Unsave Product Page
		OfferPage.clickOfferPageOfferSaveButton();
		
		//Back to My Saves
		CustomHooks.pressBack();
		
		//Back to Products
		CustomHooks.pressBack();
		
		//Back to My Saves
		ProductsPage.clickProductsPageMySaves();
		
		////Verify Product has been removed
		
		//Back to Products
		CustomHooks.pressBack();
		
		//Logout
		LeftNavBar.clickGuestUserButton();
		
		LeftNavBar.clickOnSettingsLeftNav();
		
		LeftNavSettings.clicksettingsAccountSettings();
		
		AccountSettings.clickAccountSettingsLogOut();
		
	    }
	
}
				
