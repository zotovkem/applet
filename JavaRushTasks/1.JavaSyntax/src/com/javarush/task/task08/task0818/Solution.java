package com.javarush.task.task08.task0818;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static HashMap<String, Integer> createMap() {
        //напишите тут ваш код
        HashMap<String,Integer> salary = new HashMap<>();
        salary.put("Joni",1000);
        salary.put("Doni",500);
        salary.put("Fred",100);
        salary.put("Sany",300);
        salary.put("Ed",400);
        salary.put("Ben",800);
        salary.put("Kiol",900);
        salary.put("Pol",400);
        salary.put("Zen",100);
        salary.put("Den",200);

        return salary;
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
        //напишите тут ваш код
        HashMap<String,Integer> cloneMap = (HashMap<String, Integer>) map.clone();
        for (Map.Entry<String,Integer> rec : cloneMap.entrySet()) {
            if (rec.getValue()<500)
                map.remove(rec.getKey());
        }
    }

    public static void main(String[] args) {
    removeItemFromMap(createMap());
    }
}