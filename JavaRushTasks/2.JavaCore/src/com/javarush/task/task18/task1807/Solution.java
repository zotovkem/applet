package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInStream = new FileInputStream(reader.readLine());
        int countSymbol=0;

        while (fileInStream.available()>0){
            if (fileInStream.read() == 44) countSymbol++;
        }
        fileInStream.close();
        System.out.println(countSymbol);

    }
}
