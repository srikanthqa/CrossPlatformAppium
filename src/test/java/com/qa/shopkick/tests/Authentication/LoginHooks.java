package com.qa.shopkick.tests.Authentication;

import com.qa.shopkick.appium.AbstractTestCase;
import com.qa.shopkick.appium.ScreenBaseClass;
import com.qa.shopkick.overlay.WalkInOverlay;
import com.qa.shopkick.pages.*;
import com.qa.shopkick.utils.CustomHooks;
import com.qa.shopkick.utils.QaRandom;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;

public class LoginHooks extends AbstractTestCase {

    final private static Logger log = Logger.getLogger((LoginHooks.class));

    public static void loginWithFacebook() {
        //from first use flow log into facebook
        SignInPage.clickFacebookSignInButton();

        if (platformType.equalsIgnoreCase("IOS")) {
            if (MicrophonePermissionPage.isMicroPhonePermissionRequired()) {
                //if iOS and if mic permission is asked, give the permission
                MicrophonePermissionPage.clickOKButton();
            }
        }
        FacebookSignInPage.typeEmailANDROID("cm.manish@yahoo.com");
        FacebookSignInPage.typePasswordANDROID("relaxManish");
        FacebookSignInPage.clickLogInANDROID();
    }

    public static void loginWithGoogleplus() {
        CustomHooks.dismissPotHoleError();
        //tap on the 'Guest' button to open left nav bar
        SignInPage.clickGooglePlusSignInButton();
        CustomHooks.dismissMultiLoginMessage();
    }

    public static String loginWithEmail() {
        CustomHooks.dismissPotHoleError();
        SignInPage.clickEmailSignInButton();

        //Element issues, using two different methods to sign in
        if (platformType.equalsIgnoreCase("Android")) {
            String email = "auto@a.com";
            EmailSignInPage.typeEmailANDROID(email);
            EmailSignInPage.typePasswordANDROID("123456");
            EmailSignInPage.clickLoginButton();
            return email;
        } else {
            String email = "qa@i.com";
            EmailSignInPage.clickAndEnterEmailIOS(email);
            EmailSignInPage.clickAndEnterPasswordIOS("123456");
            EmailSignInPage.clickLoginButton();
            return email;
        }
    }

    public static String CreateAccountWithEmail() {
        try {
            CustomHooks.dismissPotHoleError();
            if ("Android".equalsIgnoreCase(platformType)) {
                String email = "auto" + QaRandom.getInstance().getRandomInteger(4) + "@and.com";
                String password = "123456";
                String fName = QaRandom.getInstance().getRandomInteger(2);
                String lName = QaRandom.getInstance().getRandomInteger(2);

                CreateAccountPage.typeEmailANDROID(email);
                CreateAccountPage.typePasswordANDROID(password);
                CreateAccountPage.typePasswordConfirmANDROID(password);
                CreateAccountPage.typeFirstAndLastNameANDROID(fName, lName);
                CreateAccountPage.clickOnSignUpButton();

                PageFactory.initElements(new AppiumFieldDecorator(driver), new LinkPhonePage());
                log.info("Now in LinkPhonePage");

                String expectedPhone = "1847848" + QaRandom.getInstance().getRandomInteger(4);
                LinkPhonePage.clickAndEnterPhoneNumber(expectedPhone);
                LinkPhonePage.clickAndEnterZipcode();
                LinkPhonePage.clickOnCompleteRegistration();
                WalkInOverlay.handleWalkBubble();
                //            String actualPhone = VerifyMobileNumber.getPhoneNumber();
                //            assertEquals("Phone no don't match ", expectedPhone, actualPhone);
                log.info("Going to Ignore the Phone verification for now ");
                CustomHooks.pressBack();
                ScreenBaseClass.waitTillUserIconPresent();
                PageFactory.initElements(new AppiumFieldDecorator(driver), new EmailSignInPage());
                return email;
            } else {
                String email = "qa@i.com";
                EmailSignInPage.clickAndEnterEmailIOS(email);
                EmailSignInPage.clickAndEnterPasswordIOS("123456");
                EmailSignInPage.clickLoginButton();
                return email;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static boolean GoThroughFirstUse() {
        //Go through the first use flow
        try {
            FirstUseDealsEducationPage.clickGetStartedButton();
            if (CountryPickerPage.isCountryPickerPresent()) {
                CountryPickerPage.clickCountryUSA();
                CountryPickerPage.clickNextButton();
            }
            //Redeem your kicks for rewards screen
            FirstUseWalkinEducationPage.clickNextButton();
            //User has to tap on pick a reward
            FirstUseRewardsEducationPage.clickPickARewardButton();
            //Pick default reward
            RewardsPickerPage.clickSelectRewardButton();
            return true;
        } catch (
                Exception e
                )

        {
            e.printStackTrace();
            return false;
        }
    }
}