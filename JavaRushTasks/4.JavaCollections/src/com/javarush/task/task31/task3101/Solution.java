package com.javarush.task.task31.task3101;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
Проход по дереву файлов
*/
public class Solution {
    private static ArrayList<File> listFile(File path) {
        ArrayList<File> listFileName = new ArrayList<>();
        FileFilter textFilter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.getName().contains(".txt") || pathname.isDirectory();
            }
        };

        for (File file :
                path.listFiles(textFilter)) {
            if (file.isFile()) {
                listFileName.add(file);
            } else {
                if (file.isDirectory()) {
                    listFileName.addAll(listFile(new File(file.getAbsolutePath())));
                }
            }
        }
        return listFileName;
    }

    public static void main(String[] args) throws IOException {
        File path = new File(args[0]);

        File resultFileAbsolutePath = new File(args[1]);
        File destination = new File(resultFileAbsolutePath.getParent() + "/allFilesContent.txt");
        FileUtils.renameFile(resultFileAbsolutePath, destination); // Переименование файла.
        FileOutputStream writer = new FileOutputStream(destination);


        deleteBigFile(path);

        ArrayList<File> listFileName = listFile(path);

        //Сортируем массив.
        Collections.sort(listFileName, new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        //Переписываем файлы в один
        combinationFile(writer, listFileName);
        writer.close();

    }

    private static void combinationFile(FileOutputStream writer, ArrayList<File> listFileName) throws IOException {
        for (File file :
                listFileName) {
            if (file.length() <= 50) {
                FileInputStream reader = new FileInputStream(file);
                int date = 0;
                while ((date = reader.read()) != -1) {
                    writer.write(date);
                }
                reader.close();
                writer.write("\n".getBytes());
            }
        }
        //Закрываем поток для записи
        writer.close();
    }

    private static void deleteBigFile(File path) {
        //Удаляем файлы больше 50 байт.
        for (File file :
                path.listFiles()) {
            if (file.isDirectory()) deleteBigFile(file);
            if (file.length() > 50) {
                FileUtils.deleteFile(file);
            }
        }
    }
}
