package com.qa.shopkick.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.qa.shopkick.utils.AbstractPage;

public class OopsPotHolePage extends AbstractPage{
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"android:id/button1\").text(\"OK\")")
	private static WebElement errorMessageOkButtonWebElement;
	
	public static void clickOnOkToDismissError(){
		MobileElement errorMessageOkButton = (MobileElement) driver.findElement(By.name("OK"));
		errorMessageOkButton.click();
		PageFactory.initElements(new AppiumFieldDecorator(driver), new SignInPage());
		PageFactory.initElements(new AppiumFieldDecorator(driver), new LandingPage());
		PageFactory.initElements(new AppiumFieldDecorator(driver), new DealsPage());
		PageFactory.initElements(new AppiumFieldDecorator(driver), new StoresPage());
		PageFactory.initElements(new AppiumFieldDecorator(driver), new ProductsPage());
	}

}
