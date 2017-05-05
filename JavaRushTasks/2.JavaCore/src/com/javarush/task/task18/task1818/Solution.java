package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Solution {
        public static void main(String[] args) throws Exception{
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String firstFileName = reader.readLine();
            String secondFileName = reader.readLine();
            String thirdFileName = reader.readLine();
            FileOutputStream fileOutStream = new FileOutputStream(firstFileName);
            FileInputStream fileInStream1 = new FileInputStream(secondFileName);
            FileInputStream fileInStream2 = new FileInputStream(thirdFileName);

            byte[] arrayByte = new byte[fileInStream1.available()];
            fileInStream1.read(arrayByte);
            fileOutStream.write(arrayByte);

            arrayByte = new byte[fileInStream2.available()];
            fileInStream2.read(arrayByte);
            fileOutStream.write(arrayByte);

            fileInStream1.close();
            fileInStream2.close();
            fileOutStream.close();
    }
}
