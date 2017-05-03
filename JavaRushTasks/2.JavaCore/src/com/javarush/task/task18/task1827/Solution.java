package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        if (args[0].equals("-c")) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String fileName = reader.readLine();
            reader.close();

            ArrayList<String> contentFile = readToList(fileName);

            String productName = "";
            for (int i = 1; i < args.length - 2; i++) {
                productName += args[i] + " ";
            }
            String productPrice = args[args.length - 2];
            String productQuality = args[args.length - 1];
            String productId = String.valueOf(findMaxId(contentFile));
            contentFile.add(spaseFilling(productId, 8) + spaseFilling(productName, 30) + spaseFilling(productPrice, 8) + spaseFilling(productQuality, 4));

            listToFile(contentFile,fileName);
        }
    }

    private static ArrayList<String> readToList(String fileName){
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
        for (String str :contentFile) {
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
            result = new StringBuilder(str.substring(0,countSpace));
        else {
            result = new StringBuilder(str);
            while (result.length() < countSpace) {
                result.append(" ");
            }
        }
        return result.toString();
    }

    private static int findMaxId(ArrayList<String> contentFile) {
        int max;
        String deb = contentFile.get(0).substring(0, 8);
        if (contentFile.size()>0) {
            max = Integer.parseInt(contentFile.get(0).substring(0, 8).trim());
        }else{
            max = 0;
        }
        Integer id = 0;
        for (String str :contentFile) {
            id = Integer.parseInt(str.substring(0, 8).trim());
            if (id > max)
                max = id;
        }
        return ++max;
    }
}
