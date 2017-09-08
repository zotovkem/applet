package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) {
        BufferedReader readFirstFile = null;
        BufferedReader readSecondFile = null;
        List<String> firstReadList = null;
        List<String> secondReadList = null;
        LineItem record = null;
        int count = 0;

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            readFirstFile = new BufferedReader(new FileReader(reader.readLine()));
            readSecondFile = new BufferedReader(new FileReader(reader.readLine()));
            reader.close();
            firstReadList = readFirstFile.lines().collect(Collectors.toList());
            secondReadList = readSecondFile.lines().collect(Collectors.toList());
            readFirstFile.close();
            readSecondFile.close();

            count = firstReadList.size() > secondReadList.size() ? firstReadList.size() : secondReadList.size();
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; i < count; i++) {
            if (i + 1 > firstReadList.size()) {
                firstReadList.add("      ");
            } else if (i + 1 > secondReadList.size()) {
                secondReadList.add("      ");
            } else if (!(firstReadList.get(i).equals(secondReadList.get(i)))) {
                if (firstReadList.get(i).equals(secondReadList.get(i + 1))) {
                    firstReadList.add(i, "      ");
                } else {
                    secondReadList.add(i, "      ");
                }
                count = firstReadList.size() > secondReadList.size() ? firstReadList.size() : secondReadList.size();
            }
        }

        for (int i = 0; i < count; i++) {
            if (firstReadList.get(i).equals(secondReadList.get(i))) {
                record = new LineItem(Type.SAME, firstReadList.get(i));
            } else if (secondReadList.get(i).equals("      ")) {
                record = new LineItem(Type.REMOVED, firstReadList.get(i));
            } else if (firstReadList.get(i).equals("      ")) {
                record = new LineItem(Type.ADDED, secondReadList.get(i));
            }
            lines.add(record);
        }
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
