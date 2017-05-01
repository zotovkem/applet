package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        if (args[0].equals("-c")) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String productName = "";
            for (int i = 1; i < args.length - 2; i++) {
                productName += args[i] + " ";
            }
            String productPrice = args[args.length - 2];
            String productQuality = args[args.length - 1];
            String fileName = reader.readLine();
            String productId = String.valueOf(findMaxId(fileName));
            reader.close();

            PrintWriter outputStream = new PrintWriter(new FileWriter(fileName, true));
            outputStream.println(spaseFilling(productId, 8) + spaseFilling(productName, 30) + spaseFilling(productPrice, 8) + spaseFilling(productQuality, 4));
            outputStream.close();
        }
    }

    private static String spaseFilling(String str, int countSpace) {
        StringBuilder result = new StringBuilder();
        if (str.length() >= countSpace)
            result = new StringBuilder(str.substring(0,countSpace));
        else {
            result = new StringBuilder(str);
            while (result.length() < countSpace) {
                result.append(" ");
            }
        }
        return result.toString();
    }

    private static int findMaxId(String fileName) throws Exception {
        BufferedReader inputStream = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        int max = 0;
        Integer id = 0;
        while (inputStream.ready()) {
            try {
                String str = inputStream.readLine().substring(0, 8).trim();
                id = Integer.parseInt(str);
            } catch (Exception e) {
                continue;
            }
            if (id > max)
                max = id;
        }
        inputStream.close();
        return ++max;
    }
}
