package com.qa.shopkick.tests;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Logger;

/**
 * Created by mmadhusoodan on 10/21/15.
 */
public class HelloSK {


    final private static Logger log = Logger.getLogger("");

    public static void main(String[] args) {

        System.out.print("Good Morining ");
                JSONObject obj = new JSONObject();
                obj.put("name", "mkyong.com");
                obj.put("age", new Integer(100));

                JSONArray list = new JSONArray();
                list.add("msg 1");
                list.add("msg 2");
                list.add("msg 3");

                obj.put("messages", list);

                try {

                    FileWriter file = new FileWriter("c:\\test.json");
                    file.write(obj.toJSONString());
                    file.flush();
                    file.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }

                System.out.print(obj);

    }
}

