package com.qa.shopkick.tests.KicksCenter;

import com.qa.shopkick.pages.*;
import com.qa.shopkick.tests.Authentication.LoginHooks;
import com.qa.shopkick.utils.AbstractTest;
import com.qa.shopkick.utils.CustomHooks;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HowToSectionTests extends AbstractTest
{

	@Test
	public void Test1_verifyHowToWalkins()
	{
		//Login with Facebook
		LoginHooks.loginWithFacebook();
		if(driver.findElement(By.name("Your settings")).isDisplayed()){
			CustomHooks.pressBack();
		}

		//Goes to kick center
		StoresPage.clickStoresPageKicksCenter();

		//Look for redeem reward message and dismiss it
		CustomHooks.dismissRedeemRewardMessage();

		KicksCenterRewadsPage.clickOnLearnHowToGetKicks();

		//TODO: Insert code to check if we go to learn how to get Kicks for Walk-ins and redirected to stores tab 
		//Look for the walk-in tutorial
		LearnHowGetMoreKicks.clickOnWalkinTutorial();

		//Call method to look for desired elements
		WalkInTutorialPage.verifyHowToWalkInUiElements();
	}

	@Test
	public void Test2_verifyHowToScans()
	{
		//Goes to kick center
		StoresPage.clickStoresPageKicksCenter();

		//Look for redeem reward message and dismiss it
		CustomHooks.dismissRedeemRewardMessage();

		KicksCenterRewadsPage.clickOnLearnHowToGetKicks();

		LearnHowGetMoreKicks.clickOnScanTutorial();
		//TODO: Insert code to check if we go to learn how to get Kicks for scans and redirected to stores tab

		ScanTutorialPage.verifyScanHowToElements();
	}

	@Test
	public void Test3_verifyHowToPurchases()
	{
		//Goes to kick center
		StoresPage.clickStoresPageKicksCenter();

		//Look for redeem reward message and dismiss it
		CustomHooks.dismissRedeemRewardMessage();

		KicksCenterRewadsPage.clickOnLearnHowToGetKicks();

		//TODO: Insert code to check if we go to learn how to get Kicks for purchases and redirected to stores tab
		LearnHowGetMoreKicks.clickOnPurchaseTutorial();
		PurchaseKicksPage.verifyLinkCardElements();
		CustomHooks.pressBack();
	}

	@Test
	public void Test4_verifyHowToKicksForInvites()
	{
		//Goes to kick center
		StoresPage.clickStoresPageKicksCenter();

		//Look for redeem reward message and dismiss it
		CustomHooks.dismissRedeemRewardMessage();
		
		KicksCenterRewadsPage.clickOnLearnHowToGetKicks();

		//TODO: Insert code to check if we go to learn how to get Kicks for Invites and redirected to Invites page
		
		LearnHowGetMoreKicks.clickOnInviteTutorial();
		
		CustomHooks.pressBack();
	}
}
