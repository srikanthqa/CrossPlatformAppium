package com.qa.shopkick.pages;


import com.qa.shopkick.appium.ScreenBaseClass;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LeftNavBar extends ScreenBaseClass {

    final private static Logger log = Logger.getLogger((LeftNavBar.class));
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/button_text\").text(\"GUEST\")")
    @iOSFindBy(uiAutomator = ".buttons()[\"guest username circle\"]")
    private static WebElement guestLeftNavBar;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/row_text\")")
    @iOSFindBy(uiAutomator = ".buttons()[\"guest username circle\"]")
    private static WebElement userProfileText;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/top_text\").text(\"Give your kicks a home.\")")
    private static WebElement guestUserProfileHEader;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/button_text\").text(\"SIGN IN WITH FACEBOOK\")")
    @iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[2]/UIATableView[1]/UIATableCell[1]/UIAButton[1]")
    private static WebElement signInWithFacebookLeftNav;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/button_text\").text(\"SIGN IN WITH GOOGLE\")")
    private static WebElement signInWithGoogleLeftNav;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/button_text\").text(\"ENTER MANUALLY\")")
    private static WebElement signInManuallyLeftNav;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/current_kicks_text\").text(\"Current kicks\")")
    private static WebElement currentKicksLeftNav;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/all_time_kicks_text\").text(\"All-time kicks\")")
    private static WebElement allTimeKicksLeftNav;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/row_text\").text(\"My profile\")")
    private static WebElement myProfileLeftNav;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/row_text\").text(\"'s profile\")")
    private static WebElement signedInProfileLeftNav;

	/*
     * modifying left nav
	 * */
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/row_text\").text(\"My saves\")")
    private static WebElement mySavesLeftNav;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/row_text\").text(\"Rewards\")")
    private static WebElement browseRewardsLeftNav;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/row_text\").text(\"Invite & get kicks\")")
    @iOSFindBy(uiAutomator = ".tableViews()[0].cells()[\"Invite & get kicks\"]")
    private static WebElement inviteAndGetKicksLeftNav;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/row_text\").text(\"My friends\")")
    private static WebElement myFriendsLeftNav;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/row_text\").text(\"Questions?\")")
    private static WebElement questionsLeftNav;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/row_text\").text(\"Settings\")")
    @iOSFindBy(uiAutomator = ".tableViews()[0].cells()[\"Settings\"]")
    private static WebElement settingsLeftNav;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/current_kicks_count\")")
    private static WebElement currentKicksCountLeftNav;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/all_time_kicks_count\")")
    private static WebElement allTimeKicksCountLeftNav;

    public static void clickGuestUserButton() {

        guestLeftNavBar.click();
        PageFactory.initElements(new AppiumFieldDecorator(driver), new LeftNavBar());
    }

    public static String getUserProfileText() {
        String profile = "";
        try {
            profile = userProfileText.getText().toString();
        } catch (Exception e) {
            log.error(e);
        }
        return profile;
    }

    public static void clickOnFaceBookSignIn() {
        signInWithFacebookLeftNav.click();
        PageFactory.initElements(new AppiumFieldDecorator(driver), new DidYouKnowPage());
    }

    public static void clickOnGooglePlusSignIn() {
        signInWithGoogleLeftNav.click();
    }

    //Method TO VERIFY USER IS NOT SIGNED IN
    public static boolean verifyNotSignedIn() {

        if ((guestUserProfileHEader.isDisplayed()) &&
                (signInWithFacebookLeftNav.isDisplayed()) &&
                (signInWithGoogleLeftNav.isDisplayed()) &&
                (signInManuallyLeftNav.isDisplayed()))
            return true;
        else
            return false;
    }

    public static void clickOnAllTimeKicks() {
        allTimeKicksLeftNav.click();
        PageFactory.initElements(new AppiumFieldDecorator(driver), new KicksActivityPage());
    }

    public static void clickOnCurrentKicks() {
        currentKicksLeftNav.click();
        PageFactory.initElements(new AppiumFieldDecorator(driver), new KicksActivityPage());
    }

    public static void clickOnRewardsButtonLeftNav() {
        browseRewardsLeftNav.click();
        PageFactory.initElements(new AppiumFieldDecorator(driver), new KicksCenterRewadsPage());
    }

    public static void clickOnInviteLeftNav() {
        inviteAndGetKicksLeftNav.click();
        PageFactory.initElements(new AppiumFieldDecorator(driver), new InviteAndGetKicksPage());
    }

    public static void clickOnSettingsLeftNav() {
        settingsLeftNav.click();
        PageFactory.initElements(new AppiumFieldDecorator(driver), new LeftNavSettings());
    }

    //Method TO read Current Kicks
    public static String getCurrentKicksCount() {
        String currentKicksCount = currentKicksCountLeftNav.getText();
        return currentKicksCount;
    }

    //Method to read All time kicks
    public static String getAllTimeKicksCount() {
        String allTimeKicksCount = allTimeKicksCountLeftNav.getText();
        return allTimeKicksCount;
    }
}
