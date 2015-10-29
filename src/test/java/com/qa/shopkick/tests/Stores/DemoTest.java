package com.qa.shopkick.tests.Stores;

import com.qa.shopkick.pages.StoreViewPage;
import com.qa.shopkick.pages.StoresPage;
import com.qa.shopkick.appium.AbstractTestCase;
import com.qa.shopkick.utils.CustomHooks;

public class DemoTest extends AbstractTestCase {

    public void StoresTest1() {

        // Click on the StoresPageStoreSearch /search Target
        String searchItem = "Target";
        StoresPage.clickStoresPageStoreSearch();
        StoresPage.StoresPageSearchBox.click();
        StoresPage.StoresPageSearchBox.sendKeys(searchItem);

        String chainName = StoresPage.StoresPageChainName.getText();
        StoresPage.StoresPageChainName.click();

        String text = "Trending on shopkick";
        driver.scrollTo(text);

        StoreViewPage.StoreViewPageGroupHeader.click();

        if (StoreViewPage.productList.size() > 0) {
            StoreViewPage.productList.get(0).click();
        }

        // click Save Button

        if (StoreViewPage.buttonTextList.size() > 0) {
            StoreViewPage.buttonTextList.get(1).click();
        }

        CustomHooks.pressBack();

        if (StoreViewPage.productList.size() > 0) {
            StoreViewPage.productList.get(0).isDisplayed();

        }
        StoreViewPage.heartIcon.click(); // unsaved
        // store_search_text_field
        StoreViewPage.buttonTextList.get(1).click();
        String newText = StoreViewPage.buttonTextList.get(1).getText().toString();

        if (newText.equalsIgnoreCase("SAVE")) {
            System.out.println("Success");
        } else {
            System.out.println("Failure");
            System.exit(1);

        }

    }

}
