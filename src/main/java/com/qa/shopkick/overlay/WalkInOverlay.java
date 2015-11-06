package com.qa.shopkick.overlay;

import com.qa.shopkick.utils.CustomHooks;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

/**
 * Created by mmadhusoodan on 11/4/15.
 */
public class WalkInOverlay extends BaseOverlays {

    final private static Logger log = Logger.getLogger((WalkInOverlay.class));

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/ball_image_outer\")")
    private static WebElement walkInBubble;

    public static boolean handleWalkBubble() {
        try {
            if (walkInBubble.isDisplayed()) {
                log.info("Transmitter some where! going to press back");
                CustomHooks.waitFor(3);
                pressBack();
                pressBack();
            }
            return true;
        } catch (NoSuchElementException e) {
            log.info("Good No Transmiter found");
            return false;
        } catch (Exception e) {
            log.error(e);
            return false;
        }
    }
}
