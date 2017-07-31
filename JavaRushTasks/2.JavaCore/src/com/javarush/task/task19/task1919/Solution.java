package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) {
        try {
            FileReader fileReader = new FileReader(args[0]);
            TreeMap<String, Double> amountList = new TreeMap<>(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o1.compareTo(o2);
                }
            });
            StringBuilder allStr = new StringBuilder();
            while (fileReader.ready()) {
                char[] arrBuf = new char[256];
                fileReader.read(arrBuf);
                allStr.append(arrBuf);
            }
            fileReader.close();
            for (String lineStr :
                    allStr.toString().split(System.lineSeparator())) {
                String[] wordStr = lineStr.split(" ");
                String secondName = wordStr[0].trim().replaceAll("\\s","");
                double amount = Double.parseDouble(wordStr[1].trim());
                if (amountList.containsKey(secondName))
                    amountList.replace(secondName, amount + amountList.get(secondName));
                else
                    amountList.put(secondName, amount);
            }
            for (Map.Entry<String, Double> entry :
                    amountList.entrySet()) {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
