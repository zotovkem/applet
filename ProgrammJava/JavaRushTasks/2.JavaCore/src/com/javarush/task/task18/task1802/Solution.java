package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInStream = new FileInputStream(reader.readLine());
        int min = fileInStream.read();
        while (fileInStream.available()>0){
            int data = fileInStream.read();
            if (data<min)
                min = data;
        }
        fileInStream.close();
        System.out.println(min);
    }
}
