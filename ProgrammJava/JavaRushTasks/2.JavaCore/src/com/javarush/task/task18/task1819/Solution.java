package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String firstFileName = reader.readLine();
        String secondFileName = reader.readLine();
        FileInputStream fileInStream1 = new FileInputStream(firstFileName);
        FileInputStream fileInStream2 = new FileInputStream(secondFileName);

        byte[] firstArrayByte = new byte[fileInStream1.available()];
        byte[] secondArrayByte = new byte[fileInStream2.available()];
        fileInStream1.read(firstArrayByte);
        fileInStream2.read(secondArrayByte);
        fileInStream1.close();

        FileOutputStream fileOutStream = new FileOutputStream(firstFileName);
        fileOutStream.write(secondArrayByte);
        fileOutStream.write(firstArrayByte);

        fileInStream2.close();
        fileOutStream.close();
    }
}
