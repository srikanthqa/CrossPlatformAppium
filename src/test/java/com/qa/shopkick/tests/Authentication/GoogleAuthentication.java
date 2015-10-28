package com.qa.shopkick.tests.Authentication;

import com.qa.shopkick.tests.AbstractTest;
import com.qa.shopkick.utils.CustomHooks;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GoogleAuthentication extends AbstractTest{

	@Test
	public void Test1_GooglePlusSignIn()
	{
		LoginHooks.loginWithGoogleplus();
	}
	
	@Test
	public void Test2_logOutOfFacebook(){
		CustomHooks.LogMeOut();
	}

}
