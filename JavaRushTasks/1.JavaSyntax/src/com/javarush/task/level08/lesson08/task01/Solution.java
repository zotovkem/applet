package com.javarush.test.level08.lesson08.task01;

import java.util.*;

/* 20 слов на букву «Л»
Создать множество строк (Set<String>), занести в него 20 слов на букву «Л».
*/

public class Solution
{
    public static HashSet<String> createSet()
    {
        //напишите тут ваш код
        HashSet<String> set = new HashSet<String>();
        set.add("лаба");
        set.add("лабашак");
        set.add("лабута");
        set.add("лавда");
        set.add("лагиза");
        set.add("лайда");
        set.add("лава");
        set.add("лаг");
        set.add("ладья");
        set.add("лай");
        set.add("ладонь");
        set.add("лак");
        set.add("лавра");
        set.add("ладан");
        set.add("лагуна");
        set.add("лавина");
        set.add("лапа");
        set.add("лен");
        set.add("лень");
        set.add("лето");
        return set;
    }
}
