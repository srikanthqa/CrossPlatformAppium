package com.qa.shopkick.tests.Authentication;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.qa.shopkick.pages.SignInPage;
import com.qa.shopkick.utils.AbstractTest;
import com.qa.shopkick.utils.CustomHooks;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GoogleAuthentication extends AbstractTest{

	@Test
	public void Test1_GooglePlusSignIn()
	{
		CustomHooks.dismissPotHoleError();
		//tap on the 'Guest' button to open left nav bar
		SignInPage.clicksignInGooglePlusSignIn();		
		CustomHooks.dismissMultiLoginMessage();
	}
	
	@Test
	public void Test2_logOutOfFacebook(){
		CustomHooks.LogMeOut();
	}

}
