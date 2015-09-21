package com.qa.shopkick.pages;

import com.qa.shopkick.utils.AbstractPage;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class FirstUseDealsEducationPage extends AbstractPage{

    @iOSFindBy(uiAutomator = ".buttons()[\"Get Started\"]")
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/button_text\").text(\"GET STARTED\")")
    private static WebElement getStartedFirstUse;

    public static void clickNextButton(){
        getStartedFirstUse.click();
        PageFactory.initElements(new AppiumFieldDecorator(driver),new CountryPickerPage());
        PageFactory.initElements(new AppiumFieldDecorator(driver),new FirstUseWalkinEducationPage());
    }
}
