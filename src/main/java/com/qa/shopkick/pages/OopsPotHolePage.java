package com.qa.shopkick.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.qa.shopkick.utils.AbstractPage;

public class OopsPotHolePage extends AbstractPage{
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"android:id/button1\").text(\"OK\")")
	private static WebElement errorMessageOkButton;
	
	public static void clickOnOkToDismissError(){
		errorMessageOkButton.click();
		PageFactory.initElements(new AppiumFieldDecorator(driver), new SignInPage());
		PageFactory.initElements(new AppiumFieldDecorator(driver), new LandingPage());
		PageFactory.initElements(new AppiumFieldDecorator(driver), new DealsPage());
		PageFactory.initElements(new AppiumFieldDecorator(driver), new StoresPage());
		PageFactory.initElements(new AppiumFieldDecorator(driver), new ProductsPage());
	}

}
