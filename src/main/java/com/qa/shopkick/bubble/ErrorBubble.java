package com.qa.shopkick.bubble;

import com.qa.shopkick.appium.ScreenBaseClass;
import com.qa.shopkick.pages.LandingPage;
import com.qa.shopkick.pages.LeftNavBar;
import com.qa.shopkick.utils.CustomHooks;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ErrorBubble extends ScreenBaseClass {

    final private static Logger log = Logger.getLogger(String.valueOf(ErrorBubble.class));

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/main_overlay_view\")")
    private static WebElement didYouKnowText;

    //android:id/message


    public static void tapOnDidYouKnow() {
        try {
            if (didYouKnowText.isDisplayed()) {
                log.info("duplicateDeviceOverLay Displayed, Going to Tap it  ");
                CustomHooks.waitFor(3);
                didYouKnowText.click();
            }
        } catch (NoSuchElementException e) {
            log.info("duplicateDeviceOverLay NOT found, luck you");
        } catch (Exception e) {
            log.error(e);
        } finally {
            PageFactory.initElements(new AppiumFieldDecorator(driver), new LandingPage());
            PageFactory.initElements(new AppiumFieldDecorator(driver), new LeftNavBar());
        }


    }
}
