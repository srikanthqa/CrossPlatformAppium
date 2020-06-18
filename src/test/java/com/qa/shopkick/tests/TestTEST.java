package com.qa.shopkick.tests;

import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mmadhusoodan on 11/9/15.
 */

public class TestTEST {

    final private static Logger log = Logger.getLogger(TestTEST.class);

    String[] StringSplit(String a, String b) {

        String[] output;
        if (a.length() == 0 || b.length() == 0) {
            return null;
        }
        output = a.split(b);
        return output;
    }

    String[] PaxataSplit(String a, String b) {

        List<String> output = new ArrayList<String>();
        if (a.length() == 0 || b.length() == 0) {
            return null;
        }
        int k = 0;
        for (int i = 0; i < a.length(); i++) {
            String temp = a.substring(i, i + 1);

            if (temp.equalsIgnoreCase(b)) {
                output.add(a.substring(k, i));
            }
        }
        return output.toArray(new String[output.size()]);
    }

    @Test
    public void TestHello_StringSplit() {

        String array[] = StringSplit("Today is Monday", " ");

        for (String a : array) {
            log.info(a);
        }
    }

    @Test
    public void TestHello_PaxataSplit() {

        String array[] = PaxataSplit("Today is Monday", " ");

        for (String a : array) {
            log.info(a);
        }


    }
}
