package com.javarush.test.level08.lesson08.task04;

import javax.swing.text.html.parser.DTD;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Удалить всех людей, родившихся летом
Создать словарь (Map<String, Date>) и занести в него десять записей по принципу: «фамилия» - «дата рождения».
Удалить из словаря всех людей, родившихся летом.
*/

public class Solution
{
    public static void main(String[] args)
    {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map = createMap();
        removeAllSummerPeople(map);

    }
    public static HashMap<String, Date> createMap()
    {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Stallone", new Date("JUNE 1 1980"));
        map.put("Joni", new Date("AUGUST 31 1986"));
        map.put("An", new Date("September 4 1985"));
        map.put("Vik", new Date("MAY 31 2010"));
        map.put("Pet", new Date("December 31 2010"));
        map.put("Ivan", new Date("November 1 2010"));
        map.put("Serg", new Date("July 1 2010"));
        map.put("Vasia", new Date("October 1 2010"));
        map.put("Zorg", new Date("October 2 2010"));
        map.put("Zik", new Date("October 3 2010"));

        //напишите тут ваш код
        return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map)
    {
        //напишите тут ваш код
        for(Iterator<Map.Entry<String, Date>> it = map.entrySet().iterator(); it.hasNext(); ) {
            Map.Entry<String, Date> entry = it.next();
            if (((Date) entry.getValue()).getMonth()>=5 && ((Date) entry.getValue()).getMonth()<=7) {
                it.remove();
            }
        }
    }
}
