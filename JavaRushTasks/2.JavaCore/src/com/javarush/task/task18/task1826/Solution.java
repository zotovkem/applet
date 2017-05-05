package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Solution {
    public static void main(String[] args) throws Exception{
        String fileSource = args[1];
        String fileTarget = args[2];
        FileInputStream fileInputStream = new FileInputStream(fileSource);
        FileOutputStream fileOutputStream = new FileOutputStream(fileTarget);
        while (fileInputStream.available()>0){
            if (args[0].equals("-e"))
                fileOutputStream.write(rotate((char) fileInputStream.read(),5));
            else
                fileOutputStream.write(rotate((char) fileInputStream.read(),-5));
        }
        fileInputStream.close();
        fileOutputStream.close();

    }

    public static char rotate(char c, int key) { // c must be lowercase
        String s = "abcdefghijklmnopqrstuvwxyz";
        int i = 0;
        while (i < 26) {
            // extra +26 below because key might be negative
            if (c == s.charAt(i)) return s.charAt((i + key + 26)%26);
            i++;
        }
        return c;
    }
}
