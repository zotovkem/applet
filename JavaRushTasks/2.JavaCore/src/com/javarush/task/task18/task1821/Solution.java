package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;

public class Solution {
    public static void main(String[] args) throws Exception{
        FileInputStream fileInStream = new FileInputStream(args[0]);

        long[] arrBytes = new long[256];

        byte arrayFile[]=new byte[fileInStream.available()];
        long fileSize=arrayFile.length;
        fileInStream.read(arrayFile);
        fileInStream.close();

        for (int i = 0; i <fileSize ; i++) arrBytes[arrayFile[i] & 0b11111111]++;

        for (int i = 0; i < 256 ; i++) {
            if (arrBytes[i] > 0)
                System.out.println((char) (i & 0b11111111)+" "+ arrBytes[i]);
        }
    }
}
