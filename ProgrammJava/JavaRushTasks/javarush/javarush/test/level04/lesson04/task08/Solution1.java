package com.javarush.test.level04.lesson06.task08;

/* Координатные четверти
Ввести с клавиатуры два целых числа, которые будут координатами точки, не лежащей на координатных осях OX и OY.
Вывести на экран номер координатной четверти, в которой находится данная точка.
Подсказка:
Принадлежность точки с координатами (a,b) к одной из четвертей определяется следующим образом:
для первой четверти a>0 и b>0;
для второй четверти a<0 и b>0;
для третьей четверти a<0 и b<0;
для четвертой четверти a>0 и b<0.
Пример для чисел 4 6:
1
Пример для чисел -6 -6:
3
*/


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution1
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int a=Integer.parseInt(in.readLine());
        int b=Integer.parseInt(in.readLine());
        if (a>0 && b>0)
            System.out.println(1);
        else if (a<0 && b>0)
            System.out.println(2);
        else if (a<0 && b<0)
            System.out.println(3);
        else if (a>0 && b<0)
            System.out.println(4);
    }
}
