package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
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
        ArrayList<Integer> arg = new ArrayList<>();
        String operator = "";
        String[] nu = outputStream.toString().split(" ");
        for (String s : nu) {
            if (s.matches("[+-]?\\d+")) { //если число - true
                arg.add(Integer.valueOf(s));
            } else {
                if (s.equals("=")) break;
                else operator = s;
            }
        }
        String result = "";
        if (operator.equals("+"))
            result = result+(arg.get(0) + arg.get(1));
        else if (operator.equals("-"))
            result = result+(arg.get(0) - arg.get(1));
        else if (operator.equals("*"))
            result = result+(arg.get(0) * arg.get(1));

        System.out.println( outputStream.toString().replaceAll(System.getProperty("line.separator"),"") + result);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

