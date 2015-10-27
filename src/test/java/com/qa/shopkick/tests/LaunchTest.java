package com.qa.shopkick.tests;

import com.qa.shopkick.pages.*;
import com.qa.shopkick.utils.AbstractTest;
import com.qa.shopkick.utils.CustomHooks;
import org.junit.Test;
import org.openqa.selenium.By;

public class LaunchTest extends AbstractTest {

	/*TODO: Add more methods to verify change in kicks
	 * */
	public static String currentKicksBeforeLogin, currentKicksAfterLogin;

	@Test 
	public void FirstUseFlow(){

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

		FirstUseAlternateScreen.clickOnContinueAsGuestButton();

		//CustomHooks.dismissPotHoleError();
		//if iOS and if mic permission is asked, give the permission
		if(platformType.equals("IOS")){
			MicrophonePermissionPage.clickOKButton();
		}

		CustomHooks.waitFor(3);

		//tap on the 'Guest' button to open left nav bar
		LeftNavBar.clickGuestUserButton();

		//Read current kicks so you can compare if the user has signed in and the kicks have been updated


		//confirm password
		EmailSignInPage.enterConfirmPassword();

		//Add first and last name
		EmailSignInPage.clickAndEnterFirstName();
		EmailSignInPage.clickAndEnterLastName();

		//Hit sign up
		EmailSignInPage.clickOnSignUpButton();

		CustomHooks.waitFor(5);

		//Phone number screen

		//add phone number
		LinkPhonePage.clickAndEnterPhoneNumber();

		//Add zipcode
		LinkPhonePage.clickAndEnterZipcode();

		//hit continue
		LinkPhonePage.clickOnCompleteRegistration();

		CustomHooks.waitFor(10);

		//Hit Not right now in verify phone number page
		VerifyMobileNumber.clickNotNowForVerifyPhone();

		//From landing page [stores tab]

		if(!driver.findElement(By.name("Your settings")).isDisplayed()){
			//Go to left nav bar
			LandingPage.openLeftNavSignedIn();

			//Go to settings
			LeftNavBar.clickOnSettingsLeftNav();

		}

		//Go to Account settings
		LeftNavSettings.clicksettingsAccountSettings();

		//Tap on delete account
		AccountSettings.clickAccountSettingsDeleteAccount();

		//In delete account tap on confirm delete account
		DeleteAccountPage.clickAndDeleteAccountWithPassword();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Tap on top left corner to proceed with delete
		DeleteAccountPage.clickToProceedDelete();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//Comfirm delete account
		ConfirmDeleteAccountPage.clickOnDeleteAccountConfirm();
	}

	/**** SUITE TWO****/

	@Test
	public void GooglePlusFlow()
	{
		//		CustomHooks.dismissPotHoleError();

		//tap on the 'Guest' button to open left nav bar
		SignInPage.clicksignInGooglePlusSignInButton();

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

		//CustomHooks.dismissPotHoleError();

		CustomHooks.waitFor(3);

		DealsPage.clickOnSearchBar();

		CustomHooks.pressBack();

		DealsListSearchPage.clickOnDealsAvailable();
		/*
		 * TODO: Make tappign on deals more generic, not hardcoded
		 *  //Click on search bar
		 * search for a store
		//close the keyboard
		//Search for store with deals available
		 */

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

		//Tap on a product
		MySavesPage.clickMySavesANYOfferTile();

		//Unsave Product Page
		OfferPage.clickOfferPageOfferSaveButton();

		//Back to My Saves
		CustomHooks.pressBack();

		//Back to Products
		CustomHooks.pressBack();

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

	/***** SUITE THREE ****/

	@Test
	public void EmailLoginTest(){

		//CustomHooks.dismissPotHoleError();

		//User logs in via email
		SignInPage.clickSignInEmailSignInButton();
		EmailSignInPage.typeEmailANDROID("a@b.com");
		EmailSignInPage.typePasswordANDROID("aaaaaa");
		EmailSignInPage.clickOnSignUpButton();

		CustomHooks.dismissMultiLoginMessage();

		//Goes to kick center
		StoresPage.clickStoresPageKicksCenter();

		//Add a dismiss congratulations message
		CustomHooks.dismissRedeemRewardMessage();

		//Learn how to get kicks
		KicksCenterRewadsPage.clickOnLearnHowToGetKicks();

		//verify all items are displayed
		//TODO: Figure out elements to verify in this flow

		//Go back
		CustomHooks.pressBack();

		//Verify change rewards
		KicksCenterRewadsPage.clickOnChangeReward();

		driver.scrollTo("3400");
		if(driver.findElement(By.name("3400")).isDisplayed()){
			RewardsPickerPage.clickGasReward();
		}

		if(driver.findElement(By.name("1875000")).isDisplayed()){
			RewardsPickerPage.clickVespaReward();
		}


		CustomHooks.pressBack();

		//Verify rewards displayed

		KicksCenterRewadsPage.clickOnseeAllRewardsFullWidth();

		//Rewards Mall 
		//Scroll to bottom
		driver.scrollTo("1875000");
		//Scroll back to top
		driver.scrollTo("You earned");

		//Go back
		CustomHooks.pressBack();

		//Go back
		CustomHooks.pressBack();

		//Redeem a reward (from kick center)
		//TODO: Redeem reward flo

		//Open left nav
		LandingPage.openLeftNavSignedIn();


		//Go to invite friends
		LeftNavBar.clickOnInviteLeftNav();
		InviteAndGetKicksPage.clickOninviteFrendsButton();

		//Verify all elements
		CustomHooks.pressBack();
		CustomHooks.pressBack();

		//Logout
		LandingPage.openLeftNavSignedIn();

		driver.scrollTo("Settings");

		LeftNavBar.clickOnSettingsLeftNav();

		LeftNavSettings.clicksettingsAccountSettings();

		AccountSettings.clickAccountSettingsLogOut();
	}

	//@After
	public void teardown(){
		//driver.resetApp();
	}

}
