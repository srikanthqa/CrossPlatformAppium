package com.qa.shopkick.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import com.qa.shopkick.utils.AbstractPage;
import com.qa.shopkick.utils.CustomHooks;

public class RedeemGiftCardDialogPage extends AbstractPage{
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/kc_toast_header_text\").text(\"Congrats!\")")
	private static WebElement congratsRedeemReward;
	
	public static void clickToDismiss(){
		congratsRedeemReward.click();
		CustomHooks.pressBack();
		PageFactory.initElements(new AppiumFieldDecorator(driver), new KicksCenterRewadsPage());
	}

}
