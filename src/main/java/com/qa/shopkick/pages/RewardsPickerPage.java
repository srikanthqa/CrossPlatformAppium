package com.qa.shopkick.pages;

import com.qa.shopkick.appium.ScreenBaseClass;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Srikanth on 12/16/14.
 */
public class RewardsPickerPage extends ScreenBaseClass {

    @iOSFindBy(uiAutomator = ".buttons()[\"Select Reward\"]")
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/button_text\").text(\"SELECT REWARD\")")
    private static WebElement selectReward;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/kick_amount\").text(\"3400\")")
    private static WebElement RewardsPickerPageGasReward;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/kick_amount\").text(\"1875000\")")
    @iOSFindBy(uiAutomator = ".cells().firstWithName(\"1875000\")")
    private static WebElement RewardsPickerPageVespaReward;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/app_screen_back_button\")")
    @iOSFindBy(uiAutomator = ".buttons()[0]")
    private static WebElement changeRewardBack;

    public static void clickSelectRewardButton() {
        try {
            selectReward.click();
            PageFactory.initElements(new AppiumFieldDecorator(driver), new FirstUseRegistrationIntroPage());
            PageFactory.initElements(new AppiumFieldDecorator(driver), new FirstUseAlternateScreen());
            PageFactory.initElements(new AppiumFieldDecorator(driver), new SignInPage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void clickGasReward() {
        RewardsPickerPageGasReward.click();
    }

    public static void clickVespaReward() {
        RewardsPickerPageVespaReward.click();
    }

    public static void clickOnBackButton() {
        changeRewardBack.click();
        PageFactory.initElements(new AppiumFieldDecorator(driver), new KicksCenterRewadsPage());
    }

}
