package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileSource = reader.readLine();
        reader.close();

        BufferedReader fileReader = new BufferedReader(new FileReader(fileSource));
        int count = 0;

        while (fileReader.ready()) {
            String data = fileReader.readLine();

            for (String s : data.split("[^\\w]")) {
                if (s.equals("world")) {
                    count++;
                }
            }
        }
        fileReader.close();
        System.out.println(count);
    }
}
