package com.qa.shopkick.pages;

import com.qa.shopkick.utils.ScreenBaseClass;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LeftNavSettings extends ScreenBaseClass {

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/more_login_item\").text(\"Your settings\")")
    private static WebElement settingsPageHeader;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/app_screen_header\").text(\"Register or sign in\")")
    private static WebElement settingsRegisterOrSignIn;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/more_push_notification_button\").text(\"Push notifications\")")
    private static WebElement settingsPushNotifications;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/more_vibrate_button\").text(\"Vibrate\")")
    private static WebElement settingsVibrate;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/more_sound_button\").text(\"Sounds\")")
    private static WebElement settingsSounds;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/more_local_notices_button\").text(\"New user notifications\")")
    private static WebElement settingsNewUserNotifications;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/more_geofencing_button\").text(\"Notifications near/in stores\")")
    private static WebElement settingsNotificationsNearInStores;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/more_my_profile_button\").text(\"Profile viewable to public\")")
    private static WebElement settingsProfileViewableToPublic;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/more_edit_profile_button\").text(\"About you\")")
    private static WebElement settingsAboutYou;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/more_buy_and_collect_button\").text(\"Kicks When You Buy\")")
    private static WebElement settingsKicksWhenYouBuy;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/more_facebook_connect_button\").text(\"Connect to Facebook\")")
    private static WebElement settingsConnectToFacebook;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/more_google_plus_connect_button\").text(\"Connect to Google +\")")
    private static WebElement settingsConnectToGooglePlus;
    @iOSFindBy(uiAutomator = ".buttons()[\"Account settings\"]")
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/more_account_settings_button\").text(\"Account settings\")")
    private static WebElement settingsAccountSettings;
    @iOSFindBy(uiAutomator = ".buttons()[\"About You\"]")
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/more_account_settings_button\").text(\"About You\")")
    private static WebElement settingsAboutSettings;

    public static void clicksettingsRegisterOrSignIn() {
        settingsRegisterOrSignIn.click();
    }

    public static void clicksettingsPushNotifications() {
        settingsPushNotifications.click();
    }

    public static void clicksettingsVibrate() {
        settingsVibrate.click();
    }

    public static void clicksettingsSounds() {
        settingsSounds.click();
    }

    public static void clicksettingsNewUserNotifications() {
        settingsNewUserNotifications.click();
    }

    public static void clicksettingsNotificationsNearInStores() {
        settingsNotificationsNearInStores.click();
    }

    public static void clicksettingsProfileViewableToPublic() {
        settingsProfileViewableToPublic.click();
    }

    public static void clicksettingsAboutYou() {
        settingsAboutYou.click();
    }

    public static void clicksettingsKicksWhenYouBuy() {
        settingsKicksWhenYouBuy.click();
    }

    public static void clicksettingsConnectToFacebook() {
        settingsConnectToFacebook.click();
    }

    public static void clicksettingsConnectToGooglePlus() {
        settingsConnectToGooglePlus.click();
    }

    public static void clicksettingsAccountSettings() {
        settingsAccountSettings.click();
        PageFactory.initElements(new AppiumFieldDecorator(driver), new AccountSettings());

    }

    public static void clickAboutYouSettings() {
        settingsAboutSettings.click();
        PageFactory.initElements(new AppiumFieldDecorator(driver), new AccountSettings());

    }

}

