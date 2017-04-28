package com.javarush.task.task05.task0507;

/* 
Среднее арифметическое
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a,sum = 0,kol=0;
        while ((a = Integer.parseInt(reader.readLine()))!=-1)
        {
            sum = sum + a;
            kol++;
        }
        System.out.println((double) sum/kol);
    }
}

