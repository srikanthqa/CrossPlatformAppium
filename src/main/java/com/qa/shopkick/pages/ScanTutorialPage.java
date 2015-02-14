package com.qa.shopkick.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;

import org.openqa.selenium.WebElement;

import com.qa.shopkick.utils.AbstractPage;

public class ScanTutorialPage extends AbstractPage{

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/app_screen_header\").text(\"How to scan\")")
	private static WebElement scanTutorialHeader;

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/tutorial_details_header_text\").text(\"Get kicks for scanning products at the store.\")")
	private static WebElement scanTutorialDetails;

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/tutorial_details_step_1_text\").text(\"In shopkick, find stores and products with scan kicks. Look for the barcode icon.\")")
	private static WebElement scanTutorialStep1;

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/tutorial_details_step_2_text\").text(\"At the store, tap on scan products in shopkick to use the barcode scanner.\")")
	private static WebElement scanTutorialStep2;

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/tutorial_details_step_3_text\").text(\"Scan barcodes and get kicks.\")")
	private static WebElement scanTutorialStep3;

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/tutorial_details_link\").text(\"SEE STORES WITH SCANS\")")
	private static WebElement seeStoresWithScans;

}
