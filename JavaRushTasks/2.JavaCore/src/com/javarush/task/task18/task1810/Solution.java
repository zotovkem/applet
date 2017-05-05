package com.javarush.task.task18.task1810;

/* 
DownloadException
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws DownloadException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = null;
        ArrayList<FileInputStream> listFile = new ArrayList<>();
            while (true) {
                String fileName = reader.readLine();
                fileInputStream = new FileInputStream(fileName);
                if (fileInputStream.available() < 1000) {
                    fileInputStream.close();
                    throw new DownloadException();
                }
                fileInputStream.close();
            }
    }

    public static class DownloadException extends Exception {

    }
}
