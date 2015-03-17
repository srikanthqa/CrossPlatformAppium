package com.qa.shopkick.pages;

import com.qa.shopkick.utils.AbstractPage;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage extends AbstractPage {
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/kicks_counter\")")
	private static WebElement ProductsPageKicksCounter;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/tab_title\")")
	private static WebElement ProductsPageTabTitle;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/tab_highlight\")")
	private static WebElement ProductsPageTabHighlight;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/button_icon\")")
	@iOSFindBy(uiAutomator = ".buttons()[\"heart icon filled white\"]")
	private static WebElement ProductsPageMySaves;
	
	public static void clickProductsPageMySaves(){
		ProductsPageMySaves.click();
		PageFactory.initElements(new AppiumFieldDecorator(driver), new MySavesPage());
	}
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/subtab_name\")")
	private static WebElement ProductsPageSubTabName;
	
	public static void clickProductsPageSubTabName(){
		ProductsPageSubTabName.click();
	}
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/title_text\").text(\"Unlock up to 5000 kicks toward your first FREE reward!\")")
	private static WebElement ProductsPageNewUserScanBonus;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/lookbook_title\")")
	@iOSFindBy(uiAutomator = ".tableViews()[0].cells()[0].buttons()[0]")
	private static WebElement ProductsPageLookbookCover;
	
	public static void clickProductsPageLookbookCover(){
		ProductsPageLookbookCover.click();
		PageFactory.initElements(new AppiumFieldDecorator(driver), new LookbookPage());
	}
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/unread_label\").text(\"new\")")
	private static WebElement ProductsPageUnreadLabel;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/button_icon\")")
	private static WebElement ProductsPageLookbookSaveHeart;
	
	public static void clickProductsPageLookbookSaveHeart(){
		ProductsPageLookbookSaveHeart.click();	
	}
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/lookbook_title\")")
	private static WebElement ProductsPageLookbookTitle;
	
	
	
}
