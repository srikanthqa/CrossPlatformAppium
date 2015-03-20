package com.qa.shopkick.pages;

import java.util.logging.Logger;

import com.qa.shopkick.utils.AbstractPage;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import mx4j.log.Log;
import mx4j.log.Log4JLogger;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Srikanth on 12/16/14.
 */
public class CountryPickerPage extends AbstractPage{

	@iOSFindBy(uiAutomator = ".buttons()[3]")
	private static WebElement countryUSA;

	@iOSFindBy(uiAutomator = ".buttons()[2]")
	private static WebElement countryGermany;

	@iOSFindBy(uiAutomator = ".buttons()[\"Next\"]")
	private static WebElement nextButton;

	@iOSFindBy(uiAutomator = ".staticTexts()[\"Tell us where you want to see deals.\"]")
	private static WebElement countryPickerText;

	public static void clickCountryUSA(){
		countryUSA.click();
	}

	public static void clickCountryGermany(){
		countryGermany.click();
	}

	public static void clickNextButton(){
		nextButton.click();
		PageFactory.initElements(new AppiumFieldDecorator(driver),new FirstUseWalkinEducationPage());
	}

	public static boolean clickAndProceedUSA() {
		if(countryPickerText.isDisplayed()){
			return true;
		}
		else{
			return false;
		}
	}
}
