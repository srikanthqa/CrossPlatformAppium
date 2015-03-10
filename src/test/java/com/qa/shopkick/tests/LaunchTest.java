package com.qa.shopkick.tests;

import org.junit.Test;
import org.openqa.selenium.By;

import com.qa.shopkick.pages.AccountSettings;
import com.qa.shopkick.pages.ConfirmDeleteAccountPage;
import com.qa.shopkick.pages.CountryPickerPage;
import com.qa.shopkick.pages.DealAggregationPage;
import com.qa.shopkick.pages.DealDetailpage;
import com.qa.shopkick.pages.DealsListSearchPage;
import com.qa.shopkick.pages.DealsPage;
import com.qa.shopkick.pages.DeleteAccountPage;
import com.qa.shopkick.pages.DidYouKnowPage;
import com.qa.shopkick.pages.EmailSignInPage;
import com.qa.shopkick.pages.FirstUseAlternateScreen;
import com.qa.shopkick.pages.FirstUseDealsEducationPage;
import com.qa.shopkick.pages.FirstUseRegistrationIntroPage;
import com.qa.shopkick.pages.FirstUseRewardsEducationPage;
import com.qa.shopkick.pages.FirstUseWalkinEducationPage;
import com.qa.shopkick.pages.InviteAndGetKicksPage;
import com.qa.shopkick.pages.KicksCenterRewadsPage;
import com.qa.shopkick.pages.LandingPage;
import com.qa.shopkick.pages.LeftNavBar;
import com.qa.shopkick.pages.LeftNavSettings;
import com.qa.shopkick.pages.LinkPhonePage;
import com.qa.shopkick.pages.LookbookPage;
import com.qa.shopkick.pages.MicrophonePermissionPage;
import com.qa.shopkick.pages.MySavesPage;
import com.qa.shopkick.pages.OfferPage;
import com.qa.shopkick.pages.ProductsPage;
import com.qa.shopkick.pages.RelatedOfferPage;
import com.qa.shopkick.pages.RewardsPickerPage;
import com.qa.shopkick.pages.SignInPage;
import com.qa.shopkick.pages.StoresPage;
import com.qa.shopkick.pages.ToolTipsPage;
import com.qa.shopkick.pages.VerifyMobileNumber;
import com.qa.shopkick.utils.AbstractTest;
import com.qa.shopkick.utils.CustomHooks;

public class LaunchTest extends AbstractTest {

	/*TODO: Add more methods to verify change in kicks
	 * */
	public static String currentKicksBeforeLogin, currentKicksAfterLogin;

	@Test
	public void FirstUseFlow(){

		//Go through the first use flow
		FirstUseDealsEducationPage.clickNextButton();
		CustomHooks.waitFor(2);

		if(PlatformType.equals("IOS")){
			CountryPickerPage.clickCountryUSA();
			CountryPickerPage.clickNextButton();
		}
		FirstUseWalkinEducationPage.clickNextButton();
		FirstUseRewardsEducationPage.clickNextButton();

		//Pick default reward
		RewardsPickerPage.clickNextButton();

		FirstUseAlternateScreen.clickOnContinueAsGuestButton();

		//if iOS and if mic permission is asked, give the permission
		if(PlatformType.equals("IOS")){
			MicrophonePermissionPage.clickOKButton();
		}

		CustomHooks.waitFor(3);

		//tap on the 'Guest' button to open left nav bar
		LeftNavBar.clickGuestUserButton();

		//Read current kicks so you can compare if the user has signed in and the kicks have been updated

		currentKicksBeforeLogin = LeftNavBar.getCurrentKicksCount();

		LeftNavBar.clickOnFaceBookSignIn();

		CustomHooks.dismissMultiLoginMessage();

		CustomHooks.waitFor(3);
		driver.scrollTo("Settings");
		//click on settings

		LeftNavBar.clickOnSettingsLeftNav();

		//Go to Account settings
		LeftNavSettings.clicksettingsAccountSettings();

		//perform a logout
		AccountSettings.clickAccountSettingsLogOut();

		//From logout screen hit on email to create an account
		SignInPage.clicksignInEmailSignIn();

		//CREATE ACCOUNT
		//add email address
		EmailSignInPage.clickOnEmailAdrressMobileElements("trest2@sk.com");

		//add password
		EmailSignInPage.clickOnPasswordMobileElement("sktest123");

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

		//Click on search bar
		DealsPage.clickOnSearchBar();

		//close the keyboard
		CustomHooks.pressBack();

		//Search for store with deals available
		if(driver.findElement(By.name("Deals Available")).isDisplayed()){
			//click on available deal
			DealsListSearchPage.clickOnDealsAvailable();
		}

		else {
			driver.scrollTo("Deals available");
			DealsListSearchPage.clickOnDealsAvailable();
		}


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

	/***** SUITE THREE ****/

	@Test
	public void EmailLoginTest(){

		//User logs in via email
		SignInPage.clicksignInEmailSignIn();
		EmailSignInPage.clickOnEmailAdrressMobileElements("a@b.com");
		EmailSignInPage.clickOnPasswordMobileElement("aaaaaa");
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
