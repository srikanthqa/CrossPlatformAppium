package com.qa.shopkick.pages;

import com.qa.shopkick.utils.AbstractPage;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends AbstractPage{

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/left_nav_user_image\")")
	@iOSFindBy(uiAutomator = ".tableViews()[0].cells()[0].buttons()[0]")
	private static WebElement leftNavUserImage;
	
	public static void openLeftNavSignedIn(){
		leftNavUserImage.click();
		PageFactory.initElements(new AppiumFieldDecorator(driver),new LeftNavBar());
	}
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/tab_title\").text(\"PRODUCTS\")")
	@iOSFindBy(uiAutomator = ".tabBar().buttons()[\"Products\"]")
	private static WebElement tabTitleProducts;
	
	public static void clicktabTitleProducts(){
		tabTitleProducts.click();
		PageFactory.initElements(new AppiumFieldDecorator(driver),new ProductsPage());
	}
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/tab_title\").text(\"STORES\")")
	@iOSFindBy(uiAutomator = ".tabBar().buttons()[\"Stores\")")
	private static WebElement tabTitleStores;
	
	public static void clicktabTitleStores(){
		tabTitleStores.click();
		PageFactory.initElements(new AppiumFieldDecorator(driver),new StoresPage());
	}
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/tab_title\").text(\"DEALS\")")
	@iOSFindBy(uiAutomator = ".tabBar().buttons()[\"Deals\"]")
	private static WebElement tabTitleDeals;
	
	public static void clicktabTitleDeals(){
		tabTitleDeals.click();
		PageFactory.initElements(new AppiumFieldDecorator(driver),new DealsPage());
	}
}
