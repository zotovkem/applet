package com.javarush.test.level13.lesson11.bonus01;

/* Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
11
3
2
10
Пример вывода:
2
8
10
*/

import java.io.*;
import java.util.Set;
import java.util.TreeSet;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader inStream = new BufferedReader (new FileReader(new File (reader.readLine())));
        String  n;
        Set<Integer> set = new TreeSet<>();
        while ((n = inStream.readLine()) != null)
        if (Integer.parseInt(n)%2 == 0){
            set.add(Integer.parseInt(n));
        }
        for (Integer n1:set)
            System.out.println(n1);
    }
}
