package com.javarush.test.level05.lesson12.home02;

/* Man and Woman
1. Внутри класса Solution создай public static классы Man и Woman.
2. У классов должны быть поля: name(String), age(int), address(String).
3. Создай конструкторы, в которые передаются все возможные параметры.
4. Создай по два объекта каждого класса со всеми данными используя конструктор.
5. Объекты выведи на экран в таком формате [name + " " + age + " " + address].
*/

public class Solution
{
    public static void main(String[] args)
    {
        //создай по два объекта каждого класса тут
        Man joni = new Man("Joni","Kemerovo",25);
        Man many = new Man("Many","Belovo",30);
        Woman nasty = new Woman("Nasty","moskow",28);
        Woman dora = new Woman("Dora","Piter",23);

        //выведи их на экран тут
        System.out.println(joni.name+" "+joni.age+" "+joni.address);
        System.out.println(many.name+" "+many.age+" "+many.address);
        System.out.println(nasty.name+" "+nasty.age+" "+nasty.address);
        System.out.println(dora.name+" "+dora.age+" "+dora.address);
    }

    //добавьте тут ваши классы
    public static class Man
    {
        String name,address;
        int age;

        public Man(String name, String address, int age)
        {
            this.name = name;
            this.address = address;
            this.age = age;
        }
        public Man(String name, int age)
        {
            this.name = name;
            this.address = null;
            this.age = age;
        }

        public Man(String name, String address)
        {
            this.name = name;
            this.address = address;
            this.age = 20;
        }
        public Man(String name)
        {
            this.name = name;
            this.address = null;
            this.age = 20;
        }
        public Man()
        {
            this.name = null;
            this.address = null;
            this.age = 20;
        }


    }
    public static class Woman
    {
        String name,address;
        int age;

        public Woman(String name, String address, int age)
        {
            this.name = name;
            this.address = address;
            this.age = age;
        }
        public Woman(String name, int age)
        {
            this.name = name;
            this.address = null;
            this.age = age;
        }

        public Woman(String name, String address)
        {
            this.name = name;
            this.address = address;
            this.age = 20;
        }
        public Woman(String name)
        {
            this.name = name;
            this.address = null;
            this.age = 20;
        }
        public Woman()
        {
            this.name = null;
            this.address = null;
            this.age = 20;
        }


    }
}
