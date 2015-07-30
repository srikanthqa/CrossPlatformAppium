package com.qa.shopkick.utils;

import org.openqa.selenium.By;

import com.qa.shopkick.pages.AccountSettings;
import com.qa.shopkick.pages.DidYouKnowPage;
import com.qa.shopkick.pages.LandingPage;
import com.qa.shopkick.pages.LeftNavBar;
import com.qa.shopkick.pages.LeftNavSettings;
import com.qa.shopkick.pages.OopsPotHolePage;
import com.qa.shopkick.pages.RedeemGiftCardDialogPage;

public class CustomHooks extends AbstractPage{

	public static void pressBack(){
		driver.navigate().back();
	}

	public static void waitFor(int seconds){
		int millSeconds = seconds*1000;
		try {
			Thread.sleep(millSeconds);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void dismissMultiLoginMessage(){
		waitFor(3);
		if(driver.findElement(By.name("Did you know?")).isDisplayed()){
			DidYouKnowPage.tapOnDidYouKnow();
		}
	}

	public static void dismissRedeemRewardMessage(){
		waitFor(3);
		if(driver.findElement(By.name("Congrats!")).isDisplayed()){
			RedeemGiftCardDialogPage.clickToDismiss();
		}
	}

	public static void dismissPotHoleError(){
		waitFor(5);
		if(driver.findElement(By.name("Oops!")).isDisplayed() || driver.findElement(By.name("OK")).isDisplayed()){
			OopsPotHolePage.clickOnOkToDismissError();
		}

	}

	public static void LogMeOut(){
		// before calling method leave app state in stores screen
		LandingPage.openLeftNavSignedIn();
		
		waitFor(3);
		
		driver.scrollTo("Settings");
		//click on settings
		LeftNavBar.clickOnSettingsLeftNav();
		
		LeftNavSettings.clicksettingsAccountSettings();

		AccountSettings.clickAccountSettingsLogOut();
		
		
	}
}
