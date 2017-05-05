package com.javarush.test.level08.lesson11.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Задача по алгоритмам
Задача: Введи с клавиатуры 20 слов и выведи их в алфавитном порядке.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] array = new String[20];
        for (int i = 0; i < array.length; i++)
        {
            array[i] = reader.readLine();
        }

        sort(array);

        for (String x : array)
        {
            System.out.println(x);
        }
    }

    public static void sort(String[] array)
    {
        //напишите тут ваш код
        //напишите тут ваш код
        for (int i = 0; i < array.length; i++) {
        /*Предполагаем, что первый элемент (в каждом
           подмножестве элементов) является максимальным */
            String max = array[i];
            int max_i = i;
        /*В оставшейся части подмножества ищем элемент,
           который больше предположенного максимума*/
            for (int j = i+1; j < array.length; j++) {
                //Если находим, запоминаем его индекс
                if (isGreaterThan(max,array[j])) {
                    max = array[j];
                    max_i = j;
                }
            }
        /*Если нашелся элемент, больше, чем на текущей позиции,
          меняем их местами*/
            if (i != max_i) {
                String tmp = array[i];
                array[i] = array[max_i];
                array[max_i] = tmp;
            }
        }
    }

    //Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b)
    {
        return a.compareTo(b) > 0;
    }
}