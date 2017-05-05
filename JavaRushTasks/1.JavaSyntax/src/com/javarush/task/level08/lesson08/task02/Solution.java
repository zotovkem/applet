package com.javarush.test.level08.lesson08.task02;

import java.util.*;

/* Удалить все числа больше 10
Создать множество чисел(Set<Integer>), занести туда 20 различных чисел.
Удалить из множества все числа больше 10.
*/

public class Solution
{
    public static HashSet<Integer> createSet()
    {
        //напишите тут ваш код
        HashSet<Integer> set = new HashSet<Integer>(Arrays.asList(1,2,3,4,5,6,78,9,231,234,35,54,23,8,33,22,11,44,77,99));
        return set;

    }

    public static HashSet<Integer> removeAllNumbersMoreThan10(HashSet<Integer> set)
    {
        //напишите тут ваш код
        HashSet<Integer> set2 = new HashSet<Integer>();
        for (Integer a : set)
            if (a <=10)
                set2.add(a);
    return set2;
    }
}
