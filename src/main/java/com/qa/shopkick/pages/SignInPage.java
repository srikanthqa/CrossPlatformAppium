package com.qa.shopkick.pages;

import com.qa.shopkick.utils.AbstractPage;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class SignInPage extends AbstractPage {

	//@iOSFindBy()
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/title_text\").text(\"Sign in or sign up\").className(\"android.widget.TextView\")")
	 @iOSFindBy(uiAutomator = ".staticTexts()[\"Sign in or sign up\"]")
	private static WebElement signInOrSignUp;

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/button_text\").text(\"FACEBOOK\")")
	@iOSFindBy(uiAutomator = ".buttons()[\"Facebook\"]")
	private static WebElement signInFacebookSignIn;

	public static void clicksignInFacebookSignIn(){
		signInFacebookSignIn.click();
		PageFactory.initElements(new AppiumFieldDecorator(driver),new DidYouKnowPage());
		PageFactory.initElements(new AppiumFieldDecorator(driver),new LandingPage());
	}

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/button_text\").text(\"GOOGLE\")")
	@iOSFindBy(uiAutomator= ".buttons()[\"Google\"]")
	private static WebElement signInGooglePlusSignIn;

	public static void clicksignInGooglePlusSignIn(){
		signInGooglePlusSignIn.click();
		PageFactory.initElements(new AppiumFieldDecorator(driver),new LandingPage());
		PageFactory.initElements(new AppiumFieldDecorator(driver),new DidYouKnowPage());
	}

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/button_text\").text(\"EMAIL\")")
	@iOSFindBy(uiAutomator = ".buttons()[\"Email\"]")
	private static WebElement signInEmailSignIn;

	public static void clicksignInEmailSignIn(){
		signInEmailSignIn.click();
		PageFactory.initElements(new AppiumFieldDecorator(driver),new EmailSignInPage());
		PageFactory.initElements(new AppiumFieldDecorator(driver),new EmailSignUp());
	}

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/facebook_flow_text\").text(\"We will never post anything without your permission.\")")
	private static WebElement signInFacebookFlowText;

}
