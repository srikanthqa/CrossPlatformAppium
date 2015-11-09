package com.qa.shopkick.utils;

import com.qa.shopkick.appium.ScreenBaseClass;
import com.qa.shopkick.bubble.ErrorBubble;
import com.qa.shopkick.pages.*;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class CustomHooks extends ScreenBaseClass {

    final private static Logger log = Logger.getLogger(String.valueOf(CustomHooks.class));

    public static void pressBack() {
        log.info("pressBack");
        driver.navigate().back();
    }

    public static void dismissMultiLoginMessage() {
        try {
            waitFor(3);
            if (driver.findElement(By.name("Did you know?")).isDisplayed()) {
                ErrorBubble.tapOnDidYouKnow();
            }
        } catch (NoSuchElementException nse) {
            log.info("Lucky No MultiLoginMessage");
        }
    }

    public static void dismissRedeemRewardMessage() {
        try {
            waitFor(5);
            if (driver.findElement(By.name("Congrats!")).isDisplayed()) {
                RedeemGiftCardDialogPage.clickToDismiss();
            }
        } catch (NoSuchElementException nse) {
            log.info("Lucky No PotHoleError");
        }
    }

    public static void dismissPotHoleError() {
        try {
            waitFor(5);
            if (driver.findElement(By.name("Oops!")).isDisplayed() || driver.findElement(By.name("OK")).isDisplayed()) {
                OopsPotHolePage.clickOnOkToDismissError();
            }
        } catch (NoSuchElementException nse) {
            log.info("Lucky No PotHoleError");
        }
    }

    public static void gotoSignInOrSignUp() {
        try {
            waitFor(5);
            PageFactory.initElements(new AppiumFieldDecorator(driver), new LandingPage());
            TopNavBar.waitTillGuestIconPresent();
            LandingPage.openLeftNavSignedIn();
            WebElement enterManuallyButton = driver.findElementById("com.shopkick.app:id/no_facebook_button");
            enterManuallyButton.click();
            log.info("enterManuallyButton clicked ");
            log.info("In gotoSignInOrSignUp");
            waitFor(3);
        } catch (Exception e) {
            log.error(e);
        }
    }

    public static boolean logMeOut() {
        // before calling method leave app state in stores screen
        try {
            LandingPage.openLeftNavSignedIn();
            LeftNavBar.clickOnSettingsLeftNav();
            LeftNavSettings.clicksettingsAccountSettings();
            AccountSettings.clickAccountSettingsLogOut();
            return true;
        } catch (Exception e) {
            log.error(e);
            return false;
        }
    }

    public static boolean deleteAccount() {
        // before calling method leave app state in stores screen
        try {
            LandingPage.openLeftNavSignedIn();
            //click on settings
            LeftNavBar.clickOnSettingsLeftNav();
            LeftNavSettings.clicksettingsAccountSettings();
            AccountSettings.clickAccountSettingsDeleteAccount();

            return true;
        } catch (Exception e) {
            log.error(e);
            return false;
        }
    }

    public static void  gotoAccountSettings() {
        // before calling method leave app state in stores screen
        try {
            LandingPage.openLeftNavSignedIn();
            waitFor(3);
            //click on settings
            LeftNavBar.clickOnSettingsLeftNav();
            LeftNavSettings.clicksettingsAccountSettings();
            PageFactory.initElements(new AppiumFieldDecorator(driver), new AccountSettings());
        } catch (Exception e) {
            log.error(e);
        }
    }

    public static String getUserName() {
        // before calling method leave app state in stores screen
        try {
            LandingPage.openLeftNavSignedIn();
            //click on settings
            return LeftNavBar.getUserProfileText();

        } catch (Exception e) {
            log.error(e);
            return "";
        }
    }

    //TODO: Add First Name, Last Name and other sutffs
    public static void printUserInformation() {
        // before calling method leave app state in stores screen
        try {
            LandingPage.openLeftNavSignedIn();
            //click on settings
            LeftNavBar.clickOnSettingsLeftNav();
            LeftNavSettings.clickAboutYouSettings();
            AccountSettings.clickAccountSettingsLogOut();
        } catch (Exception e) {
            log.error(e);
        }
    }
}