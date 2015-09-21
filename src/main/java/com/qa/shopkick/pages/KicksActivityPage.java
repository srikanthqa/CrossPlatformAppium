package com.qa.shopkick.pages;

import com.qa.shopkick.utils.AbstractPage;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class KicksActivityPage extends AbstractPage {
	
	@AndroidFindBy(UiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/app_screen_header\")")
	private static WebElement ScreenHeader;
	
	@AndroidFindBy(UiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/kicks_activity_available_kicks_count\")")
	private static WebElement AvailableKicksCount;
	
	@AndroidFindBy(UiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/kicks_activity_available_kicks_label\")")
	private static WebElement AvailableKicksLabel;
	
	@AndroidFindBy(UiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/kicks_activity_all_time_kicks_count\")")
	private static WebElement AllTimeKicksCount;

	@AndroidFindBy(UiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/kicks_activity_all_time_kicks_label\")")
	private static WebElement AllTimeKicksLabel;
	
	@AndroidFindBy(UiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/kicks_activity_available_label\")")
	private static WebElement AvailableLabel;
	
	@AndroidFindBy(UiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/kicks_activity_all_time_label\")")
	private static WebElement AllTimeLabel;
	
	@AndroidFindBy(UiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/ka_pending_header\").text(\"Pending\")")
	private static WebElement PendingHeader;
	
	@AndroidFindBy(UiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/ka_pending_header\").text(\"Past\")")
	private static WebElement PastHeader;
	
}
