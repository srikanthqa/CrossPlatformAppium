package com.qa.shopkick.pages;

import com.qa.shopkick.appium.ScreenBaseClass;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class EmailSignInPage extends ScreenBaseClass {

    final private static Logger log = Logger.getLogger(String.valueOf(EmailSignInPage.class));
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/error_box\")")
    private static WebElement ErrorEmailPassword;
    @iOSFindBy(uiAutomator = ".textFields()[\"Email Address\"]")
    private static WebElement eMailField;
    @iOSFindBy(uiAutomator = ".scrollViews()[0].secureTextFields()[0]")
    private static WebElement emailsigninPassword;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/password_confirmation\")")
    @iOSFindBy(uiAutomator = ".secureTextFields().firstWithPredicate(\"value like 'Confirm Password'\")")
    private static WebElement emailConfirmPassword;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/button_text\").text(\"SIGN IN OR SIGN UP\")")
    private static WebElement emailsigninSignInOrSignUpButton;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/first_name\").text(\"First name\")")
    @iOSFindBy(uiAutomator = ".scrollViews()[0].textFields().firstWithPredicate(\"value like 'First name'\")")
    private static WebElement emailSignUpFirstName;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/last_name\").text(\"Last name\")")
    @iOSFindBy(uiAutomator = ".scrollViews()[0].textFields().firstWithPredicate(\"value like 'Last name'\")")
    private static WebElement emailSignUpLastName;
    @iOSFindBy(uiAutomator = ".scrollViews()[0].buttons().firstWithPredicate(\"value like 'Sign'\"))")
    private static WebElement signInSignUpIOS;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/forgot_password\").text(\"Forgot password?\")")
    private static WebElement emailsigninForgotYourPassword;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.shopkick.app:id/button_text\").text(\"LOG IN\")")
    private static WebElement logInEmailButton;

    public static void typeEmailANDROID(String emailLogin) {
        MobileElement emailAddress = (MobileElement) driver.findElement(By.id("com.shopkick.app:id/email"));
        emailAddress.click();
        emailAddress.clear();
        emailAddress.sendKeys(emailLogin);
        log.info("Type Email:" + emailLogin);
    }

    public static void typePasswordANDROID(String passwordLogin) {
        MobileElement passwordField = (MobileElement) driver.findElement(By.id("com.shopkick.app:id/password"));
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys(passwordLogin);
        log.info("Type Password: " + passwordLogin);
    }

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

    public static void clickAndEnterEmailIOS(String email) {
        eMailField.click();
        eMailField.sendKeys(email);
    }

    public static void clickAndEnterPasswordIOS(String pswd) {
        emailsigninPassword.click();
        emailsigninPassword.sendKeys(pswd);
        PageFactory.initElements(new AppiumFieldDecorator(driver), new EmailSignInPage());
    }

    public static void enterConfirmPassword() {
        emailConfirmPassword.click();
        emailConfirmPassword.sendKeys("sktest123");
        PageFactory.initElements(new AppiumFieldDecorator(driver), new EmailSignInPage());
    }

    public static void clickAndEnterFirstName() {
        emailSignUpFirstName.click();
        emailSignUpFirstName.sendKeys("Name");
    }

    public static void clickAndEnterLastName() {
        emailSignUpLastName.click();
        emailSignUpLastName.sendKeys("Laster");
    }

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

    public static void clickemailsigninForgotYourPassword() {
        emailsigninForgotYourPassword.click();
    }

    public static void clickLoginButton() {
        logInEmailButton.click();
        waitFor(5);
        PageFactory.initElements(new AppiumFieldDecorator(driver), new LandingPage());
        PageFactory.initElements(new AppiumFieldDecorator(driver), new StoresPage());
    }
}
