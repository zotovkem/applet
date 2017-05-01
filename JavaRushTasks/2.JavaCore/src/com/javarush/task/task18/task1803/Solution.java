package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInStream = new FileInputStream(reader.readLine());

        long maxByte = 0;
        long[] arrBytes = new long[256];

        byte arrayFile[]=new byte[fileInStream.available()];
        long fileSize=arrayFile.length;
        fileInStream.read(arrayFile);
        fileInStream.close();

        for (int i = 0; i <fileSize ; i++) {
            arrBytes[arrayFile[i] & 0b11111111]++;
            if (arrBytes[arrayFile[i] & 0b11111111] > maxByte)
                maxByte = arrBytes[arrayFile[i] & 0b11111111];
        }
        for (int i = 0; i <arrBytes.length-1 ; i++) {
            if (arrBytes[i] == maxByte)
                System.out.print(i+" ");
        }
    }
}
