package com.javarush.test.level05.lesson07.task02;

/* Создать класс Cat
Создать класс Cat (кот) с пятью инициализаторами:
- Имя,
- Имя, вес, возраст
- Имя, возраст (вес стандартный)
- вес, цвет, (имя, адрес и возраст неизвестны, это бездомный кот)
- вес, цвет, адрес ( чужой домашний кот)
Задача инициализатора – сделать объект валидным. Например, если вес неизвестен, то нужно указать какой-нибудь средний вес. Кот не может ничего не весить. То же касательно возраста. А вот имени может и не быть (null). То же касается адреса: null.
*/

public class Cat
{
    //напишите тут ваш код
    private String name,color,adres;
    private int weight,age;

    public void initialize (String name)
    {
        this.name=name;
        this.weight=5;
        this.age=2;
        this.color="black";
        this.name=null;
        this.adres=null;
    }

    public void initialize (String name,int weigth,int age)
    {
        this.name=name;
        this.weight=weigth;
        this.age=age;
        this.color="black";
        this.adres=null;
    }

    public void initialize (String name,int age)
    {
        this.name=name;
        this.weight=5;
        this.age=age;
        this.color="black";
        this.adres=null;
    }
    public void initialize (int weight,String color)
    {
        this.weight=weight;
        this.color=color;
        this.age=2;
        this.name=null;
        this.adres=null;
    }

    public void initialize (int weight,String color, String adres)
    {
        this.weight=weight;
        this.color=color;
        this.adres=adres;
        this.age=2;
    }

}
