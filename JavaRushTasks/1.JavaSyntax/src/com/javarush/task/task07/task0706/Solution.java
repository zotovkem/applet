package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Улицы и дома
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader  = new BufferedReader(new InputStreamReader(System.in));
        int[] home = new int [15];
        int odd = 0,even = 0;
        for (int i = 0; i <15 ; i++) {
            home[i] = Integer.parseInt(reader.readLine());
            if (i ==0 ||i%2 ==0)
                even = even +home[i];
            else
                odd = odd + home[i];
        }
        if (odd >even)
            System.out.println("В домах с нечетными номерами проживает больше жителей.");
        else
            System.out.println("В домах с четными номерами проживает больше жителей.");
    }
}
