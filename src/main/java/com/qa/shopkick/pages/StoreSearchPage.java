package com.qa.shopkick.pages;

import com.qa.shopkick.utils.AbstractPage;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class StoreSearchPage extends AbstractPage{
	public static String searchedStore;

	//press back to dismiss keyboard

	//search bar
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/store_search_text_field\")")
	public static WebElement searchViewSearchBar;

	public static void clickOnSearchbarAndSearch(String storeName)
	{
		searchViewSearchBar.click();
		searchViewSearchBar.clear();
		searchViewSearchBar.sendKeys(storeName);

		//assign to a global variable
		searchedStore = storeName;
	}

	//Search results and clicking them
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/chain_name\")")
	public static WebElement searchResult;

	public static void selectSearchedStore()
	{
		//grab searchitem name
		String searchResultItem = searchResult.getText();

		//check the list item is same as the one user searched for
		if((searchResultItem.equalsIgnoreCase(searchedStore)))
		{
			searchResult.click();
			PageFactory.initElements(new AppiumFieldDecorator(driver),new StoreViewPage());
		}
	}
	
	//Location change button
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/choose_location\")")
	public static WebElement changeLocation;
	
	public static void clickOnChangeLocation() {
		changeLocation.click();
		PageFactory.initElements(new AppiumFieldDecorator(driver),new ChangeLocationPage());
	}

	//close search bar
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/clear_search\")")
	public static WebElement clearSearchButton;
	
	public static void clickClearSearchButton(){
		clearSearchButton.click();
		PageFactory.initElements(new AppiumFieldDecorator(driver),new StoresPage());
		
	}

}
