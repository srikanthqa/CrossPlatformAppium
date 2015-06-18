package com.qa.shopkick.tests.Authentication;

import com.qa.shopkick.pages.EmailSignInPage;
import com.qa.shopkick.pages.MicrophonePermissionPage;
import com.qa.shopkick.pages.SignInPage;
import com.qa.shopkick.utils.AbstractTest;
import com.qa.shopkick.utils.CustomHooks;

public class LoginHooks extends AbstractTest{

	public static void LoginWithfacebook()
	{
		//from first use flow log into facebook
		CustomHooks.dismissPotHoleError();

		SignInPage.clicksignInFacebookSignIn();

		CustomHooks.waitFor(5);

		CustomHooks.dismissMultiLoginMessage();

		CustomHooks.waitFor(5);

		if (PlatformType.equalsIgnoreCase("IOS")) {
			if (MicrophonePermissionPage.isMicroPhonePermissionRequired()) {
				//if iOS and if mic permission is asked, give the permission
				MicrophonePermissionPage.clickOKButton();
			}
		}
	}
	
	public static void LoginWithGplus()
	{
		CustomHooks.dismissPotHoleError();
		//tap on the 'Guest' button to open left nav bar
		SignInPage.clicksignInGooglePlusSignIn();		
		CustomHooks.dismissMultiLoginMessage();
	}
	
	public static void EmailLogin()
	{
		CustomHooks.dismissPotHoleError();

		//User logs in via email
		SignInPage.clicksignInEmailSignIn();

		//Element issues, using two different methods to sign in

		if (PlatformType.equalsIgnoreCase("Android")) {

			//add email address
			EmailSignInPage.clickAndEnterEmailANDROID("a@b.com");
			//add password
			EmailSignInPage.clickAndEnterPswdANDROID("aaaaaa");
		}
		else
		{
			EmailSignInPage.clickAndEnterEmailIOS("a@b.com");

			EmailSignInPage.clickAndEnterPasswordIOS("aaaaaa");
		}

		CustomHooks.dismissMultiLoginMessage();
	}

}
