package com.qa.shopkick.pages;

import com.qa.shopkick.utils.ScreenBaseClass;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class AllRewardsPage extends ScreenBaseClass {

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/app_screen_header\").text(\"Get more kicks\")")
    private static WebElement getMoreKicksHeader;

}
