package com.qa.shopkick.pages;

import com.qa.shopkick.utils.AbstractPage;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends AbstractPage{

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/left_nav_user_image\")")
	private static WebElement leftNavUserImage;
	
	public static void openLeftNavSignedIn(){
		leftNavUserImage.click();
		PageFactory.initElements(new AppiumFieldDecorator(driver),new LeftNavBar());
	}
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/tab_title\").text(\"PRODUCTS\")")
	private static WebElement tabTitleProducts;
	
	public static void clicktabTitleProducts(){
		tabTitleProducts.click();
		PageFactory.initElements(new AppiumFieldDecorator(driver),new ProductsPage());
	}
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/tab_title\").text(\"STORES\")")
	private static WebElement tabTitleStores;
	
	public static void clicktabTitleStores(){
		tabTitleStores.click();
		PageFactory.initElements(new AppiumFieldDecorator(driver),new StoresPage());
	}
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/tab_title\").text(\"DEALS\")")
	private static WebElement tabTitleDeals;
	
	public static void clicktabTitleDeals(){
		tabTitleDeals.click();
		PageFactory.initElements(new AppiumFieldDecorator(driver),new DealsPage());
	}
}
