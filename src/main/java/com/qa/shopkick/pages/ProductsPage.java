package com.qa.shopkick.pages;

import com.qa.shopkick.appium.ScreenBaseClass;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import junit.framework.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

@SuppressWarnings("deprecation")
public class ProductsPage extends ScreenBaseClass {

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/kicks_counter\")")
    private static WebElement ProductsPageKicksCounter;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/tab_title\").text(\"PRODUCTS\")")
    private static WebElement ProductsPageTabTitle;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/tab_highlight\")")
    private static WebElement ProductsPageTabHighlight;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/heart\")")
    @iOSFindBy(uiAutomator = ".buttons()[\"heart icon filled white\"]")
    private static WebElement ProductsPageMySaves;
    //Method and def are obsolete
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/subtab_name\")")
    private static WebElement ProductsPageSubTabName;
    //Obsolete for products tab
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/title_text\").text(\"Unlock up to 5000 kicks toward your first FREE reward!\")")
    private static WebElement ProductsPageNewUserScanBonus;
    // Obsolete
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/lookbook_title\")")
    @iOSFindBy(uiAutomator = ".tableViews()[0].cells()[0].buttons()[0]")
    private static WebElement ProductsPageLookbookCover;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/tile_flag\").text(\"JUST IN\")")
    private static WebElement ProductsPageUnreadLabel;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/fave_heart\")")
    private static WebElement ProductsPageLookbookSaveHeart;
    //Obsoloete
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/lookbook_title\")")
    private static WebElement ProductsPageLookbookTitle;
    //Regular lookbook
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/lookbook_image\")")
    private static WebElement ProductsPageLookbookImage;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/checkmark\")")
    private static WebElement ProductsPageCheckmark;
    //Branded lookbook
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/branded_lookbook_image\")")
    private static WebElement ProductsPageBrandedLookbookImage;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/subtab_name\").text(\"WOMEN\")")
    private static WebElement ProductsPageWomenTab;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/subtab_name\").text(\"TRENDING\")")
    private static WebElement ProductsPageTrendingTab;

    public static void clickProductsPageMySaves() {
        ProductsPageMySaves.click();
        PageFactory.initElements(new AppiumFieldDecorator(driver), new MySavesPage());
    }

    public static void clickProductsPageSubTabName() {
        ProductsPageSubTabName.click();
    }

    public static void clickProductsPageLookbookCover() {
        ProductsPageLookbookCover.click();
        PageFactory.initElements(new AppiumFieldDecorator(driver), new LookbookPage());
    }

    public static void clickProductsPageLookbookSaveHeart() {
        ProductsPageLookbookSaveHeart.click();
    }

    public static void clickProductsPageLookbookImage() {
        ProductsPageLookbookImage.click();
    }

    public static void verifyCheckMarkForLookBooks() {
        Assert.assertTrue(ProductsPageCheckmark.isDisplayed());
    }

    public static void clickProductsPageBrandedLookbookImage() {
        ProductsPageBrandedLookbookImage.click();
    }

    public static void clickProductsPageWomenTab() {
        ProductsPageWomenTab.click();
    }

    public static void clickProductsPageTrendingTab() {
        ProductsPageTrendingTab.click();
    }

}

