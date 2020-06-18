package com.qa.shopkick.pages;

import com.qa.shopkick.appium.ScreenBaseClass;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

public class FacebookSignInPage extends ScreenBaseClass {

    final private static Logger log = Logger.getLogger(String.valueOf(FacebookSignInPage.class));

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.facebook.katana:id/login_username\")")
    private static WebElement emailText;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.facebook.katana:id/login_password\")")
    private static WebElement passwordText;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.facebook.katana:id/login_login\")")
    private static WebElement logInButton;

    public static void typeEmailANDROID(String emailLogin) {
        try {
            emailText.click();
            emailText.clear();
            emailText.sendKeys(emailLogin);
            log.info("Type Email:" + emailLogin);
        } catch (Exception e) {
            log.debug(e);
        }
    }

    public static void typePasswordANDROID(String passwordLogin) {
        try {
            passwordText.click();
            passwordText.clear();
            passwordText.sendKeys(passwordLogin);
            log.info("Type Password: " + passwordLogin);
        } catch (Exception e) {
            log.debug(e);
        }
    }

    public static void clickLogInANDROID() {
        try {
            logInButton.click();
            log.info("clickLogInANDROID");
        } catch (Exception e) {
            log.debug(e);
        }
    }

 /*
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/error_box\")")
    private static WebElement ErrorEmailPassword;

    public static String getEmailPasswordError() {

        try {
            return ErrorEmailPassword.getText();
        } catch (NoSuchElementException nse) {
            return "";

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @iOSFindBy(uiAutomator = ".textFields()[\"Email Address\"]")
    private static WebElement eMailField;

    public static void clickAndEnterEmailIOS(String email) {
        eMailField.click();
        eMailField.sendKeys(email);
    }

    @iOSFindBy(uiAutomator = ".scrollViews()[0].secureTextFields()[0]")
    private static WebElement emailsigninPassword;

    public static void clickAndEnterPasswordIOS(String pswd) {
        emailsigninPassword.click();
        emailsigninPassword.sendKeys(pswd);
        PageFactory.initElements(new AppiumFieldDecorator(driver), new FacebookSignInPage());
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/password_confirmation\")")
    @iOSFindBy(uiAutomator = ".secureTextFields().firstWithPredicate(\"value like 'Confirm Password'\")")
    private static WebElement emailConfirmPassword;

    public static void enterConfirmPassword() {
        emailConfirmPassword.click();
        emailConfirmPassword.sendKeys("sktest123");
        PageFactory.initElements(new AppiumFieldDecorator(driver), new FacebookSignInPage());
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/button_text\").text(\"SIGN IN OR SIGN UP\")")
    private static WebElement emailsigninSignInOrSignUpButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/first_name\").text(\"First name\")")
    @iOSFindBy(uiAutomator = ".scrollViews()[0].textFields().firstWithPredicate(\"value like 'First name'\")")
    private static WebElement emailSignUpFirstName;

    public static void clickAndEnterFirstName() {
        emailSignUpFirstName.click();
        emailSignUpFirstName.sendKeys("Name");
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/last_name\").text(\"Last name\")")
    @iOSFindBy(uiAutomator = ".scrollViews()[0].textFields().firstWithPredicate(\"value like 'Last name'\")")
    private static WebElement emailSignUpLastName;

    public static void clickAndEnterLastName() {
        emailSignUpLastName.click();
        emailSignUpLastName.sendKeys("Laster");
    }

    @iOSFindBy(uiAutomator = ".scrollViews()[0].buttons().firstWithPredicate(\"value like 'Sign'\"))")
    private static WebElement signInSignUpIOS;

    public static void clickSignInIOS() {
        driver.hideKeyboard();
        signInSignUpIOS.click();
        PageFactory.initElements(new AppiumFieldDecorator(driver), new DidYouKnowPage());
        PageFactory.initElements(new AppiumFieldDecorator(driver), new LinkPhonePage());
        PageFactory.initElements(new AppiumFieldDecorator(driver), new LandingPage());
        PageFactory.initElements(new AppiumFieldDecorator(driver), new StoresPage());
    }

    public static void clickOnSignUpButton() {
        driver.hideKeyboard();
        MobileElement signUpSubmitButton = (MobileElement) driver.findElement(By.id("com.shopkick.app:id/submit"));
        signUpSubmitButton.click();
        PageFactory.initElements(new AppiumFieldDecorator(driver), new DidYouKnowPage());
        PageFactory.initElements(new AppiumFieldDecorator(driver), new LinkPhonePage());
        PageFactory.initElements(new AppiumFieldDecorator(driver), new LandingPage());
        PageFactory.initElements(new AppiumFieldDecorator(driver), new StoresPage());
    }


    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/forgot_password\").text(\"Forgot passwordText?\")")
    private static WebElement emailsigninForgotYourPassword;

    public static void clickemailsigninForgotYourPassword() {
        emailsigninForgotYourPassword.click();
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/button_text\").text(\"LOG IN\")")
    private static WebElement logInEmailButton;

    public static void clickLoginButton() {
        logInEmailButton.click();
        CustomHooks.waitFor(5);
        PageFactory.initElements(new AppiumFieldDecorator(driver), new DidYouKnowPage());
        PageFactory.initElements(new AppiumFieldDecorator(driver), new LandingPage());
        PageFactory.initElements(new AppiumFieldDecorator(driver), new StoresPage());
    }
*/
}
