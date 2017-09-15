package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static int calculateCountSubstring(String sourceStr, String subStr) {
        int count = 0;
        String pattern = "(" + subStr + ")\\s?";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(sourceStr);
        while (m.find()) count++;
        return count;
    }

    public static void main(String[] args) {
        if (args.length > 0) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder text = new StringBuilder();
            String openTag = "<" + args[0];
            String closeTag = "</" + args[0] + ">";
            int countCloseTag = 0;
            int countOpenTag = 0;
            try {
                BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()));
                reader.close();

                while (fileReader.ready()) {
                    String str2 = fileReader.readLine();
                    text.append(str2);
                }
                fileReader.close();
                String modifyText = text.toString();
                StringBuilder fullCloseStrTag = new StringBuilder();

                String pattern = "(" + closeTag + ")";
                Pattern p = Pattern.compile(pattern);
                Matcher m = p.matcher(modifyText);
                String str = "";
                int position = 0;
                while (m.find()) {
                    str = modifyText.substring(position, m.end());
                    position = m.end();
                    countCloseTag += calculateCountSubstring(str, closeTag);
                    countOpenTag += calculateCountSubstring(str, openTag);

                    if (countOpenTag + countCloseTag > 0) {
                        if (str.contains(openTag)) {
                            fullCloseStrTag.append(str.substring(str.indexOf(openTag), str.length()));
                        } else {
                            fullCloseStrTag.append(str.substring(0, str.length()));
                        }
                        if (countOpenTag == countCloseTag) {
                            while (countOpenTag + countCloseTag > 0) {
                                System.out.println(fullCloseStrTag.toString());
                                if (countCloseTag > 1 && countOpenTag > 1) {
                                    //delete open teg
                                    fullCloseStrTag.replace(0, fullCloseStrTag.indexOf(openTag, openTag.length()), "");
                                    //delete close tag
                                    fullCloseStrTag.replace(fullCloseStrTag.lastIndexOf(closeTag), fullCloseStrTag.length(), "");
                                    //delete text before close tag
                                    fullCloseStrTag.replace(fullCloseStrTag.lastIndexOf(closeTag) + closeTag.length(), fullCloseStrTag.length(), "");
                                } else fullCloseStrTag.replace(0, fullCloseStrTag.length(), "");
                                countCloseTag = calculateCountSubstring(fullCloseStrTag.toString(), closeTag);
                                countOpenTag = calculateCountSubstring(fullCloseStrTag.toString(), openTag);
                            }
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}