package com.javarush.task.task20.task2025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) {
        long memoryStart = Runtime.getRuntime().freeMemory();
        long startTime = System.currentTimeMillis();

//        System.out.println(getPowSumm(912985153));
        System.out.println(Arrays.toString(getNumbers(912985154)));

        long estimatedTime = System.currentTimeMillis() - startTime;
        long memoryEnd = Runtime.getRuntime().freeMemory();
        long estimatedMemory = memoryStart - memoryEnd;
        System.out.println("Время подсчета: " + (double) estimatedTime / 1000 + " c");
        System.out.println("Использованная память: " + (double) estimatedMemory / 1024 / 1024 + " МБ");
    }


    public static long[] getNumbers(long N) {
        long n = 0;

        TreeSet<Long> set = new TreeSet<>();

        while (n < N) {

            if (n % 10 != 9) {
                n++;
            }
            else n = filtr(n);
            if (n < N) {
                int nLength = (n + "").length();
                int NLength = (N + "").length();

                long sumPow = getPowSumm(n);
                if (sumPow < N)//проверяю, что summPow все еще меньше чем N. Необходимо при подаче на вход метода Long.MAX_VALUE
                {
                    if (isArmstrongNum(nLength, sumPow, N)) {
                        set.add(sumPow);
                    }

                    long tempN = n;
                    int tempNLength = (tempN + "").length();
                    for (int i = 0; i < NLength - tempNLength; i++) {
                        tempN = tempN * 10;
                        if (tempN < N && tempN > 0)//проверяю, что tempN все еще меньше чем N и не ушла в отриц область.
                        // Необходимо при подаче на вход метода Long.MAX_VALUE
                        {
                            tempNLength = (tempN + "").length();
                            sumPow = getPowSumm(tempN);
                            if (isArmstrongNum(tempNLength, sumPow, N)) {
                                set.add(sumPow);
                            }
                        }

                    }
                }
            }
        }
        long[] result = new long[set.size()];
        int i=0;
        for (long numb :
                set) {
            result[i++] = numb;
        }
        return result;
    }

    private static long getPowSumm(long n) {
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
        long sum=0;
        int extend=0;
        for (long i = n; i > 0 ; i/=10) {extend++;}
        for (long i = n; i > 0 ; i/=10) {
            sum+=pws[(int)(i%10)][extend];
        }
        return sum;
    }

    public static Long filtr(long N){
        long newN;
        int Nlength = (N + "").length();

        long tempN = N / 10 + 1L;
        //заменяем все нули на пробелы, потом убираем пробелы в конце
        //заменяеи оставшиеся пробелы на нули (если есть)
        String str = (tempN + "").replace("0", " ").trim().replace(" ","0");
        //проверяем не увеличилась ли разрядность
        if (Nlength < (N + 1 + "").length())
            Nlength++;
        while (str.length() < Nlength)
            str += str.substring(str.length() - 1);

        //пришлось воспользоваться данной конструкцией. по другому не придумал.
        //если str превышает Long.MAX_VALUE, то выскакивает исключение. его обрабатываем
        try {
            newN = Long.parseLong(str);
        }
        catch (NumberFormatException e){
            newN = Long.MAX_VALUE;
        }

        return newN;
    }

    public static boolean isArmstrongNum(int currentNLenght, long sumPow, long maxN){
        boolean isArmstrongNum = false;

        if (sumPow < maxN
                && sumPow == getPowSumm(sumPow)
                && (sumPow + "").length() == currentNLenght){
            isArmstrongNum = true;
        }

        return isArmstrongNum;
    }
}
