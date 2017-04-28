package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;

public class Solution {
    public static void main(String[] args) {
        String fileName = args[0];
        int countSymbol = 0, countSpace = 0;
        try {
            FileInputStream fileInputStream = new FileInputStream(fileName);
            while (fileInputStream.available()>0){
                if (fileInputStream.read() == ' '){
                    countSpace++;
                }
                countSymbol++;
            }
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(String.format("%(.2f", (float) countSpace/countSymbol*100));
    }
}
