package com.javarush.test.level09.lesson06.task01;

/* Исключение при работе с числами
Перехватить исключение (и вывести его на экран), указав его тип, возникающее при выполнении кода:
int a = 42 / 0;
*/

public class Solution
{
    private int a;

    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код

        try
        {
        int s = 42/0;
            s=s+s;
        }
        catch (Exception e)
        {
            System.out.println(e.getClass());
        }

        //напишите тут ваш код

    }
}
