package com.javarush.task.task08.task0812;

import java.io.*;
import java.util.ArrayList;

/* 
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>();
        int countInt = 1, maxCount = 1;

        for (int i = 0; i < 10; i++) {
            list.add(Integer.parseInt(reader.readLine()));
            if (i>0 && list.get(i).equals(list.get(i-1)))
                countInt++;
            else
                countInt = 1;

            if (countInt > maxCount)
                maxCount = countInt;

        }

        System.out.println(maxCount);
    }
}