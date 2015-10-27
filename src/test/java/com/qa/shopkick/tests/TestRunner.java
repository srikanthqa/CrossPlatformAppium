package com.qa.shopkick.tests;

import com.qa.shopkick.tests.Authentication.EmailAuthentication;
import com.qa.shopkick.tests.Authentication.FacebookAuthentication;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by mmadhusoodan on 6/5/15.
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({
        //

        FacebookAuthentication.class,
        EmailAuthentication.class

})

public class TestRunner {

}