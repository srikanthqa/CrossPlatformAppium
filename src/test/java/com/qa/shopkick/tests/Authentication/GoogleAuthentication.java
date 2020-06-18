package com.qa.shopkick.tests.Authentication;

import com.qa.shopkick.appium.AbstractTestCase;
import com.qa.shopkick.utils.CustomHooks;
import org.apache.log4j.Logger;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GoogleAuthentication extends AbstractTestCase {

    final private static Logger log = Logger.getLogger((EmailAuthentication.class));
    @Test
    public void Test1_GooglePlusSignIn() {
        LoginHooks.loginWithGoogleplus();
    }

    @Test
    public void Test2_logOutOfFacebook() {
        CustomHooks.logMeOut();
    }

}
