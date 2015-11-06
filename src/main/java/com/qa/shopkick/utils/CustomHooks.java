package com.qa.shopkick.utils;

import com.qa.shopkick.appium.ScreenBaseClass;
import com.qa.shopkick.overlay.ErrorOverlay;
import com.qa.shopkick.pages.*;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
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
                ErrorOverlay.tapOnDidYouKnow();
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
            //driver.fi
            PageFactory.initElements(new AppiumFieldDecorator(driver), new LandingPage());
            waitTillGuestIconPresent();
            LandingPage.openLeftNavSignedIn();
            driver.scrollTo("ENTER MANUALLY").click();
            log.info("In gotoSignInOrSignUp");
        } catch (Exception e) {
            log.error(e);
        }
    }

    public static boolean logMeOut() {
        // before calling method leave app state in stores screen
        try {
            LandingPage.openLeftNavSignedIn();
            driver.scrollTo("Settings");
            //click on settings
            LeftNavBar.clickOnSettingsLeftNav();
            LeftNavSettings.clicksettingsAccountSettings();
            AccountSettings.clickAccountSettingsLogOut();
            QaScreenshot.getInstance().capture(driver);
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
            driver.scrollTo("Settings");
            //click on settings
            LeftNavBar.clickOnSettingsLeftNav();
            LeftNavSettings.clicksettingsAccountSettings();
            AccountSettings.clickAccountSettingsDeleteAccount();

            QaScreenshot.getInstance().capture(driver);
            return true;
        } catch (Exception e) {
            log.error(e);
            return false;
        }
    }

    public static void gotoAccountSettings() {
        // before calling method leave app state in stores screen
        try {
            LandingPage.openLeftNavSignedIn();
            driver.scrollTo("Questions?");
            driver.scrollTo("Settings");
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
            driver.scrollTo("Settings");
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
            driver.scrollTo("Settings");
            //click on settings
            LeftNavBar.clickOnSettingsLeftNav();
            LeftNavSettings.clickAboutYouSettings();
            AccountSettings.clickAccountSettingsLogOut();
        } catch (Exception e) {
            log.error(e);
        }
    }
}