package com.qa.shopkick.utils;

import com.qa.shopkick.pages.*;
import org.openqa.selenium.By;

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
