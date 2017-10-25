package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/* 
Находим все файлы
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        PriorityQueue<File> queueFile = new PriorityQueue<File>();
        List<String> resList = new ArrayList<String>();
        queueFile.add(new File(root));
        while (!queueFile.isEmpty()) {
            File file = queueFile.poll();
            for (File recFile :
                    file.listFiles()) {
                if (recFile.isDirectory()) {
                    queueFile.add(recFile);
                }
                if (recFile.isFile()) {
                    resList.add(recFile.getAbsolutePath());
                }
            }
        }
        return resList;

    }

    public static void main(String[] args) throws IOException {
        for (String str :
                getFileTree("c:\\Temp")) {
            System.out.println(str);
        }
    }
}
