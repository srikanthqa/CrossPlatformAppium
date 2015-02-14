package com.qa.shopkick.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;

import org.openqa.selenium.WebElement;

import com.qa.shopkick.utils.AbstractPage;

public class InviteAndGetKicksPage extends AbstractPage{

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/app_screen_header\").text(\"Invite & get kicks\")")
	private static WebElement invitePageHeader;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/invite_fb_button\").class(\"android.widget.RelativeLayout\")")
	private static WebElement faceBookInviteButton;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/search_box\").class(\"android.widget.EditText\")")
	private static WebElement searchContacts;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/button_text\").text(\"INVITE FRIENDS\")")
	private static WebElement inviteFriendsButton;
	
}
