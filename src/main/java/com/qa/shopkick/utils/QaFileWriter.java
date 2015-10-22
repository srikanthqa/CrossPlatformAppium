package com.qa.shopkick.utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by mmadhusoodan on 8/6/15.
 */
public class QaFileWriter {

    public static void appendToFile(String filePath, String text) {
        PrintWriter fileWriter = null;

        try {
            fileWriter = new PrintWriter(new BufferedWriter(new FileWriter(filePath, true)));
            fileWriter.println(text);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } finally {
            if (fileWriter != null) {
                fileWriter.close();
            }
        }
    }


}
