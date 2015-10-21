package com.qa.shopkick.tests;

import org.junit.Test;

import java.util.logging.Logger;

/**
 * Created by mmadhusoodan on 10/21/15.
 */
public class HelloSK {


    final private static Logger log = Logger.getLogger("");

    @Test
    public void TestHello_StringSplit() {

        String array[] = "Today is Monday".split("");

        for (String a : array) {
            log.info(a);
        }
    }

    @Test
    public void TestHello_Appium() {


    }
}

