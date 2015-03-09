package com.qa.shopkick.utils;

import org.openqa.selenium.By;

import com.qa.shopkick.pages.DidYouKnowPage;

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
		CustomHooks.waitFor(8);

		if(driver.findElement(By.name("Did you know?")).isDisplayed()){
			DidYouKnowPage.tapOnDidYouKnow();
		}
	}
}
