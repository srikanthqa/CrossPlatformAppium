package com.qa.shopkick.pages;

import com.qa.shopkick.appium.ScreenBaseClass;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class FacebookInvitePage extends ScreenBaseClass {

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/app_screen_back_button\")")
    private static WebElement onScreenBackBoutton;

    public static void clickOnBackButton() {
        onScreenBackBoutton.click();
        PageFactory.initElements(new AppiumFieldDecorator(driver), new InviteAndGetKicksPage());
    }

}
