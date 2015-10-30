package com.qa.shopkick.tests;

import com.qa.shopkick.appium.AbstractTestCase;
import com.qa.shopkick.pages.*;
import com.qa.shopkick.utils.CustomHooks;
import org.junit.After;
import org.junit.Test;

public class SmokeSuiteTwo extends AbstractTestCase {

    @Test
    public void GooglePlusFlow() {
        CustomHooks.dismissPotHoleError();

        //tap on the 'Guest' button to open left nav bar
        SignInPage.clickGooglePlusSignInButton();

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

        if (platformType.equals("IOS")) {
            //tap on all trending
            StoresPage.clickOnTrendingOnShopkick();
            //tap on cell
            RelatedOfferPage.clickOnFirstTrendingItem();
        } else {
            //Go to product
            StoresPage.clickStoresPageOfferCellLeft();
        }

        //Save product
        RelatedOfferPage.clickRelatedOfferSaveOffer();

        //Go back to store view
        CustomHooks.pressBack();

        //Go back to store tab
        CustomHooks.pressBack();

        //Go to Deals Tab
        LandingPage.clicktabTitleDeals();

        CustomHooks.waitFor(3);

		/*
         * TODO: Make going to a deal more generic
		 * Go to search in deals
		 * Search for a store
		 * Open store
		 * 
		 * */

        //Look for Carters or Michaels or Target
        driver.scrollTo("Michaels");

        if (platformType.equals("IOS")) {
            DealsPage.clickOnMichaelsIOS();
        } else {
            //Go to product
            DealsPage.clickDealsPageMichales();
        }

        //Tap to open the deal use deal titile and index
        DealAggregationPage.clickOnDealTile();

        DealDetailpage.clickOnSaveDeal();

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

		/*
         *TODO: Add logic to tap on products tab under my saves
		 * */

        //Tap on a product
        MySavesPage.clickMySavesANYOfferTile();

        //Unsave Product Page
        OfferPage.clickOfferPageOfferSaveButton();

        //Back to My Saves
        CustomHooks.pressBack();

        //Hit back to go to products / landing page
        MySavesPage.clickOnBackButton();

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
    public void teardown() {


    }

}

