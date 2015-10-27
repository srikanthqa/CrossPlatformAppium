package com.qa.shopkick.pages;

import com.qa.shopkick.utils.ScreenBaseClass;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ConfirmDeleteAccountPage extends ScreenBaseClass {

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/app_screen_header\").text(\"Confirm Account Deletion\")")
	private static WebElement deleteAccountHeader;


	@iOSFindBy(uiAutomator = ".buttons()[\"Delete\"]")
	private static WebElement deleteAccountButton;

	public static void clickOnConfirmDeleteIOS(){
		deleteAccountButton.click();
		PageFactory.initElements(new AppiumFieldDecorator(driver),new SignInPage());
	}

	//used mobile element since its a hybrid view
	public static void clickOnDeleteAccountConfirm(){
		MobileElement confirmDelete = (MobileElement) driver.findElement(By.name("DELETE"));
		confirmDelete.click();
		PageFactory.initElements(new AppiumFieldDecorator(driver),new SignInPage());
	}

}
