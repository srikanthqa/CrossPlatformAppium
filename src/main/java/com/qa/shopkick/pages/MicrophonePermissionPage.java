package com.qa.shopkick.pages;

import com.qa.shopkick.utils.AbstractPage;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.WebElement;

/**
 * Created by Srikanth on 12/16/14.
 */
public class MicrophonePermissionPage extends AbstractPage{

    @iOSFindBy(uiAutomator = ".buttons()[\"OK\"]")
    private static WebElement okButton;

    public static void clickOKButton(){
        okButton.click();
    }
}
