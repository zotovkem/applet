package com.javarush.task.task31.task3112;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/* 
Загрузчик файлов
*/
public class Solution {

    public static void main(String[] args) throws IOException {
        Path passwords = downloadFile("http://tphelp.ru/index.php", Paths.get("C:/Temp/"));

        for (String line : Files.readAllLines(passwords)) {
            System.out.println(line);
        }
    }

    public static Path downloadFile(String urlString, Path downloadDirectory) throws IOException {
        // implement this method
        URL url = new URL(urlString);
        InputStream inputStream = url.openStream();
//        String fileName = Paths.get(url.getFile()).getFileName().toString();
        String fileName = urlString.substring(urlString.lastIndexOf("/"));

        Path tempFile = Files.createTempFile("temp-", ".tmp");
        Files.copy(inputStream, tempFile);
        inputStream.close();

        Path targetFile = Paths.get(downloadDirectory+"/"  + fileName);
//        Path targetFile = downloadDirectory.resolve(fileName);
        Files.move(tempFile, targetFile);
        return targetFile;
    }
}
