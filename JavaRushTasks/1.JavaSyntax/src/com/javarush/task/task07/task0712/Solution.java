package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            list.add(reader.readLine());
        }
        int minInd = 0,maxInd = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length() > list.get(maxInd).length())
                maxInd = i;
            if (list.get(i).length()<list.get(minInd).length()) {
                minInd  = i;
            }
        }
        System.out.println(maxInd<minInd ? list.get(maxInd) : list.get(minInd));
    }
}
