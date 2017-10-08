package com.javarush.task.task20.task2025;

import java.util.ArrayList;
import java.util.List;

/*
Алгоритмы-числа
*/
public class Solution {
    public static int getExtent(long N) {
        int extent = 0;
        do {
            extent++;
        } while ((N = N / 10) != 0);
        return extent;
    }

    public static int[] getArr(long N) {
        int extent = getExtent(N);
        int[] numbers = new int[extent];
        int j = 0;
        while (N != 0) {
            numbers[j++] = (int) N % 10;
            N = N / 10;
        }
        return numbers;
    }

    public static long calc(int[] numbers) {
        long result = 0;
        for (int i = 0; i < numbers.length - 1; i++) {
            result += Math.pow(numbers[i], numbers.length);
        }
        return result;
    }

    public static long[] getNumbers(long N) {
        long[] result = null;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < N; i++)
//        int i = 370;
        {
            if (calc(getArr(i)) == i) {
                res.add(i);
            }
        }
        result = new long[res.size()];
        int j = 0;
        for (Integer numb :
                res) {
            result[j++] = numb;
        }
//        result = res.toArray();
        return result;
    }


    public static void main(String[] args) {
        long a1=System.currentTimeMillis();
        long a2=Runtime.getRuntime().freeMemory();
        long[]a3=getNumbers(Long.MAX_VALUE);
        long a4=Runtime.getRuntime().freeMemory();
        long a5=System.currentTimeMillis();
        long a6=a2-a4;
        long a7=a5-a1;
        System.out.println(a2/(1024*1024));
        System.out.println(a4/(1024*1024));
        System.out.println(a6/(1024*1024));
        System.out.println((double)a7/1000);

    }
}
