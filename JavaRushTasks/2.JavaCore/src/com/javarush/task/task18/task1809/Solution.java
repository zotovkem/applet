package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputFileName = reader.readLine();
        String outFileName = reader.readLine();
        FileInputStream fileInStream = new FileInputStream(inputFileName);
        FileOutputStream fileOutStream = new FileOutputStream(outFileName);
        byte[] arrayOutFile = new byte[fileInStream.available()];

        fileInStream.read(arrayOutFile);

        for (int i = arrayOutFile.length-1; i >= 0; i--) {
            fileOutStream.write(arrayOutFile[i]);
        }
        fileInStream.close();
        fileOutStream.close();
    }
}
