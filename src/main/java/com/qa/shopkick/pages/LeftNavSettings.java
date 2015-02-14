package com.qa.shopkick.pages;

import com.qa.shopkick.utils.AbstractPage;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LeftNavSettings extends AbstractPage {
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/more_login_item\").text(\"Register or sign in\")")
	private static WebElement settingsRegisterOrSignIn;
	
	public static void clicksettingsRegisterOrSignIn(){
		settingsRegisterOrSignIn.click();
	}
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/more_push_notification_button\").text(\"Push notifications\")")
	private static WebElement settingsPushNotifications;
	
	public static void clicksettingsPushNotifications(){
		settingsPushNotifications.click();
	}
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/more_vibrate_button\").text(\"Vibrate\")")
	private static WebElement settingsVibrate;
	
	public static void clicksettingsVibrate(){
		settingsVibrate.click();
	}
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/more_sound_button\").text(\"Sounds\")")
	private static WebElement settingsSounds;
	
	public static void clicksettingsSounds(){
		settingsSounds.click();
	}
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/more_local_notices_button\").text(\"New user notifications\")")
	private static WebElement settingsNewUserNotifications;
	
	public static void clicksettingsNewUserNotifications(){
		settingsNewUserNotifications.click();
	}
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/more_geofencing_button\").text(\"Notifications near/in stores\")")
	private static WebElement settingsNotificationsNearInStores;
	
	public static void clicksettingsNotificationsNearInStores(){
		settingsNotificationsNearInStores.click();
	}
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/more_my_profile_button\").text(\"Profile viewable to public\")")
	private static WebElement settingsProfileViewableToPublic;
	
	public static void clicksettingsProfileViewableToPublic(){
		settingsProfileViewableToPublic.click();
	}
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/more_edit_profile_button\").text(\"About you\")")
	private static WebElement settingsAboutYou;
	
	public static void clicksettingsAboutYou(){
		settingsAboutYou.click();
	}
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/more_buy_and_collect_button\").text(\"Kicks When You Buy\")")
	private static WebElement settingsKicksWhenYouBuy;
	
	public static void clicksettingsKicksWhenYouBuy(){
		settingsKicksWhenYouBuy.click();
	}
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/more_facebook_connect_button\").text(\"Connect to Facebook\")")
	private static WebElement settingsConnectToFacebook;
	
	public static void clicksettingsConnectToFacebook(){
		settingsConnectToFacebook.click();
	}
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/more_google_plus_connect_button\").text(\"Connect to Google +\")")
	private static WebElement settingsConnectToGooglePlus;
	
	public static void clicksettingsConnectToGooglePlus(){
		settingsConnectToGooglePlus.click();
	}
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/more_account_settings_button\").text(\"Account settings\")")
	private static WebElement settingsAccountSettings;
	
	public static void clicksettingsAccountSettings(){
		settingsAccountSettings.click();
		PageFactory.initElements(new AppiumFieldDecorator(driver),new AccountSettings());
		
	}
	
}
	
	