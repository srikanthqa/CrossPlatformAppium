package com.qa.shopkick.pages;

import com.qa.shopkick.appium.ScreenBaseClass;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.WebElement;

public class RelatedOfferPage extends ScreenBaseClass {

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/button_image\")")
    @iOSFindBy(uiAutomator = ".buttons()[\"icon heart brown\"]")
    private static WebElement RelatedOfferSaveOffer;
    @iOSFindBy(uiAutomator = ".tableViews()[0].cells()[0]")
    private static WebElement firstItemInTrending;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/button_text\").text(\"BUY NOW\")")
    private static WebElement RelatedOfferBuyNow;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/offer_image\")")
    private static WebElement RelatedOfferOfferImage;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/chain_logo\")")
    private static WebElement RelatedOfferChainLogo;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/distance_text\")")
    private static WebElement RelatedOfferDistanceButton;

    public static void clickRelatedOfferSaveOffer() {
        RelatedOfferSaveOffer.click();
    }

    public static void clickOnFirstTrendingItem() {
        firstItemInTrending.click();
    }

    public static void clickRelatedOfferBuyNow() {
        RelatedOfferBuyNow.click();
    }


}
