package com.javarush.task.task19.task1924;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();

    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");

    }

    public static void main(String[] args) {
        StringBuilder allStr = new StringBuilder();
        String fileName = null;
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            fileName = reader.readLine();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (fileName.length() > 0) {
            try {
                BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
                while (fileReader.ready()) {
                    int i = fileReader.read();
                    allStr.append((char) i);
                }
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            String resultStr = "";
            for (String rowStr :
                    allStr.toString().split(" ")) {
                String resultRowStr = "";
                for (Map.Entry<Integer, String> rowMap : map.entrySet()) {
                    if (rowMap.getKey().toString().trim().equals(rowStr)) {
                        resultRowStr = rowStr.replaceAll(rowMap.getKey().toString().trim(), rowMap.getValue());
                        break;
                    }
                }
                resultStr += " " + (resultRowStr.length() > 0 ? resultRowStr : rowStr);
            }
            System.out.print(resultStr.trim());
        }

    }
}
