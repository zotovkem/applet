package com.javarush.test.level07.lesson09.task03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* Слово «именно»
1. Создай список из слов «мама», «мыла», «раму».
2. После каждого слова вставь в список строку, содержащую слово «именно».
3. Используя цикл for вывести результат на экран, каждый элемент списка с новой строки.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        ArrayList<String> arr = new ArrayList<String>();
        arr.add("мама");
        arr.add("именно");
        arr.add("мыла");
        arr.add("именно");
        arr.add("раму");
        arr.add("именно");
        for (String a: arr)
        System.out.println(a);

    }
}
