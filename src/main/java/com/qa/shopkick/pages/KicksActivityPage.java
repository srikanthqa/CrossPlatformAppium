package com.qa.shopkick.pages;

import com.qa.shopkick.appium.ScreenBaseClass;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class KicksActivityPage extends ScreenBaseClass {

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/app_screen_header\")")
    private static WebElement ScreenHeader;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/kicks_activity_available_kicks_count\")")
    private static WebElement AvailableKicksCount;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/kicks_activity_available_kicks_label\")")
    private static WebElement AvailableKicksLabel;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/kicks_activity_all_time_kicks_count\")")
    private static WebElement AllTimeKicksCount;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/kicks_activity_all_time_kicks_label\")")
    private static WebElement AllTimeKicksLabel;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/kicks_activity_available_label\")")
    private static WebElement AvailableLabel;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/kicks_activity_all_time_label\")")
    private static WebElement AllTimeLabel;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/ka_pending_header\").text(\"Pending\")")
    private static WebElement PendingHeader;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/ka_past_header\").text(\"Past\")")
    private static WebElement PastHeader;

}
