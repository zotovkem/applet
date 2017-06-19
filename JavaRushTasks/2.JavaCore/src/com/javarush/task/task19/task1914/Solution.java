package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        testString.printSomething();
        System.setOut(consoleStream);
        int argA=0,argB=0;
        Pattern p = Pattern.compile("\\d");
        String str = outputStream.toString().replaceAll(System.getProperty("line.separator"),"");
        Matcher m = p.matcher(str);
        m.find();
        argA = Integer.parseInt(str.substring(m.start(),m.end()));
        m.find();
        argB = Integer.parseInt(str.substring(m.start(),m.end()));
        if (str.indexOf('+')>0)
            str = str+(argA + argB);
        else if (str.indexOf('-')>0)
            str = str+(argA - argB);
        else
            str = str+"0";
        System.out.println(str);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

