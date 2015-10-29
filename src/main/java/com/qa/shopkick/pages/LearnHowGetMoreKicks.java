package com.qa.shopkick.pages;

import com.qa.shopkick.utils.ScreenBaseClass;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LearnHowGetMoreKicks extends ScreenBaseClass {

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/app_screen_header\").text(\"Get more kicks\")")
    private static WebElement getMoreKicksHeader;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/app_screen_header\").text(\"Use kicks to get gift cards in shopkick.\")")
    private static WebElement getMoreKicksTutorial;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/tutorial_button_walkin\")")
    private static WebElement walkinTutorialButton;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/tutorial_button_scan\")")
    private static WebElement scanTutorialButton;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/tutorial_button_purchases\")")
    private static WebElement purchasesTutorialButton;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/tutorial_button_invite\")")
    private static WebElement inviteTutorialButton;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/app_screen_back_button\")")
    private static WebElement onScreenBackBoutton;

    public static void clickOnWalkinTutorial() {
        if (walkinTutorialButton.isDisplayed()) {
            walkinTutorialButton.click();
            PageFactory.initElements(new AppiumFieldDecorator(driver), new WalkInTutorialPage());
        }
    }

    public static void clickOnScanTutorial() {
        if (scanTutorialButton.isDisplayed()) {
            scanTutorialButton.click();
            PageFactory.initElements(new AppiumFieldDecorator(driver), new ScanTutorialPage());
        }
    }

    public static void clickOnPurchaseTutorial() {
        if (purchasesTutorialButton.isDisplayed()) {
            purchasesTutorialButton.click();
            PageFactory.initElements(new AppiumFieldDecorator(driver), new PurchaseKicksPage());
        }
    }

    public static void clickOnInviteTutorial() {
        if (inviteTutorialButton.isDisplayed()) {
            inviteTutorialButton.click();
            PageFactory.initElements(new AppiumFieldDecorator(driver), new InviteAndGetKicksPage());
        }
    }

    public static void clickOnBackButton() {
        onScreenBackBoutton.click();
        PageFactory.initElements(new AppiumFieldDecorator(driver), new KicksCenterRewadsPage());
    }
}
