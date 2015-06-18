package com.qa.shopkick.tests.KicksCenter;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;

import com.qa.shopkick.pages.KicksCenterRewadsPage;
import com.qa.shopkick.pages.StoresPage;
import com.qa.shopkick.tests.Authentication.LoginHooks;
import com.qa.shopkick.utils.AbstractTest;
import com.qa.shopkick.utils.CustomHooks;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HowToSectionTests extends AbstractTest
{
	//From store screen go to Kicks center

	//Go to learn more section

	/*
	 * Go to Walk-ins -> it should lead to more stores
	 * 
	 * Go to Scans -> should lead to stores
	 * 
	 * Go to Invites -> Should go to invites page
	 * 
	 * */

	@Test
	public void Test1_verifyHowToWalkins()
	{
		//Login with Facebook
		LoginHooks.LoginWithfacebook();
		if(driver.findElement(By.name("Your settings")).isDisplayed()){
			CustomHooks.pressBack();
		}

		//Goes to kick center
		StoresPage.clickStoresPageKicksCenter();
		KicksCenterRewadsPage.clickOnLearnHowToGetKicks();
		
		//TODO: Insert code to check if we go to learn how to get Kicks for Walk-ins and redirected to stores tab 
	}

	@Test
	public void Test2_verifyHowToScans()
	{
		//Goes to kick center
		StoresPage.clickStoresPageKicksCenter();
		KicksCenterRewadsPage.clickOnLearnHowToGetKicks();
		
		//TODO: Insert code to check if we go to learn how to get Kicks for scans and redirected to stores tab
	}

	@Test
	public void Test3_verifyHowToPurchases()
	{
		//Goes to kick center
		StoresPage.clickStoresPageKicksCenter();
		KicksCenterRewadsPage.clickOnLearnHowToGetKicks();
		
		//TODO: Insert code to check if we go to learn how to get Kicks for purchases and redirected to stores tab
	}

	@Test
	public void Test4_verifyHowToKicksForInvites()
	{
		//Goes to kick center
		StoresPage.clickStoresPageKicksCenter();
		KicksCenterRewadsPage.clickOnLearnHowToGetKicks();
		
		//TODO: Insert code to check if we go to learn how to get Kicks for Invites and redirected to Invites page
	}
}
