package com.javarush.task.task07.task0718;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Проверка на упорядоченность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            list.add(reader.readLine());
        }
        int failInd = -1;
        for (int i = 0; i < list.size(); i++) {
            if (i>0 && list.get(i).length() < list.get(i-1).length()) {
                failInd = i;
                break;
            }
        }
        if (failInd>-1) {
            System.out.println(failInd);
        }
    }
}

