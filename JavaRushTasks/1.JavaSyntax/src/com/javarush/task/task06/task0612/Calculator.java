package com.javarush.task.task06.task0612;

/* 
Калькулятор
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Calculator {
    public static int plus(int a, int b) {
        //напишите тут ваш код
        return a+b;
    }

    public static int minus(int a, int b) {
        //напишите тут ваш код
        return a-b;
    }

    public static int multiply(int a, int b) {
        //напишите тут ваш код
        return a*b;
    }

    public static double division(int a, int b) {
        //напишите тут ваш код
        return (double) a/b;
    }

    public static double percent(int a, int b) {
        //напишите тут ваш код
        return ((double) a/100)*(double) b;
    }

    public static void main(String[] args) {

    }
}