package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        String fileName = args[0];
        String engABC = "QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm";
        int countEngLiter=0;
        try {
            FileInputStream fileInputStream = new FileInputStream(fileName);
            while (fileInputStream.available()>0){
                if (engABC.indexOf(fileInputStream.read())>-1){
                    countEngLiter++;
                }
            }
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(countEngLiter);
    }
}
