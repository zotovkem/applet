package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputFileName = reader.readLine();
        String firstOutFileName = reader.readLine();
        String secondOutFileName = reader.readLine();
        FileInputStream fileInStream = new FileInputStream(inputFileName);
        FileOutputStream fileOutStream1 = new FileOutputStream(firstOutFileName);
        FileOutputStream fileOutStream2 = new FileOutputStream(secondOutFileName);
        int firstOutFileSize = 0, secondOutFileSize = 0;

        if (fileInStream.available()%2 == 0){
             firstOutFileSize = secondOutFileSize = fileInStream.available()/2;
        }else{
             firstOutFileSize = fileInStream.available()/2+1;
             secondOutFileSize = fileInStream.available()/2;
        }
        byte[] firstArrayOutFile = new byte[fileInStream.available()];

        fileInStream.read(firstArrayOutFile);

        fileOutStream1.write(firstArrayOutFile, 0, firstOutFileSize);
        fileOutStream2.write(firstArrayOutFile, firstOutFileSize, secondOutFileSize);

        fileInStream.close();
        fileOutStream1.close();
        fileOutStream2.close();

    }
}
