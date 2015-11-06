package com.qa.shopkick.overlay;

import com.qa.shopkick.appium.AbstractTestCase;
import io.appium.java_client.AppiumDriver;
import org.apache.log4j.Logger;

/**
 * Created by mmadhusoodan on 11/4/15.
 */
public class BaseOverlays {

    final private static Logger log = Logger.getLogger((BaseOverlays.class));
    public static AppiumDriver driver = AbstractTestCase.driver;

    public static void pressBack() {
        log.info("pressBack");
        driver.navigate().back();
    }

}
