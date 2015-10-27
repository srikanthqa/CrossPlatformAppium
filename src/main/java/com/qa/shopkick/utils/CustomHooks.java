package com.qa.shopkick.utils;

import com.qa.shopkick.pages.*;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class CustomHooks extends ScreenBaseClass {

    final private static Logger log = Logger.getLogger(String.valueOf(CustomHooks.class));

    public static void dismissMultiLoginMessage() {
        try {
            waitFor(3);
            if (driver.findElement(By.name("Did you know?")).isDisplayed()) {
                DidYouKnowPage.tapOnDidYouKnow();
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

    public static void LogMeOut() {
        // before calling method leave app state in stores screen
        try {
            LandingPage.openLeftNavSignedIn();
            driver.scrollTo("Settings");
            //click on settings
            LeftNavBar.clickOnSettingsLeftNav();
            LeftNavSettings.clicksettingsAccountSettings();
            AccountSettings.clickAccountSettingsLogOut();
        } catch (Exception e) {
            log.error(e);
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
