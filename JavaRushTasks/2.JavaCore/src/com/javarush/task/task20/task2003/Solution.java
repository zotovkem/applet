package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() {
        //implement this method - реализуйте этот метод
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            InputStream inputStream = new FileInputStream(reader.readLine());
            this.load(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties prop = new Properties();
        prop.putAll(properties);
        prop.store(outputStream, "");
        outputStream.close();
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties prop = new Properties();
        prop.load(inputStream);
        inputStream.close();
        for(String name : prop.stringPropertyNames()) {
            properties.put(name, prop.getProperty(name));
        }
    }

    public static void main(String[] args) {
        properties.put("key1", "val1");
        properties.put("key2", "val2");
        Solution test = new Solution();
        try {
            test.save((OutputStream) new FileOutputStream("c:\\1.txt"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        properties.clear();
        test.fillInPropertiesMap();
        System.out.println(properties.toString());
    }
}
