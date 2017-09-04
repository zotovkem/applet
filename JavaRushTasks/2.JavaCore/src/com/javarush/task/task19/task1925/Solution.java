package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        StringBuilder allStr = new StringBuilder();
        StringBuilder resultStr = new StringBuilder();
        if (args.length > 1) {
            try {
                BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
                BufferedWriter fileWriter = new BufferedWriter(new FileWriter(args[1]));

                while (fileReader.ready()) {
                    allStr.append(fileReader.readLine());
                    allStr.append(" ");
                }
                fileReader.close();

                for (String rowStr :
                        allStr.toString().split(" ")) {
                    if (rowStr.length() > 6){
                        resultStr.append(rowStr);
                        resultStr.append(",");
                    }
                }

                fileWriter.write(resultStr.deleteCharAt(resultStr.length() - 1).toString());
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}