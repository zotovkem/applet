package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Pattern p = Pattern.compile("\\d|\\d+\\d");

        String fileSource = reader.readLine();
        String fileDestin = reader.readLine();
        reader.close();

        BufferedReader fileReader = new BufferedReader(new FileReader(fileSource));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileDestin));

        while (fileReader.ready()) {
            String data = fileReader.readLine();
            for (String s : data.split(" ")) {
                Matcher m = p.matcher(s);
                if (m.matches()) {
                    fileWriter.write(s + " ");
                }
            }


        }

        fileReader.close();
        fileWriter.close();
    }
}
