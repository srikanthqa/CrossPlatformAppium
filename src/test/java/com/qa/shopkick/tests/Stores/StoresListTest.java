package com.qa.shopkick.tests.Stores;

import com.qa.shopkick.pages.LandingPage;
import com.qa.shopkick.pages.StoresPage;
import com.qa.shopkick.appium.AbstractTestCase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class StoresListTest extends AbstractTestCase {

    public static String distanceInitial, distanceAfterLocationChange;
    public static String storeNameInital, storeNameAfterLocationChange;

    //Verify username is on the stores page
    //Check for the stores tab and look for its child if its highlighted
    @Test
    public void Test1_storestab() {
        LandingPage.clicktabTitleStores();
        assert (StoresPage.tabHighlight.isDisplayed());
        assert (StoresPage.promoUnitStoresTab.isDisplayed());

    }

    //Verify store list is shown
    @Test
    public void Test2_storesList() {
        //check that list items with com.shopkick.app:id/name_and_kick_information are displayed on more than one instance
        assert (StoresPage.recyclerViewStoresList.size() > 0);
    }

    //Verify Store image, Name, DIstance and Kicks break down are shown
    @Test
    public void Test3_storeListCard() {
        //check for all stores, check if first tile has store name
        WebElement firstStore = StoresPage.recyclerViewStoresList.get(0);
        WebElement StoreName = firstStore.findElement(By.id("com.com.shopkick.app:id/chain_name"));
        storeNameInital = StoreName.getText().toString();
        assert (storeNameInital != null);

        //Check for all distances, make sure distance is displayed
        WebElement firstStoreDistance = StoresPage.storesDistances.get(0);
        distanceInitial = firstStoreDistance.getText().toString();
        assert (distanceInitial != null);
        assert (distanceInitial != "? mi");

    }
}
