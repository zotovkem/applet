package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String readFile = reader.readLine();
        String writeFile = reader.readLine();
        BufferedReader readFileStream = new BufferedReader(new FileReader(readFile));
        BufferedWriter writeFileStream = new BufferedWriter(new FileWriter(writeFile));
        String[] arrayNumber = readFileStream.readLine().split(" ");
        for (int i = 0; i <arrayNumber.length ; i++) {
            writeFileStream.write(Math.round(Double.parseDouble(arrayNumber[i])) + " ");
        }
        reader.close();
        readFileStream.close();
        writeFileStream.close();

    }
}
