package com.qa.shopkick.pages;

import com.qa.shopkick.utils.ScreenBaseClass;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class MySavesPage extends ScreenBaseClass {

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/app_screen_header\").text(\"My Saves\")")
    private static WebElement MySavesAppScreenHeader;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/tab_count\")")
    private static WebElement MySavesProductTabCount;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/tab_caption\")")
    //<----REDO THIS ID
    @iOSFindBy(uiAutomator = ".staticTexts()[\"PRODUCTS\"]")
    private static WebElement MySavesProductTabCaption;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/tab_count\")")
    private static WebElement MySavesTabCollectionTabCount;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/tab_caption\")")
    private static WebElement MySavesTabCollectionTabCaption;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/tab_count\")")
    private static WebElement MySavesTabDealTabCount;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/tab_caption\")")
    private static WebElement MySavesTabDealTabCaption;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/list_view\")")
    @iOSFindBy(uiAutomator = ".cells()[0]")
    private static WebElement MySavesOfferTile;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/app_screen_back_button\")")
    @iOSFindBy(uiAutomator = ".buttons()[0]")
    private static WebElement MySavebackButton;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/heart\")")
    private static WebElement MySavesDealHeart;

    public static void clickOnSavesProducts() {
        MySavesProductTabCaption.click();
    }

    public static void clickMySavesCollectionTabCaption() {
        MySavesTabCollectionTabCaption.click();
    }

    public static void clickMySavesANYOfferTile() {
        MySavesOfferTile.click();
        PageFactory.initElements(new AppiumFieldDecorator(driver), new OfferPage());
    }

    public static void clickOnBackButton() {
        MySavebackButton.click();
        PageFactory.initElements(new AppiumFieldDecorator(driver), new LandingPage());
        PageFactory.initElements(new AppiumFieldDecorator(driver), new ProductsPage());
    }

    public static void clickOnMySavesDealHeart() {
        MySavesDealHeart.click();
    }

}
