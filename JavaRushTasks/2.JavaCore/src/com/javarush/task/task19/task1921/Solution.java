package com.javarush.task.task19.task1921;

import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) {
        HashMap<String, Double> amountList = new HashMap<>();
        double maxAmount = 0;
        StringBuilder allStr = new StringBuilder();
        if (args.length > 0) {
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
            for (String lineStr :
                    allStr.toString().split(System.lineSeparator())) {
                String nameStr = lineStr.trim().replaceAll("\\d", "").trim();
                String dateStr = lineStr.trim().replaceAll(nameStr, "").trim().replaceAll(" ", ".");
                SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
                Date birthDay = null;

                try {
                    birthDay = format.parse(dateStr);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                PEOPLE.add(new Person(nameStr,birthDay));

            }
        }
    }
}
