package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = "c:\\1.txt";
        try {
            fileName = reader.readLine();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<String> contentFile = readToList(fileName);
        String productId = args[1];
        if (args[0].equals("-u")) {
            String productName = "";
            for (int i = 2; i < args.length - 2; i++) {
                productName += args[i] + " ";
            }
            String productPrice = args[args.length - 2];
            String productQuality = args[args.length - 1];

            contentFile.set(findListInd(contentFile, productId), spaseFilling(productId, 8) + spaseFilling(productName, 30) + spaseFilling(productPrice, 8) + spaseFilling(productQuality, 4));
            listToFile(contentFile, fileName);
        } else if (args[0].equals("-d")) {
            contentFile.remove(findListInd(contentFile,productId));
            listToFile(contentFile,fileName);
        }
    }

    private static ArrayList<String> readToList(String fileName) {
        ArrayList<String> contentFile = new ArrayList<>();
        BufferedReader inputStream = null;
        try {
            inputStream = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
            while (inputStream.ready()) {
                contentFile.add(inputStream.readLine());
            }
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contentFile;
    }

    private static void listToFile(ArrayList<String> contentFile, String fileName) {
        PrintWriter outputStream = null;
        try {
            outputStream = new PrintWriter(new FileWriter(fileName));
            for (String str : contentFile) {
                outputStream.println(str);
            }
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String spaseFilling(String str, int countSpace) {
        StringBuilder result = new StringBuilder();
        if (str.length() >= countSpace)
            result = new StringBuilder(str.substring(0, countSpace));
        else {
            result = new StringBuilder(str);
            while (result.length() < countSpace) {
                result.append(" ");
            }
        }
        return result.toString();
    }

    private static int findListInd(ArrayList<String> contentFile, String productId) {
        int listIndex = 0;

        for (String str :
                contentFile) {
            if (str.substring(0,8).trim().equals(productId)) {
                listIndex = contentFile.indexOf(str);
            }
        }
        return listIndex;
    }
}
