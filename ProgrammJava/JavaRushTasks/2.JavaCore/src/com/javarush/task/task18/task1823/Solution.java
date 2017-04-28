package com.javarush.task.task18.task1823;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        while (!(str = reader.readLine()).equals("exit")) {
            ReadThread thread = new ReadThread(str);
            thread.start();
        }
    }

    public static class ReadThread extends Thread {
        private FileInputStream fileInStream;
        private String fileName;

        public ReadThread(String fileName) {
            //implement constructor body
            this.fileName = fileName;
            try {
                fileInStream = new FileInputStream(fileName);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            long[] arrBytes = new long[256];
            long fileSize = 0;
            try {
                byte arrayFile[] = new byte[fileInStream.available()];
                fileSize = arrayFile.length;
                fileInStream.read(arrayFile);
                fileInStream.close();

                for (int i = 0; i < fileSize; i++) arrBytes[arrayFile[i] & 0b11111111]++;
            } catch (Exception e) {
                e.printStackTrace();
            }

            long max = 0;
            int  idMax = 0;

            for (int i = 0; i < 256; i++) {
                if (arrBytes[i] > max) {
                    max = arrBytes[i];
                    idMax = i;
                }
            }
            resultMap.put(this.fileName,idMax);
            // implement file reading here - реализуйте чтение из файла тут
        }
    }
}
