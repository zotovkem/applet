package com.javarush.task.task20.task2025;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args)
    {
        long memoryStart = Runtime.getRuntime().freeMemory();
        long startTime = System.currentTimeMillis();

        System.out.println(Arrays.toString(getNumbers(912985154)));

        long estimatedTime = System.currentTimeMillis() - startTime;
        long memoryEnd = Runtime.getRuntime().freeMemory();
        long estimatedMemory = memoryStart - memoryEnd;
        System.out.println("Время подсчета: " + (double) estimatedTime / 1000 + " c");
        System.out.println("Использованная память: " + (double)estimatedMemory / 1024 / 1024 + " МБ");
    }


    public static int[] getNumbers(long N) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        long[][] pws = new long[10][11];//таблица степеней
        for (int i = 0; i < 10; i++)
        {
            long pw = 1;
            for (int j = 1; j < 11; j++)
            {
                pw = pw * i;
                pws[i][j] = pw;
            }
        }

        int[] symbols = new int[10];
        for (int i = 0; i < N; i++)
        {
            int value = i;
            int lastSym = -1;
            int length = 0;
            boolean uselessNumber = false;
            while (value != 0)//разбираю число на цифры
            {
                int sym = value % 10;
                if (sym < sym % 10)//отсекаю ненужные варианты
                {
                    uselessNumber = true;
                    break;
                }
                lastSym = sym;
                symbols[length] = sym;
                value = value / 10;
                length++;
            }

            if (uselessNumber){continue;}

            int res = 0;//вычисляю сумму степеней цифр
            for (int num = 0; num < length; num++)
            {
                res += pws[symbols[num]][length];
            }
            if (res >= N || res < 0)//отсекаю все суммы не укладывающиеся в диапазон
            {
                continue;
            }
            value = res;
            length = 0;
            while (value != 0)//разбираю полученную сумму степеней цифр на цифры
            {
                symbols[length] = value % 10;
                value = value / 10;
                length++;
            }
            int res2 = 0;
            for (int num = 0; num < length; num++)//опять вычисляю сумму степененй цифр
            {
                res2 += pws[symbols[num]][length];
            }
            if (res == res2 && (!list.contains(res)))//сравниваю две суммы степеней цифр и, если они равны, то это нужное число
            {
                list.add(res);
            }
        }
        int[] ret = new int[list.size()];
        for (int i = 0; i < list.size(); i++)//перекладываю найденные числа Армстронга в массив
        {
            ret[i] = list.get(i);
        }
        Arrays.sort(ret);//сортирую массив
        return ret;
    }
}
