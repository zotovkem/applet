package com.javarush.test.level09.lesson11.home09;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* Десять котов
Создать класс кот – Cat, с полем «имя» (String).
Создать словарь Map(<String, Cat>) и добавить туда 10 котов в виде «Имя»-«Кот».
Получить из Map множество(Set) всех имен и вывести его на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap()
    {
        //напишите тут ваш код
        HashMap<String,Cat> map = new HashMap<>();
        map.put("vaska",new Cat("vaska"));
        map.put("murka",new Cat("murka"));
        map.put("zadira",new Cat("zadira"));
        map.put("petka",new Cat("petka"));
        map.put("smetana",new Cat("smetana"));
        map.put("murzik",new Cat("murzik"));
        map.put("tom",new Cat("tom"));
        map.put("kon",new Cat("kon"));
        map.put("bik",new Cat("bik"));
        map.put("krug",new Cat("krug"));
        return map;
    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map)
    {
        //напишите тут ваш код
        HashSet<Cat> set = new HashSet<>();
        for (Map.Entry<String,Cat> cat: map.entrySet())
            set.add(cat.getValue());
        return set;
    }

    public static void printCatSet(Set<Cat> set)
    {
        for (Cat cat:set)
        {
            System.out.println(cat);
        }
    }

    public static class Cat
    {
        private String name;

        public Cat(String name)
        {
            this.name = name;
        }

        public String toString()
        {
            return "Cat "+this.name;
        }
    }


}
