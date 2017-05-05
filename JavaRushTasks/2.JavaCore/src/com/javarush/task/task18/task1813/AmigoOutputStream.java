package com.javarush.task.task18.task1813;

import java.io.*;
import java.security.PublicKey;

/* 
AmigoOutputStream
*/

public class AmigoOutputStream extends FileOutputStream{
    public static String fileName = "C:/1.txt";
    private FileOutputStream component;

    public static void main(String[] args) throws FileNotFoundException {
            new AmigoOutputStream(new FileOutputStream(fileName));
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        component.write(b, off, len);
    }

    @Override
    public void write(int b) throws IOException {
        component.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        component.write(b);
    }

    public AmigoOutputStream(FileOutputStream name) throws FileNotFoundException {
        super(fileName);
        this.component = name;
    }

    @Override
    public void close() throws IOException {
        String str = "JavaRush © All rights reserved.";
        component.flush();
        component.write(str.getBytes());
        component.close();
    }

    @Override
    public void flush() throws IOException {
        component.flush();
    }
}
