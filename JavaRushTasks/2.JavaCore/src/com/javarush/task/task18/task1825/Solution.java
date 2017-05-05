package com.javarush.task.task18.task1825;

/* 
Собираем файл
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        TreeSet<String> fileList = new TreeSet<>();
        String str = "";
        while (!(str = reader.readLine()).equals("end")) {
            fileList.add(str);
        }
        str = fileList.first();
        String nameFileTarget = str.substring(0,str.length()-6);
        FileOutputStream fileOutStream = new FileOutputStream(nameFileTarget);
        for (String strList : fileList) {
            FileInputStream fileInputStream = new FileInputStream(strList);
            byte[] arrBuffer = new byte[fileInputStream.available()];
            fileInputStream.read(arrBuffer);
            fileOutStream.write(arrBuffer);
            fileInputStream.close();
        }
        fileOutStream.close();
    }
}
