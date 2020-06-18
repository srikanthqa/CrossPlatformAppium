package com.qa.shopkick.pages;

import com.qa.shopkick.appium.ScreenBaseClass;
import io.appium.java_client.pagefactory.AndroidFindBy;
import junit.framework.Assert;
import org.openqa.selenium.WebElement;

@SuppressWarnings("deprecation")
public class PurchaseKicksPage extends ScreenBaseClass {

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/app_screen_header\").text(\"Kicks for Purchases\")")
    private static WebElement purchaseTutorialHeader;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/tutorial_details_header_text\").text(\"Earn Kicks every time you buy\")")
    private static WebElement purchaseTutorialDetails;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/tutorial_details_step_1_text\").text(\"Link your credit or debit card\")")
    private static WebElement purchaseTutorialStep1;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Shop with your linked card\")")
    private static WebElement purchaseTutorialStep2;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Sit back and watch the Kicks flow\")")
    private static WebElement purchaseTutorialStep3;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/button_text\").text(\"LINK CARD\")")
    private static WebElement linkcardButton;

    public static void verifyLinkCardElements() {
        Assert.assertTrue(purchaseTutorialDetails.isDisplayed());
        Assert.assertTrue(purchaseTutorialStep1.isDisplayed());
        Assert.assertTrue(purchaseTutorialStep2.isDisplayed());
        Assert.assertTrue(purchaseTutorialStep3.isDisplayed());
        Assert.assertTrue(linkcardButton.isDisplayed());
    }
}
