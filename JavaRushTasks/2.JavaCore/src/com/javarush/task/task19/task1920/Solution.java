package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        HashMap<String, Double> amountList = new HashMap<>();
        double maxAmount = 0;
        StringBuilder allStr = new StringBuilder();

        try {
            FileReader fileReader = new FileReader(args[0]);
            while (fileReader.ready()) {
                char[] arrBuf = new char[256];
                fileReader.read(arrBuf);
                allStr.append(arrBuf);
            }
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String lineStr :
                allStr.toString().split(System.lineSeparator())) {
            String[] wordStr = lineStr.split(" ");
            String secondName = wordStr[0].trim().replaceAll("\\s", "");
            double amount = Double.parseDouble(wordStr[1].trim());
            if (amountList.containsKey(secondName)) {
                amount = amount + amountList.get(secondName);
                amountList.replace(secondName, amount);
            } else
                amountList.put(secondName, amount);

            if (amount > maxAmount)
                maxAmount = amount;
        }
        for (Map.Entry<String, Double> entry :
                amountList.entrySet()) {
            if (entry.getValue() == maxAmount)
                System.out.println(entry.getKey());
        }


    }
}
