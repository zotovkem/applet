package com.javarush.test.level08.lesson11.home09;

import java.util.*;

/* Работа с датой
1. Реализовать метод isDateOdd(String date) так, чтобы он возвращал true, если количество дней с начала года - нечетное число, иначе false
2. String date передается в формате MAY 1 2013
Не забудьте учесть первый день года.
Пример:
JANUARY 1 2000 = true
JANUARY 2 2020 = false
*/

public class Solution
{
    public static void main(String[] args)
    {
      isDateOdd("JANUARY 1 2000");
      isDateOdd("JANUARY 2 2020");
    }

    public static boolean isDateOdd(String date)
    {
        Date dt = new Date(date);
        Date ndt = new Date(dt.getYear(),0,1);
        if (((dt.getTime()-ndt.getTime())/ (24 * 60 * 60 * 1000)+1)%2==0)
            return false;
        else
            return true;
    }
}
