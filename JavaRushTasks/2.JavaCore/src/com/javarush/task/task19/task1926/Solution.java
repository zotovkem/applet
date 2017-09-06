package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.*;
import java.nio.Buffer;

public class Solution {
    public static void main(String[] args) {

            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                String readFile = reader.readLine();
                reader.close();

                BufferedReader fileReader = new BufferedReader(new FileReader(readFile));

                StringBuilder allStr = new StringBuilder();
                while (fileReader.ready()) {
                    allStr.append(new StringBuilder(fileReader.readLine()).reverse());
                    allStr.append(System.lineSeparator());
                }

                System.out.println(allStr);

                fileReader.close();

            } catch (IOException e) {
                e.printStackTrace();
            }


        }
}
