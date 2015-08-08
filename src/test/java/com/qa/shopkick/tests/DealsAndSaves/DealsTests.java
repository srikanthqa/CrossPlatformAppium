package com.qa.shopkick.tests.DealsAndSaves;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.qa.shopkick.pages.DealAggregationPage;
import com.qa.shopkick.pages.DealsPage;
import com.qa.shopkick.pages.MySavesPage;
import com.qa.shopkick.pages.ProductsPage;
import com.qa.shopkick.utils.AbstractTest;
import com.qa.shopkick.utils.CustomHooks;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DealsTests extends AbstractTest{
	
	@Test
	public void Test1_ViewAggregatedDeals(){
		//Click on Target
		driver.scrollTo("Target");
		DealsPage.clickDealsPageTarget();
	}

	@Test
	public void Test2_SaveDealFromAggregatedDeal(){
		//Save Deal
		DealAggregationPage.clickDealAggregationSaveHeart();
	}
	
	@Test
	public void Test3_ViewSavedDealUnSaveDeal(){
		CustomHooks.pressBack();
		ProductsPage.clickProductsPageMySaves();
		MySavesPage.clickOnMySavesDealHeart();
	}
	
	@Test
	public void Test4_ScrollDeals(){
		//scrolling down then back up
		CustomHooks.pressBack();
		driver.scrollTo("Michaels");
		driver.scrollTo("Target");
	}
	
	@Test
	public void Tesst5_SearchDeals(){
		//searching Old Navy in Deals
		DealsPage.clickOnSearchBar();
		//driver.sendKeys("Old Navy");
		DealsPage.searchInStoresSearchBar("Old Navy");
		
	}
}
