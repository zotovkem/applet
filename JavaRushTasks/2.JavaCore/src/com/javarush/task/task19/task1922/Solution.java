package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");

    }


    public static void main(String[] args) {
        StringBuilder allStr = new StringBuilder();
        String fileName = null;
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            fileName = reader.readLine();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (fileName.length() > 0) {
            try {
                FileReader fileReader = new FileReader(fileName);
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
                int countWords = 0;
                for (String wordStr :
                        words) {
                    if (lineStr.trim().contains(wordStr))
                        countWords++;
                }
                if (countWords == 2)
                    System.out.println(lineStr.trim());
            }
        }
    }
}
