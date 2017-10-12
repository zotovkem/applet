package com.javarush.task.task20.task2026;

import java.util.HashMap;
import java.util.Map;

/*
Алгоритмы-прямоугольники
*/
public class Solution {
    public static void main(String[] args) {
        byte[][] a = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0}
        };
        int count = getRectangleCount(a);
        System.out.println("count = " + count + ". Должно быть 2");
    }

    public static int getRectangleCount(byte[][] a) {
        Map<Integer, Integer> rectangle = new HashMap<>();
        int beginCoordinatesX = -1;
        int beginCoordinatesY = -1;
        int endCoordinatesX = -1;
        int endCoordinatesY = -1;
        boolean isRectangle = false;
        int coutRectangle = 0;
        byte element = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                element = a[i][j];
                if (element == 1) {//найден прямоугольник
                    if (beginCoordinatesY < 0 && beginCoordinatesX < 0) {
                        beginCoordinatesY = i;
                        beginCoordinatesX = j;
                    }
                    int jj = j+1 > 3 ? 3 : j+1;
                    int ii = i+1 > 3 ? 3 : i+1;
                    element = a[i][jj];
                    if (element == 0) {
                        endCoordinatesX = j;
                    }else if (jj == 3) {
                        endCoordinatesX = 3;
                    }
                    element = a[ii][j];
                    if (element == 0) {
                        endCoordinatesY = i;
                    }else if (ii == 3) {
                        endCoordinatesY = 3;
                    }
                }
                //Если все координаты заполнены считаем счетчик
                if (beginCoordinatesX >= 0 && beginCoordinatesY >= 0
                        && endCoordinatesX >= 0 && endCoordinatesY >= 0) {
                    coutRectangle++; // считаем прямоугольник
//                    исключаем прямоугольник из поиска
                    for (int ii = beginCoordinatesY; ii <=endCoordinatesY ; ii++) {
                        for (int jj = beginCoordinatesX; jj <=endCoordinatesX; jj++) {
                            a[ii][jj] = 2;
                        }
                    }
//                    скидываем счетчики для повторного поиска
                    i = 0;
                    j = 0;
                    beginCoordinatesX = -1;
                    beginCoordinatesY = -1;
                    endCoordinatesX = -1;
                    endCoordinatesY = -1;
                }
            }
        }
        return coutRectangle;
    }
}
