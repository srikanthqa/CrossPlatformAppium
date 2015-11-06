package com.qa.shopkick.pages;

import com.qa.shopkick.appium.ScreenBaseClass;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class VerifyMobileNumber extends ScreenBaseClass {

/*	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/verify_title_text\").text(\"Verify your mobile number to redeem rewards!\")")
    private static WebElement linkPhoneTitleText;*/

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/verify_edit_phone_button\")")
    private static WebElement verifyPhoneNoText;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/verify_not_now_button\").text(\"Not right now\")")
    @iOSFindBy(uiAutomator = ".buttons()[6]")
    private static WebElement verifyPhoneNotRightNow;

    public static void clickNotNowForVerifyPhone() {
        verifyPhoneNotRightNow.click();
        PageFactory.initElements(new AppiumFieldDecorator(driver), new LandingPage());
        PageFactory.initElements(new AppiumFieldDecorator(driver), new LeftNavSettings());
    }

    public static String getPhoneNumber() {
        try {
            while (!verifyPhoneNoText.isDisplayed()) {
                waitFor(3);
            }
            String ph = verifyPhoneNoText.getText().trim().toString();
            PageFactory.initElements(new AppiumFieldDecorator(driver), new LandingPage());
            PageFactory.initElements(new AppiumFieldDecorator(driver), new LeftNavSettings());
            ph = ph.replace("-", "");
            return ph;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}

