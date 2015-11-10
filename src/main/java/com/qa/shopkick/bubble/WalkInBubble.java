package com.qa.shopkick.bubble;

import com.qa.shopkick.pages.TopNavBar;
import com.qa.shopkick.utils.CustomHooks;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

/**
 * Created by mmadhusoodan on 11/4/15.
 */
public class WalkInBubble extends BaseBubble {

    final private static Logger log = Logger.getLogger((WalkInBubble.class));

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/ball_image_outer\")")
    private static WebElement walkInBubble = null;

    public static boolean handleWalkBubble() {
        boolean flag = false;
        try {
            if (walkInBubble.isDisplayed()) {
                log.info("Transmitter some where! going to press back");
                CustomHooks.waitFor(3);
                pressBack();
                pressBack();
                if (TopNavBar.isNavHeaderDisplayed() && TopNavBar.isHeartIconDisplayed() && TopNavBar.isHeartIconDisplayed()) {
                    log.info("Nav Bar intact along with Kick Counter and Heart");
                    flag = true;
                } else {
                    flag = false;
                }
            }
        } catch (NoSuchElementException e) {
            log.info("NO Transmiter found");
            flag = false;
        } catch (Exception e) {
            log.error(e);
            flag = false;
        }
        return flag;
    }
}
