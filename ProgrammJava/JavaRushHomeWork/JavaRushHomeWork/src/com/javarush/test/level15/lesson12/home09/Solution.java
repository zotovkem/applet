package com.javarush.test.level15.lesson12.home09;

/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        //add your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url="";
        String[] param;
//        System.out.println("Ввод:");
        try
        {
            url = reader.readLine();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        param=url.substring(url.indexOf('?')+1,url.length()).split("&");
//        System.out.println("Вывод:");
        for (String str: param)
            System.out.print((str.contains("=") ? str.substring(0,str.indexOf('=')) : str)+" ");

        System.out.println();

        for (String str: param)
            if (str.contains("=") && str.substring(0,str.indexOf('=')).equals("obj"))
                try
                {
                    alert(Double.valueOf(str.substring(str.indexOf('=')+1,str.length())));
                }
                catch (Exception e)
                {
                    alert(str.substring(str.indexOf('=') + 1, str.length()));
                }
//                if (str.substring(str.indexOf('=')+1,str.length()).contains(".") || str.substring(str.indexOf('=')+1,str.length()).equals("1"))
//                    alert(Double.parseDouble(str.substring(str.indexOf('=')+1,str.length())));
//                else
//                    alert(str.substring(str.indexOf('=') + 1, str.length()));

    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
