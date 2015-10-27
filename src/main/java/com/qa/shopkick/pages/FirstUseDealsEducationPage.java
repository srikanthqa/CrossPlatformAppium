package com.qa.shopkick.pages;

import com.qa.shopkick.utils.CustomHooks;
import com.qa.shopkick.utils.ScreenBaseClass;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class FirstUseDealsEducationPage extends ScreenBaseClass {

    final private static Logger log = Logger.getLogger(String.valueOf(FirstUseDealsEducationPage.class));

    @iOSFindBy(uiAutomator = ".buttons()[\"Get Started\"]")
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/button_text\").text(\"GET STARTED\")")
    private static WebElement getStartedFirstUse;

    public FirstUseDealsEducationPage() {

        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public static void clickGetStartedButton() {

        try {
            getStartedFirstUse.click();
            log.info("click() getStartedFirstUse");
            CustomHooks.waitFor(2);
            PageFactory.initElements(new AppiumFieldDecorator(driver), new CountryPickerPage());
            PageFactory.initElements(new AppiumFieldDecorator(driver), new FirstUseWalkinEducationPage());
        } catch (Exception e) {
            log.info(e);
        }
    }
}
