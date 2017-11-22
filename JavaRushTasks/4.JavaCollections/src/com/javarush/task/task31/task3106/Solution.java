package com.javarush.task.task31.task3106;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.SequenceInputStream;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/*
Разархивируем файл
*/
public class Solution {
    public static void main(String[] args) {
        if (args.length <= 0) {
            System.out.println("Не заданы параметры");
            return;
        }
        File resultFile = new File(args[0]);
        try {
            //Создаем поток на каждый файл
            int filePartCount = args.length - 1;
            String[] fileNamePart = new String[filePartCount];
            for (int i = 0; i < filePartCount; i++) {
                fileNamePart[i] = args[i + 1];
            }
            Arrays.sort(fileNamePart);

            List<FileInputStream> fisList = new ArrayList<>();
            for (int i = 0; i < filePartCount; i++) {
                fisList.add(new FileInputStream(fileNamePart[i]));
            }
            //Сливаем все потоки в комбинированный поток
            SequenceInputStream sis = new SequenceInputStream(Collections.enumeration(fisList));
            //Разархивируем
            ZipInputStream zis = new ZipInputStream(sis);
            ZipEntry zipEntry;
            FileOutputStream fos = new FileOutputStream(resultFile);
            while ((zipEntry = zis.getNextEntry()) != null) {
                int length;
                byte[] buffer = new byte[1024];
                while ((length = zis.read(buffer)) != -1){
                    fos.write(buffer,0, length);
                }
            }
            zis.closeEntry();
            zis.close();
            fos.close();
            sis.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
