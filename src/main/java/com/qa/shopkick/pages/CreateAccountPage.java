package com.qa.shopkick.pages;

import com.qa.shopkick.appium.ScreenBaseClass;
import com.qa.shopkick.bubble.ErrorBubble;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class CreateAccountPage extends ScreenBaseClass {
    final private static Logger log = Logger.getLogger(String.valueOf(CreateAccountPage.class));

    public static void typeEmailANDROID(String emailLogin) {
        try {
            MobileElement emailAddress = (MobileElement) driver.findElement(By.id("com.shopkick.app:id/email"));
            emailAddress.click();
            emailAddress.clear();
            emailAddress.sendKeys(emailLogin);
            log.info("Type Email:" + emailLogin);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void typePasswordANDROID(String passwordLogin) {
        try {
            MobileElement passwordField = (MobileElement) driver.findElement(By.id("com.shopkick.app:id/password"));
            passwordField.click();
            passwordField.clear();
            passwordField.sendKeys(passwordLogin);
            log.info("Type Password: " + passwordLogin);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void typePasswordConfirmANDROID(String passwordLogin) {
        try {
            waitFor(2);
            MobileElement passwordField = (MobileElement) driver.findElement(By.id("com.shopkick.app:id/password_confirmation"));
            passwordField.click();
            passwordField.clear();
            passwordField.sendKeys(passwordLogin);
            log.info("Type Password: " + passwordLogin);
        } catch (Exception e) {
            log.error(e);
        }
    }

    public static void typeFirstAndLastNameANDROID(String fName, String lName) {
        try {
            waitFor(2);
            MobileElement fname = (MobileElement) driver.findElement(By.id("com.shopkick.app:id/first_name"));
            MobileElement lname = (MobileElement) driver.findElement(By.id("com.shopkick.app:id/last_name"));
            fname.click();
            fname.clear();
            fname.sendKeys(fName);
            lname.click();
            lname.clear();
            lname.sendKeys(lName);
            pressBack();
            log.info(" First and Last Name:" + fName + " " + lName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void clickOnSignUpButton() {
        try {
            MobileElement signUpButton = (MobileElement) driver.findElement(By.id("com.shopkick.app:id/button_text"));
            signUpButton.click();
            PageFactory.initElements(new AppiumFieldDecorator(driver), new ErrorBubble());
            PageFactory.initElements(new AppiumFieldDecorator(driver), new LinkPhonePage());
            PageFactory.initElements(new AppiumFieldDecorator(driver), new LandingPage());
            PageFactory.initElements(new AppiumFieldDecorator(driver), new StoresPage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
