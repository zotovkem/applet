package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) {
        StringBuilder allStr = new StringBuilder();
        if (args.length > 1) {
            try {
                FileReader fileReader = new FileReader(args[0]);

                while (fileReader.ready()) {
                    char[] arrBuf = new char[256];
                    fileReader.read(arrBuf);
                    allStr.append(arrBuf);
                }
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            String regEx = "(\\S+\\d+\\S+)|(\\S+\\d)|(\\d+\\S+)|(\\d)";
            Pattern p = Pattern.compile(regEx);
            Matcher m = p.matcher(allStr);
            try {
                FileWriter fileWriter = new FileWriter(args[1]);
                while (m.find()) {
                    fileWriter.write(allStr.substring(m.start(), m.end())+" ");
                }
                fileWriter.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
