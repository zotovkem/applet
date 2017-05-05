package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInStream = new FileInputStream(reader.readLine());


        long[] arrBytes = new long[256];

        byte arrayFile[]=new byte[fileInStream.available()];
        long fileSize=arrayFile.length;
        fileInStream.read(arrayFile);
        fileInStream.close();

        for (int i = 0; i <fileSize ; i++) arrBytes[arrayFile[i] & 0b11111111]++;

        for (int i = 0; i < 256 ; i++) {
            if (arrBytes[i] > 0)
                System.out.print(i + " ");
        }
    }
}
