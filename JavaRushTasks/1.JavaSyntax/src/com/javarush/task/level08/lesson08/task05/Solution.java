package com.javarush.test.level08.lesson08.task05;

import java.util.HashMap;
import java.util.Map;

/* Удалить людей, имеющих одинаковые имена
Создать словарь (Map<String, String>) занести в него десять записей по принципу «фамилия» - «имя».
Удалить людей, имеющих одинаковые имена.
*/

public class Solution
{
    public static void main(String[] args)
    {
        HashMap<String, String> map = new HashMap<String, String>();
        map = createMap();
        removeTheFirstNameDuplicates(map);
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
        map.put("Petrov","Vit");
        map.put("Sergeev","Serg");
        return map;
    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map)
    {
        //напишите тут ваш код
        HashMap<String, String> copy = new HashMap<String, String>(map);
        int count = 0;
        for (Map.Entry<String, String> pair: copy.entrySet())
        {
            count = 0;
            for (Map.Entry<String, String> pair2: copy.entrySet())
                if (pair2.getValue().equals(pair.getValue()))
                    count++;
            if (count>1)
                removeItemFromMapByValue(map,pair.getValue());
        }
    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value)
    {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair: copy.entrySet())
        {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
        System.out.println("*****************");
        for (Map.Entry<String, String> pair2: map.entrySet())
            System.out.println(pair2.getValue());
    }
}
