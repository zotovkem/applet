package com.javarush.task.task31.task3113;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/* 
Что внутри папки?
*/
public class Solution extends SimpleFileVisitor<Path> {
    private static int countFiles = 0;
    private static int countDir = 0;
    private static int weightFiles = 0;
//    private static int weightDirs = 0;


    public static void main(String[] args) throws IOException {
        Solution searchFileVisitor = new Solution();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Path dir = Paths.get(reader.readLine());

        if (!Files.isDirectory(dir)) {
            System.out.println(dir.toAbsolutePath().toString() + " - не папка");
            return;
        }
        Files.walkFileTree(dir, searchFileVisitor);
        System.out.println("Всего папок - " + (countDir-1));
        System.out.println("Всего файлов - " + countFiles);
        System.out.println("Общий размер - " + weightFiles);
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        countDir++;
        return super.preVisitDirectory(dir, attrs);
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        countFiles++;
        weightFiles += Files.size(file);
        return super.visitFile(file, attrs);
    }
}
