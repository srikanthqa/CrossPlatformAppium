package com.qa.shopkick.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import junit.framework.Assert;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.qa.shopkick.utils.AbstractPage;

@SuppressWarnings("deprecation")
public class ProductsPage extends AbstractPage {

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/kicks_counter\")")
	private static WebElement ProductsPageKicksCounter;

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/tab_title\").text(\"PRODUCTS\")")
	private static WebElement ProductsPageTabTitle;

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/tab_highlight\")")
	private static WebElement ProductsPageTabHighlight;

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/heart\")")
	@iOSFindBy(uiAutomator = ".buttons()[\"heart icon filled white\"]")
	private static WebElement ProductsPageMySaves;

	public static void clickProductsPageMySaves(){
		ProductsPageMySaves.click();
		PageFactory.initElements(new AppiumFieldDecorator(driver), new MySavesPage());
	}

	//Method and def are obsolete
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/subtab_name\")")
	private static WebElement ProductsPageSubTabName;

	public static void clickProductsPageSubTabName(){
		ProductsPageSubTabName.click();
	}

	//Obsolete for products tab
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/title_text\").text(\"Unlock up to 5000 kicks toward your first FREE reward!\")")
	private static WebElement ProductsPageNewUserScanBonus;

	// Obsolete
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/lookbook_title\")")
	@iOSFindBy(uiAutomator = ".tableViews()[0].cells()[0].buttons()[0]")
	private static WebElement ProductsPageLookbookCover;

	public static void clickProductsPageLookbookCover(){
		ProductsPageLookbookCover.click();
		PageFactory.initElements(new AppiumFieldDecorator(driver), new LookbookPage());
	}

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/tile_flag\").text(\"JUST IN\")")
	private static WebElement ProductsPageUnreadLabel;

	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/fave_heart\")")
	private static WebElement ProductsPageLookbookSaveHeart;

	public static void clickProductsPageLookbookSaveHeart(){
		ProductsPageLookbookSaveHeart.click();	
	}

	//Obsoloete
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/lookbook_title\")")
	private static WebElement ProductsPageLookbookTitle;

	//Regular lookbook
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/lookbook_image\")")
	private static WebElement ProductsPageLookbookImage;

	public static void clickProductsPageLookbookImage(){
		ProductsPageLookbookImage.click();
	}

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/checkmark\")")
	private static WebElement ProductsPageCheckmark;

	public static void verifyCheckMarkForLookBooks(){
		Assert.assertTrue(ProductsPageCheckmark.isDisplayed());
	}

	//Branded lookbook
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/branded_lookbook_image\")")
	private static WebElement ProductsPageBrandedLookbookImage;

	public static void clickProductsPageBrandedLookbookImage(){
		ProductsPageBrandedLookbookImage.click();
	}

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/subtab_name\").text(\"WOMEN\")")
	private static WebElement ProductsPageWomenTab;

	public static void clickProductsPageWomenTab(){
		ProductsPageWomenTab.click();
	}

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/subtab_name\").text(\"TRENDING\")")
	private static WebElement ProductsPageTrendingTab;

	public static void clickProductsPageTrendingTab(){
		ProductsPageTrendingTab.click();
	}

}

