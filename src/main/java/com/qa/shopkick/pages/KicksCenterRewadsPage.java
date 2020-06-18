package com.qa.shopkick.pages;

import com.qa.shopkick.appium.ScreenBaseClass;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class KicksCenterRewadsPage extends ScreenBaseClass {

    //Declaring all static texts in page first, parts we wont click

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/kicks_center_title\").text(\"Kicks Center\")")
    private static WebElement kickCenterHeader;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/kicks_center_unit\").text(\"KICKS\")")
    private static WebElement kickCenterUserKicks;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/kc_widget_change_reward_text\").text(\"CHANGE REWARD\")")
    @iOSFindBy(uiAutomator = ".buttons()[\"Change Reward\"]")
    private static WebElement kickCenterChangeReward;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/kicks_center_kicks_activity_text\").text(\"Kicks Activity\")")
    private static WebElement kicksActivityScreen;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/kicks_center_tutorial_or_pending\").text(\"GET MORE KICKS. LEARN HOW.\")")
    @iOSFindBy(uiAutomator = ".buttons()[\"Get More kicks. Learn How.\"]")
    private static WebElement getMoreKicksLearnHow;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/kicks_center_all_rewards_full_width_text\").text(\"SEE ALL REWARDS\")")
    private static WebElement seeAllRewardsFullWidth;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/kicks_center_all_rewards_half_width_text\")")
    @iOSFindBy(uiAutomator = ".buttons()[\"See All Rewards\"]")
    private static WebElement seeAllRewardsHalfWidth;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/kicks_center_screen_back\")")
    private static WebElement closeKickCenter;
    //FOR 4.5.7 and above
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/button_text\").text(\"CLOSE\")")
    private static WebElement kickCenterCloseButton;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/kicks_center_my_rewards_text\").text(\"MY REWARDS\")")
    private static WebElement kickCenterMyRewards;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/kicks_counter\")")
    private static WebElement ProductsPageKicksCounter;

    public static void clickOnKicksActivity() {
        kicksActivityScreen.click();
        PageFactory.initElements(new AppiumFieldDecorator(driver), new KicksActivityPage());
    }

    public static void clickOnChangeReward() {
        kickCenterChangeReward.click();
        PageFactory.initElements(new AppiumFieldDecorator(driver), new RewardsPickerPage());
    }

    public static void clickOnLearnHowToGetKicks() {
        getMoreKicksLearnHow.click();
        PageFactory.initElements(new AppiumFieldDecorator(driver), new LearnHowGetMoreKicks());
    }

    public static void clickOnseeAllRewardsFullWidth() {
        seeAllRewardsFullWidth.click();
        PageFactory.initElements(new AppiumFieldDecorator(driver), new RewardsMallPage());
    }

    public static void clickOnseeAllRewardsHalfWidth() {
        seeAllRewardsHalfWidth.click();
        PageFactory.initElements(new AppiumFieldDecorator(driver), new RewardsMallPage());
    }


}
