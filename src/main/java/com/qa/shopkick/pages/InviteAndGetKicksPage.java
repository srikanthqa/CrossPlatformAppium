package com.qa.shopkick.pages;

import com.qa.shopkick.appium.ScreenBaseClass;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class InviteAndGetKicksPage extends ScreenBaseClass {

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/app_screen_header\").text(\"Invite & get kicks\")")
    private static WebElement invitePageHeader;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/invite_fb_button\").class(\"android.widget.RelativeLayout\")")
    private static WebElement faceBookInviteButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/search_box\").class(\"android.widget.EditText\")")
    private static WebElement searchContacts;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/button_text\").text(\"INVITE FRIENDS\")")
    @iOSFindBy(uiAutomator = ".staticTexts()[\"Invite friends\"]")
    private static WebElement inviteFriendsButton;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/app_screen_back_button\")")
    private static WebElement onScreenBackBoutton;

    public static void clickOninviteFrendsButton() {
        inviteFriendsButton.click();
        /* TODO: Should go to contact picker page from here
		 * PageFactory.initElements(new AppiumFieldDecorator(driver),new FirstUseWalkinEducationPage());
		 * */
        PageFactory.initElements(new AppiumFieldDecorator(driver), new FacebookInvitePage());
    }

    public static void clickOnBackButton() {
        onScreenBackBoutton.click();
        PageFactory.initElements(new AppiumFieldDecorator(driver), new LandingPage());
    }

}
