package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String readFile = reader.readLine();
        BufferedReader readFileStream = new BufferedReader(new FileReader(readFile));
        while (readFileStream.ready()) {
            String strPrice = readFileStream.readLine();
            if (strPrice.startsWith(args[0])) {
                System.out.println(strPrice);
            }
        }
        reader.close();
        readFileStream.close();
    }
}
