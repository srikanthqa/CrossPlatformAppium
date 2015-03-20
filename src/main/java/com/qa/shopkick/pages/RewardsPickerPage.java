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
        PageFactory.initElements(new AppiumFieldDecorator(driver), new SignInPage());
    }
    
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/kick_amount\").text(\"3400\")")
	private static WebElement RewardsPickerPageGasReward;
    
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/kick_amount\").text(\"1875000\")")
    @iOSFindBy(uiAutomator = ".cells().firstWithName(\"1875000\")")
	private static WebElement RewardsPickerPageVespaReward;
    
    public static void clickGasReward(){
        RewardsPickerPageGasReward.click();
    }
    
    public static void clickVespaReward(){
    	RewardsPickerPageVespaReward.click();
    }
    
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/app_screen_back_button\")")
	@iOSFindBy(uiAutomator = ".buttons()[0]")
	private static WebElement changeRewardBack;
	
	public static void clickOnBackButton(){
		changeRewardBack.click();
		PageFactory.initElements(new AppiumFieldDecorator(driver), new KicksCenterRewadsPage());
	}

}
