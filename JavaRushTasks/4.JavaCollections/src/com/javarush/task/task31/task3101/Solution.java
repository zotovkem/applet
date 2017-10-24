package com.javarush.task.task31.task3101;

import java.io.File;
import java.util.HashSet;

/*
Проход по дереву файлов
*/
public class Solution {
    public static void main(String[] args) {
        File path = new File(args[0]);

        HashSet<String> listFileName = new HashSet<>();
        for (File file :
                path.listFiles()) {
            if (file.isFile() && file.getTotalSpace() > 50) {
                listFileName.add(file.getName());
            }
            else{
                FileUtils.deleteFile(file);
            }
        }

//        listFileName.

        File resultFileAbsolutePath = new File("allFilesContent.txt");
        if (resultFileAbsolutePath.exists()) {
            FileUtils.deleteFile(resultFileAbsolutePath);
        }
        FileUtils.renameFile(new File(args[1]),resultFileAbsolutePath);

        for (String str :
                listFileName) {
            System.out.println(str);
        }

    }
}
