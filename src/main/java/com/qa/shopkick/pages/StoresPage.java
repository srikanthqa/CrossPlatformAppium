package com.qa.shopkick.pages;

import com.qa.shopkick.utils.ScreenBaseClass;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class StoresPage extends ScreenBaseClass {
	
	//Kicks center
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/kicks_counter\")")
	@iOSFindBy(uiAutomator = ".buttons()[\"arrow down white\"]")
	private static WebElement StoresPageKicksCenter;
	
	public static void clickStoresPageKicksCenter(){
		StoresPageKicksCenter.click();
		PageFactory.initElements(new AppiumFieldDecorator(driver),new KicksCenterRewadsPage());
		PageFactory.initElements(new AppiumFieldDecorator(driver),new RedeemGiftCardDialogPage());
	}
		
	//My Saves
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/promo_key_view\")")
	private static WebElement StoresPageMySaves;
	
	public static void clickStoresPageMySaves(){
		StoresPageMySaves.click();
	}
	
	//Promo image unit
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/promo_image\")")
	private static WebElement StoresPagePromoImage;
	
	public static void clickStoresPagePromoImage(){
		StoresPagePromoImage.click();
	}
	
	//searcgh bar
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/store_search_dummy_field\")")
	private static WebElement StoresPageStoreSearch;
	
	public static void clickStoresPageStoreSearch(){
		StoresPageStoreSearch.click();
		PageFactory.initElements(new AppiumFieldDecorator(driver),new StoreSearchPage());
	}
	
	//stores tab highlight
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/store_search_dummy_field\")")
	public static WebElement tabHighlight;
	
	
	//Stores tab carousel promo unit
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/promo_carousel_cell\")")
	public static WebElement promoUnitStoresTab;
	
	//StoresList Item
	@AndroidFindBy(id = "com.shopkick.app:id/name_and_kick_information")
	public static List <WebElement> recyclerViewStoresList;
	
	//StoreDistance items
	@AndroidFindBy(id = "com.shopkick.app:id/distance_text")
	public static List <WebElement> storesDistances;
	
	/************** BLAH ***************** REVIST ****************/
	
	//TODO: REVISIT THIS CODE AND BELOW
	
	//Old Navy
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/chain_name\").text(\"Old Navy\")")
	@iOSFindBy(uiAutomator = ".cells()[\"Old Navy\"]")
	private static WebElement StoresPageNameAndKickInformation;
	
	public static void clickStoresPageNameAndKickInformation(){
		StoresPageNameAndKickInformation.click();
		PageFactory.initElements(new AppiumFieldDecorator(driver),new ToolTipsPage());
	}
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/group_header_see_all_field\")")
	private static WebElement StoresPageDealsAndSalesSeeAll;
	
	public static void clickStoresPageDealsAndSalesSeeAll(){
		StoresPageDealsAndSalesSeeAll.click();
	}
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/offer_cell_left\")")
	private static WebElement StoresPageOfferCellLeft;
	
	public static void clickStoresPageOfferCellLeft(){
		StoresPageOfferCellLeft.click();
		PageFactory.initElements(new AppiumFieldDecorator(driver),new RelatedOfferPage());
	}
	
	@iOSFindBy(uiAutomator = ".cells()[\"Trending on shopkick\"].buttons()[0]")
	private static WebElement trendingNow;
	
	public static void clickOnTrendingOnShopkick(){
		trendingNow.click();
	}
	
	@AndroidFindBy(id = "com.shopkick.app:id/store_search_text_field")
	public static WebElement StoresPageSearchBox;
	

	@AndroidFindBy(id = "com.shopkick.app:id/chain_name")
	public static WebElement StoresPageChainName;
	
}
