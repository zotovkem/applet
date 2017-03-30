package com.javarush.task.task17.task1721;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String firstNameFile = "";
        String secondNameFile = "";
        try {
            firstNameFile = reader.readLine();
            secondNameFile = reader.readLine();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        readLineFromFile(firstNameFile, allLines);
        readLineFromFile(secondNameFile, forRemoveLines);

        try {
            new Solution().joinData();
        } catch (CorruptedDataException e) {
            e.printStackTrace();
        }
        System.out.println(allLines);
    }

    public static void readLineFromFile(String nameFile, List list) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            reader = new BufferedReader(new FileReader(nameFile));
            while (reader.ready()) {
                list.add(reader.readLine());
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void joinData() throws CorruptedDataException {
        for (String str :
                forRemoveLines) {
            if (!allLines.contains(str)) {
                allLines.clear();
                throw new CorruptedDataException();
            } else {
                allLines.remove(str);
            }

        }
    }
}
