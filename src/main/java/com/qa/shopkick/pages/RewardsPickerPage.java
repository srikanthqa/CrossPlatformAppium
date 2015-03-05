package com.qa.shopkick.pages;

import com.qa.shopkick.utils.AbstractPage;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Srikanth on 12/16/14.
 */
public class RewardsPickerPage extends AbstractPage{

    @iOSFindBy(uiAutomator = ".buttons()[\"Next\"]")
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/button_text\").text(\"NEXT\")")
    private static WebElement nextButton;

    public static void clickNextButton(){
        nextButton.click();
        PageFactory.initElements(new AppiumFieldDecorator(driver), new FirstUseRegistrationIntroPage());
        PageFactory.initElements(new AppiumFieldDecorator(driver), new FirstUseAlternateScreen());
    }
    
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/kick_amount\").text(\"3400\")")
	private static WebElement RewardsPickerPageGasReward;
    
    public static void clickGasReward(){
        RewardsPickerPageGasReward.click();
    }

}
