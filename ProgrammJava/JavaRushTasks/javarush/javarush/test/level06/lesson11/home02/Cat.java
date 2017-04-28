package com.javarush.test.level06.lesson11.home02;

import java.util.ArrayList;

/* Статические коты
1. В классе Cat добавь public статическую переменную cats (ArrayList<Cat>).
2. Пусть при каждом создании кота (нового объекта Cat) в переменную cats добавляется этот новый кот. Создать 10 объектов Cat.
3. Метод printCats должен выводить всех котов на экран. Нужно использовать переменную cats.
*/

public class Cat {

    public static ArrayList<Cat> cats = new ArrayList();
    public Cat() {
        Cat.cats.add(this);
    }
    //напишите тут ваш код
    private String name;

    public static void main(String[] args) {
        //Создай тут 10 котов
        Cat cat[]= new Cat[10];
        for (int i = 0; i <10 ; i++)
            cat[i]=new Cat();
        printCats();
    }

    public static void printCats() {
        //Добавь свой код для пункта 3 тут
        for(Cat catField : cats)
            System.out.println(catField);
    }
}
