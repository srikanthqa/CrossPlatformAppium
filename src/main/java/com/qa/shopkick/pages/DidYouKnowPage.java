package com.qa.shopkick.pages;

import com.qa.shopkick.utils.ScreenBaseClass;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class DidYouKnowPage extends ScreenBaseClass {

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/main_overlay_view\")")
    @iOSFindBy(uiAutomator = "")
    private static WebElement didYouKnowText;

    public static void tapOnDidYouKnow() {
        didYouKnowText.click();
        PageFactory.initElements(new AppiumFieldDecorator(driver), new LandingPage());
        PageFactory.initElements(new AppiumFieldDecorator(driver), new LeftNavBar());
    }
}
