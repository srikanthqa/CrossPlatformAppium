package com.qa.shopkick.pages;

import com.qa.shopkick.utils.AbstractPage;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class FirstUseAlternateScreen extends AbstractPage {
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceID(\"com.shopkick.app:id/button_text\").text(\"CONTINUE AS GUEST\")")
	public static WebElement continueAsGuestButton;

	public static void clickOnContinueAsGuestButton(){
		continueAsGuestButton.click();
		PageFactory.initElements(new AppiumFieldDecorator(driver),new MicrophonePermissionPage());
		PageFactory.initElements(new AppiumFieldDecorator(driver),new LeftNavBar());
	}
	
	public static boolean firstUseFlowLessScreen(){
		if(continueAsGuestButton.isEnabled()){
			return true;
		}
		else{
			return false;
		}

	}


}
