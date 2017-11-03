package com.javarush.task.task31.task3105;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* 
Добавление файла в архив
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName;
        String pathFileName;
        String pathZipName;
        if (args.length > 0) {
            pathFileName = args[0];
            fileName = Paths.get(pathFileName).getFileName().toString();
            pathZipName = args[1];
        } else {
            return;
        }
        ZipInputStream zipRead = new ZipInputStream(new FileInputStream(pathZipName));
        Map<ZipEntry,ByteArrayOutputStream> zipEntryMap = new HashMap<>();
        ZipEntry zipEntryFile;
        while ((zipEntryFile = zipRead.getNextEntry()) != null) {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int count;
            while ((count=zipRead.read(buffer))>0)
            {
                baos.write(buffer,0,count);
            }
            zipEntryMap.put(zipEntryFile,baos);
        }
        zipRead.closeEntry();
        zipRead.close();

        ZipOutputStream zipWrite = new ZipOutputStream(new FileOutputStream(pathZipName));
        for (Map.Entry<ZipEntry,ByteArrayOutputStream> zipEntryFileWrite:
             zipEntryMap.entrySet()) {
            if (zipEntryFileWrite.getKey().toString().equals("/new/" + fileName)) {
                zipWrite.putNextEntry(new ZipEntry("/new/" + fileName));
                Files.copy(Paths.get(pathFileName), zipWrite);
            }
            else {
                if (zipEntryFileWrite.getKey().toString().equals(fileName)){
                    zipWrite.putNextEntry(new ZipEntry("/new/" + fileName));
                    Files.copy(Paths.get(pathFileName), zipWrite);
                }
                else {
                    zipWrite.putNextEntry(new ZipEntry(zipEntryFileWrite.getKey()));
ByteArrayInputStream arr = new ByteArrayInputStream(zipEntryFileWrite.getValue().toByteArray());
                    zipEntryFileWrite.getValue().toByteArray();
                    Files.copy((Path) arr,zipWrite);
                }
            }
        }
        zipWrite.closeEntry();
        zipWrite.close();
    }
}
