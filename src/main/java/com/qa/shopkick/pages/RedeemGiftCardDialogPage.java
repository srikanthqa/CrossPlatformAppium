package com.qa.shopkick.pages;

import com.qa.shopkick.appium.ScreenBaseClass;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class RedeemGiftCardDialogPage extends ScreenBaseClass {

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/kc_toast_header_text\").text(\"Congrats!\")")
    private static WebElement congratsRedeemReward;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/kicks_center_tutorial_or_pending\").text(\"Congrats!\")")
    private static WebElement outsideTapArea;

    public static void clickToDismiss() {
        if (congratsRedeemReward.isDisplayed()) {
            outsideTapArea.click();
            //CustomHooks.pressBack();
        }
        PageFactory.initElements(new AppiumFieldDecorator(driver), new KicksCenterRewadsPage());
    }

}
