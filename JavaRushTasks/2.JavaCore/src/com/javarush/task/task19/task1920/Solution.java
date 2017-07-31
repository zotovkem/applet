package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) {
        try {
            FileReader fileReader = new FileReader(args[0]);
            HashMap<String, Double> amountList = new HashMap<>();
            double maxAmount = 0;
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
                if (amountList.containsKey(secondName)) {
                    amount = amount + amountList.get(secondName);
                    amountList.replace(secondName, amount);
                }
                else
                    amountList.put(secondName, amount);

                if (amount > maxAmount)
                    maxAmount = amount;
            }
            for (Map.Entry<String, Double> entry :
                    amountList.entrySet()) {
                if (entry.getValue() == maxAmount)
                    System.out.println(entry.getKey());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
