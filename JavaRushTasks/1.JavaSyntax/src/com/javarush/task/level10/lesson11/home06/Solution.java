package com.javarush.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями. Придумай и реализуй 10 различных конструкторов для него. Каждый конструктор должен иметь смысл.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static class Human
    {
        //напишите тут ваши переменные и конструкторы
        private String name;
        private int age;
        private int weght;
        private int hegth;
        private boolean sex;
        private String prof;

        public Human()
        {
            this.name = "chel";
            this.age = 21;
            this.weght = 70;
            this.hegth = 163;
            this.sex = true;
            this.prof = null;
        }

        public Human(String name)
        {
            this();
            this.name = name;
        }

        public Human(int age)
        {
            this();
            this.age = age;
        }

        public Human(int age, int weght, int hegth)
        {
            this();
            this.age = age;
            this.weght = weght;
            this.hegth = hegth;
        }

        public Human(String name, int age, boolean sex)
        {
            this();
            this.name = name;
            this.age = age;
            this.sex = sex;
        }

        public Human(String name, String prof)
        {
            this();
            this.name = name;
            this.prof = prof;
        }

        public Human(String name, boolean sex, String prof)
        {
            this();
            this.name = name;
            this.sex = sex;
            this.prof = prof;
        }

        public Human(String name, int age, int weght, int hegth, boolean sex)
        {
            this();
            this.name = name;
            this.age = age;
            this.weght = weght;
            this.hegth = hegth;
            this.sex = sex;
        }

        public Human(int age, int weght, int hegth, boolean sex)
        {
            this();
            this.age = age;
            this.weght = weght;
            this.hegth = hegth;
            this.sex = sex;
        }

        public Human(String name, int age, int weght, int hegth, boolean sex, String prof)
        {
            this();
            this.name = name;
            this.age = age;
            this.weght = weght;
            this.hegth = hegth;
            this.sex = sex;
            this.prof = prof;
        }
    }
}
