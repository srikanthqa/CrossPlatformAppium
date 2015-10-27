package com.qa.shopkick.pages;

import com.qa.shopkick.utils.ScreenBaseClass;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ChangeLocationPage extends ScreenBaseClass {

	public static String searchedCity;
	public static String resultCity;

	//search location
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/location_search_bar\")")
	public static WebElement searchLocation;

	public static void clickAndChangeLocation(String searchCity, String state) {
		
		StringBuilder searchLocationAndState = new StringBuilder();
		searchLocationAndState.append(searchCity);
		searchLocationAndState.append(", ");
		searchLocationAndState.append(state);
		
		searchCity = searchLocationAndState.toString();
		
		searchLocation.click();
		searchLocation.clear();
		searchLocation.sendKeys(searchCity);
	}

	//current location
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/current_location\")")
	public static WebElement currentLocationButton;
	
	public static void clickCurrentLocation()
	{
		currentLocationButton.click();
	}
	
	//search location result item
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/location_name\")")
	public static WebElement searchResultItem;
	
	public static void selectSearchresultItem()
	{
		resultCity = searchResultItem.getText();
		if(searchedCity.equalsIgnoreCase(resultCity));
		{
			searchResultItem.click();
			PageFactory.initElements(new AppiumFieldDecorator(driver),new StoresPage());
			PageFactory.initElements(new AppiumFieldDecorator(driver),new StoreSearchPage());
		}
	}

	
}
