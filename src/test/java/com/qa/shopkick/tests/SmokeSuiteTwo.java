package com.qa.shopkick.tests;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;

import com.qa.shopkick.pages.AccountSettings;
import com.qa.shopkick.pages.CountryPickerPage;
import com.qa.shopkick.pages.DealAggregationPage;
import com.qa.shopkick.pages.DealDetailpage;
import com.qa.shopkick.pages.DealsPage;
import com.qa.shopkick.pages.DidYouKnowPage;
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
import com.qa.shopkick.pages.SignInPage;
import com.qa.shopkick.pages.StoreViewPage;
import com.qa.shopkick.pages.StoresPage;
import com.qa.shopkick.pages.ToolTipsPage;
import com.qa.shopkick.utils.AbstractTest;
import com.qa.shopkick.utils.CustomHooks;

public class SmokeSuiteTwo extends AbstractTest{

	@Test
	public void GooglePlusFlow(){

		//tap on the 'Guest' button to open left nav bar
		SignInPage.clicksignInGooglePlusSignIn();		

		CustomHooks.waitFor(3);

		//in case of multi user login
		if(driver.findElement(By.name("Did you know?")).isDisplayed()){
			DidYouKnowPage.tapOnDidYouKnow();
		}

		//Go to Stores
		LandingPage.clicktabTitleStores();

		//Open a store
		StoresPage.clickStoresPageNameAndKickInformation();

		//wait for tool tips to load
		CustomHooks.waitFor(7);
		
		//Close tool tips
		ToolTipsPage.clickToolTipCloseButton();

		//Go to product
		StoresPage.clickStoresPageOfferCellLeft();

		//Save product`
		RelatedOfferPage.clickRelatedOfferSaveOffer();

		//Go back to store view
		CustomHooks.pressBack();

		//Go back to store tab
		CustomHooks.pressBack();

		//Go to Deals Tab
		LandingPage.clicktabTitleDeals();

		
		//Tap to open the deal use deal titile and index
		DealAggregationPage.clickOnDealTile();
		
		//Save deal
		DealDetailpage.clickOnSaveDeal();
		
//		//Save deal
//		DealAggregationPage.clickDealAggregationSaveHeart();

		//Back to Deals Tab
		CustomHooks.pressBack();
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
	
	@After
	public void teardown(){


	}

}

