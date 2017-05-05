package com.javarush.test.level08.lesson08.task03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.PublicKey;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* Одинаковые имя и фамилия
Создать словарь (Map<String, String>) занести в него десять записей по принципу «Фамилия» - «Имя».
Проверить сколько людей имеют совпадающие с заданным имя или фамилию.
*/

public class Solution
{
    public static void main (String[] args) throws IOException
    {
        HashMap<String, String> map = new HashMap<String, String>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        map = createMap();
        System.out.println(getCountTheSameFirstName(map,reader.readLine()));
        System.out.println(getCountTheSameLastName(map,reader.readLine()));

    }
    public static HashMap<String, String> createMap()
    {
        //напишите тут ваш код
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("Zotov","Joni");
        map.put("Ivanov","Maks");
        map.put("Ansimov","Joni");
        map.put("Lyasin","Dima");
        map.put("Zorba","An");
        map.put("Zotova","Vika");
        map.put("Sobchenko","Vit");
        map.put("Pupkin","Vasia");
        map.put("Petrov","Petya");
        map.put("Sergeev","Serg");
        System.out.println(map.size());
        return map;

    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name)
    {
        //напишите тут ваш код
        int count=0;
        for (Map.Entry ent: map.entrySet())
        {
            if (ent.getValue().equals(name))
                count++;
        }
        return count;

    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName)
    {
        //напишите тут ваш код
        int count=0;
        for (Map.Entry ent: map.entrySet())
        {
            if (ent.getKey().equals(lastName))
                count++;
        }
        return count;
    }
}
