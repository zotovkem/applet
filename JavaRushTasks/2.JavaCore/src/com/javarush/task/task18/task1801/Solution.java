package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInStream = new FileInputStream(reader.readLine());
        int max = 0;
        while (fileInStream.available()>0){
            int data = fileInStream.read();
            if (data>max)
                max = data;
        }
        fileInStream.close();
        System.out.println(max);
    }
}
