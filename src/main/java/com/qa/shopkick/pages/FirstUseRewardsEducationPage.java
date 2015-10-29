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
public class FirstUseRewardsEducationPage extends ScreenBaseClass {

    @iOSFindBy(uiAutomator = ".buttons()[\"Pick a Reward\"]")
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/button_text\").text(\"PICK A REWARD\")")
    private static WebElement pickAReward;

    public static void clickPickARewardButton() {
        pickAReward.click();
        PageFactory.initElements(new AppiumFieldDecorator(driver), new RewardsPickerPage());
    }


}
