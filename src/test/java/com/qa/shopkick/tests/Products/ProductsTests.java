package com.qa.shopkick.tests.Products;



import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.qa.shopkick.pages.LandingPage;
import com.qa.shopkick.pages.LookbookPage;
import com.qa.shopkick.pages.ProductsPage;
import com.qa.shopkick.utils.AbstractTest;
import com.qa.shopkick.utils.CustomHooks;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductsTests extends AbstractTest{

	@Test
	public void Test1_SwitchToProductsTab(){

		//From stores tab to products tab
		LandingPage.clicktabTitleProducts();
	}
	@Test
	public void Test2_Savelookbook(){

		//Navigate to Lookbook details
		OpenLookBookTest();

		//Save lookbook
		LookbookPage.clickToSaveLookBook();
	}

	@Test
	public void Test3_SaveOffer(){

		//Save offer
		LookbookPage.clickLookbookPageLookbookOfferSaveHeart();

		CustomHooks.pressBack();
	}

	@Test
	public void Test4_VerifyLookbookState(){

		//Verify checkmark for read lookbooks
		ProductsPage.clickProductsPageCheckmark();
	}

	//Scroll down then back up (to do)

	@Test
	public void Test5_SwitchCategory(){
		//Switch to Women category
		ProductsPage.clickProductsPageWomenTab();
		//Switch back to Trending tab
		ProductsPage.clickProductsPageTrendingTab();

	}

	public void OpenLookBookTest(){
		MobileElement LookBookElementone =  (MobileElement) driver.findElements(MobileBy.AndroidUIAutomator("new UiSelector().resourceId(\"com.shopkick.app:id/browse_feed_recycler_view\").childSelector(new UiSelector().className(\"android.widget.RelativeLayout\").index(1).childSelector(new UiSelector().resourceId(\"com.shopkick.app:id/lookbook_image\")"));
		LookBookElementone.click();

	}

}
