package com.javarush.test.level05.lesson07.task03;

/* Создать класс Dog
Создать класс Dog (собака) с тремя инициализаторами:
- Имя
- Имя, рост
- Имя, рост, цвет
*/

public class Dog
{
    //напишите тут ваш код
    private String name,color;
    private int heigth;

    public void initialize (String name)
    {
        this.name = name;
        this.heigth = 50;
        this.color = "standart";

    }
        public void initialize (String name,int heigth)
    {
        this.name = name;
        this.heigth = heigth;
        this.color = "standart";

    }
        public void initialize (String name,int heigth,String color)
    {
        this.name = name;
        this.heigth = heigth;
        this.color = color;

    }

}
