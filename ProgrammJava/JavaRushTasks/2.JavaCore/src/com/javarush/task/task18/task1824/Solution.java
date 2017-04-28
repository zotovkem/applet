package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = "";
        while (true){
            try {
                fileName = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {

                FileInputStream fileInputStream = new FileInputStream(fileName);
                fileInputStream.close();
            }catch (Exception e){
                System.out.println(fileName);
                break;
            }
        }
    }
}
