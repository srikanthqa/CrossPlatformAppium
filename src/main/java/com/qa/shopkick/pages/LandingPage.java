package com.qa.shopkick.pages;

import com.qa.shopkick.utils.ScreenBaseClass;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends ScreenBaseClass {

    final private static Logger log = Logger.getLogger(String.valueOf(LandingPage.class));

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/kicks_amount\")")
    @iOSFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/kicks_amount\")")
    private static WebElement topCenterKicks;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/left_nav_user_image\")")
    @iOSFindBy(uiAutomator = ".tableViews()[0].cells()[0].buttons()[0]")        //<- double check this guy
    private static WebElement leftNavUserImage;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/tab_title\").text(\"PRODUCTS\")")
    @iOSFindBy(uiAutomator = ".tabBar().buttons()[\"Products\"]")
    private static WebElement tabTitleProducts;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/tab_title\").text(\"STORES\")")
    @iOSFindBy(uiAutomator = ".tabBar().buttons()[\"Stores\")")
    private static WebElement tabTitleStores;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/tab_title\").text(\"DEALS\")")
    @iOSFindBy(uiAutomator = ".tabBar().buttons()[\"Deals\"]")
    private static WebElement tabTitleDeals;

    public static String getKicksOnLandingPage() {

        String kicks = "";
        try {
            kicks = topCenterKicks.getText().toString();
        } catch (Exception e) {
            log.error(e);
        }
        return kicks;
    }

    public static void openLeftNavSignedIn() {
        try {
            leftNavUserImage.click();
            waitFor(3);
            PageFactory.initElements(new AppiumFieldDecorator(driver), new LeftNavBar());
        } catch (Exception e) {
            log.error(e);
        }
    }

    public static void clicktabTitleProducts() {
        tabTitleProducts.click();
        PageFactory.initElements(new AppiumFieldDecorator(driver), new ProductsPage());
    }

    public static void clicktabTitleStores() {
        tabTitleStores.click();
        PageFactory.initElements(new AppiumFieldDecorator(driver), new StoresPage());
    }

    public static void clicktabTitleDeals() {
        tabTitleDeals.click();
        PageFactory.initElements(new AppiumFieldDecorator(driver), new DealsPage());
    }
}
