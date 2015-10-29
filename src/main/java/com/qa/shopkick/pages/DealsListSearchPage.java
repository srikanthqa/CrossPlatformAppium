package com.qa.shopkick.pages;

import com.qa.shopkick.utils.ScreenBaseClass;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class DealsListSearchPage extends ScreenBaseClass {

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/deals_inside\").text(\"Deals available\")")
    private static WebElement dealsAvailableButton;

    public static void clickOnDealsAvailable() {
        dealsAvailableButton.click();
        PageFactory.initElements(new AppiumFieldDecorator(driver), new DealAggregationPage());

    }

}
