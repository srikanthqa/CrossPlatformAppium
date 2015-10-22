package com.qa.shopkick.pages;

import com.qa.shopkick.utils.AbstractPage;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ToolTipsPage extends AbstractPage {
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/tooltip_close_button\")")
	@iOSFindBy(uiAutomator = ".buttons()[\"x icon white\"]")
	private static WebElement ToolTipCloseButton;
	
	public static void clickToolTipCloseButton(){
		ToolTipCloseButton.click();
		PageFactory.initElements(new AppiumFieldDecorator(driver),new StoreViewPage());
	}
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/tooltip_main_text\").text(\"There are three ways you can earn kicks at stores:\")")
	private static WebElement ToolTipsPageToolTipMainText;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/walkin_tooltip\")")
	private static WebElement ToolTipsWalkInToolTip;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/scan_tooltip\")")
	private static WebElement ToolTipsScanToolTip;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/bnc_tooltip\")")
	private static WebElement ToolTipsPurchasesToolTip;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/tooltip_see_more_text\")text(\"SEE WHAT'S AVAILABLE HERE\")")
	private static WebElement ToolTipsSeeWhatsAvailableHere;

}
