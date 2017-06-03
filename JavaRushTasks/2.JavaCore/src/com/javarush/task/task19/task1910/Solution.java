package com.javarush.task.task19.task1910;

/* 
Пунктуация
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileSource = reader.readLine();
        String fileDestin = reader.readLine();
        reader.close();

        BufferedReader fileReader = new BufferedReader(new FileReader(fileSource));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileDestin));

        while (fileReader.ready()) {
            String data = fileReader.readLine();
            //fileWriter.write(data.replaceAll("[\\.]|[\\,]|[\\:]|[\\?]|[\\!]|[\\;]|[\\-]|\\z",""));
            fileWriter.write(data.replaceAll("[\\p{P} \\t\\n\\r]",""));
        }

        fileReader.close();
        fileWriter.close();
    }
}
