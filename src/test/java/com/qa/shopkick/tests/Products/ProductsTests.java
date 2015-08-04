package com.qa.shopkick.tests.Products;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;

import com.qa.shopkick.pages.KicksCenterRewadsPage;
import com.qa.shopkick.pages.LandingPage;
import com.qa.shopkick.pages.LookbookPage;
import com.qa.shopkick.pages.ProductsPage;
import com.qa.shopkick.pages.StoresPage;
import com.qa.shopkick.tests.Authentication.LoginHooks;
import com.qa.shopkick.utils.AbstractTest;
import com.qa.shopkick.utils.CustomHooks;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductsTests {

	@Test
	public void SwitchToProductsTab(){
		
		//From stores tab to products tab
		LandingPage.clicktabTitleProducts();
		
		//Navigate to Lookbook details
		ProductsPage.clickProductsPageLookbookImage();
		
		//Save lookbook
		LookbookPage.clickToSaveLookBook();
		
		//Save offer
		LookbookPage.clickLookbookPageLookbookOfferSaveHeart();
		
		CustomHooks.pressBack();
		
		//Verify checkmark
		ProductsPage.clickProductsPageCheckmark();
		
		//Scroll down then back up (to do)
		
		//Switch to Women category
	    ProductsPage.clickProductsPageWomenTab();
	    
	    //Switch back to Trending tab
	    ProductsPage.clickProductsPageTrendingTab();
		
	    //Tap My Saves
	    ProductsPage.clickProductsPageMySaves();
	}
	
}
