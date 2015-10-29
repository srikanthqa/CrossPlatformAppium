package com.qa.shopkick.pages;

import com.qa.shopkick.appium.ScreenBaseClass;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Srikanth on 12/16/14.
 */
public class FirstUseWalkinEducationPage extends ScreenBaseClass {

    public FirstUseWalkinEducationPage() {

    }


    @iOSFindBy(uiAutomator = ".buttons()[\"Learn how\"]")
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/button_text\").text(\"LEARN HOW\")")
    private static MobileElement learnHowButton;

    @iOSFindBy(uiAutomator = ".buttons()[\"Next\"]")
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/button_text\").text(\"NEXT\")")
    private static WebElement nextButton;

    @iOSFindBy(uiAutomator = ".staticTexts()[\"Get points just for walking into stores.\"]")
    private static MobileElement getPointsText;


    public static boolean isGetPointsScreen() {
        if (nextButton.isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }

    public static void clickNextButton() {
        try {
            nextButton.click();
            PageFactory.initElements(new AppiumFieldDecorator(driver), new FirstUseRewardsEducationPage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void clickLearnHowButton() {
        learnHowButton.click();
    }

}
