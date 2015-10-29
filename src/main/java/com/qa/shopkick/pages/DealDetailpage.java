package com.qa.shopkick.pages;

import com.qa.shopkick.utils.ScreenBaseClass;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.WebElement;

public class DealDetailpage extends ScreenBaseClass {

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/save_button\")")
    @iOSFindBy(uiAutomator = ".elements()[6]")
    private static WebElement saveOfferButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/save_button\")")
    @iOSFindBy(uiAutomator = ".elements()[6]")
    private static WebElement unSaveOfferButton;

    public static void clickOnSaveDeal() {
        saveOfferButton.click();
    }
}
