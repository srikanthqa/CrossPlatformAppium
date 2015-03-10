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
import com.qa.shopkick.pages.MySavesPage;
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
	public void GooglePlusFlow()
	{
		CustomHooks.dismissPotHoleError();

		//tap on the 'Guest' button to open left nav bar
		SignInPage.clicksignInGooglePlusSignIn();		

		CustomHooks.dismissMultiLoginMessage();

		//Go to Stores
		LandingPage.clicktabTitleStores();

		//Open a store
		StoresPage.clickStoresPageNameAndKickInformation();

		//wait for tool tips to load
		CustomHooks.waitFor(10);

		//Close tool tips
		ToolTipsPage.clickToolTipCloseButton();

		driver.scrollTo("Trending on shopkick");

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

		CustomHooks.waitFor(3);


		//Look for Carters or Michaels or Target
		if(driver.findElement(By.name("Carter's")).isDisplayed())
		{
			DealsPage.clickDealsPageCarters();
		}
		else if(driver.findElement(By.name("Michaels")).isDisplayed()){
			DealsPage.clickDealsPageMichales();
		}
		else if(driver.findElement(By.name("Old Navy")).isDisplayed()) {
			DealsPage.clickDealsPageMichales();
		}
		else if(driver.findElement(By.name("Target")).isDisplayed()) {
			DealsPage.clickDealsPageTarget();
		}
		else
		{
			driver.scrollTo("Aerie");
			DealsPage.clickDealsPageAerie();
		}

		/*
		 * TODO: Make tappign on deals more generic, not hardcoded
		 *  //Click on search bar
		 * search for a store
			//close the keyboard
			//Search for store with deals available
		 */

		//Tap to open the deal use deal titile and index
		DealAggregationPage.clickOnDealTile();

		if(!driver.findElement(By.name("SAVE")).isDisplayed()){
			//Save deal
			DealDetailpage.clickOnSaveDeal();
		}
		else{
			DealDetailpage.unSaveDeal();
		}

		//Back to Deals Tab
		CustomHooks.pressBack();
		CustomHooks.pressBack();

		//Go to Products Tab
		LandingPage.clicktabTitleProducts();

		//CustomHooks.dismissPotHoleError();

		//Open lookbook
		ProductsPage.clickProductsPageLookbookCover();

		//Save offer in lookbook
		LookbookPage.clickLookbookPageLookbookOfferSaveHeart();

		//Back to Products Tab
		CustomHooks.pressBack();

		//Tap My Saves
		ProductsPage.clickProductsPageMySaves();

		//Tap on a product
		MySavesPage.clickMySavesANYOfferTile();

		//Unsave Product Page
		OfferPage.clickOfferPageOfferSaveButton();

		//Back to My Saves
		CustomHooks.pressBack();

		//Back to Products
		CustomHooks.pressBack();

		CustomHooks.pressBack();
		//TODO: Add verification
		//Back to My Saves
		//ProductsPage.clickProductsPageMySaves();

		//Logout
		LandingPage.openLeftNavSignedIn();

		driver.scrollTo("Settings");

		LeftNavBar.clickOnSettingsLeftNav();

		LeftNavSettings.clicksettingsAccountSettings();

		AccountSettings.clickAccountSettingsLogOut();

	}
	@After
	public void teardown(){


	}

}

