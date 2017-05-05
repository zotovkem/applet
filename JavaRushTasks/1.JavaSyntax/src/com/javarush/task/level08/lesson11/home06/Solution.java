package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)
    {
        //напишите тут ваш код
        ArrayList<Human> childs = new ArrayList<>();
        childs.add(new Human("petya",true,5,new ArrayList<Human>()));
        childs.add(new Human("vasia",true,15,new ArrayList<Human>()));
        childs.add(new Human("galya",false,10,new ArrayList<Human>()));

        ArrayList<Human> parents = new ArrayList<>();
        parents.add(new Human("an",false,31,childs));
        parents.add(new Human("joni",true,30,childs));

        ArrayList<Human> grants = new ArrayList<>();
        grants.add(new Human("olya",false,70,parents));
        grants.add(new Human("serg",true,69,parents));

        grants.add(new Human("valya",false,65,parents));
        grants.add(new Human("kolya",true,64,parents));

        System.out.println(grants);
        System.out.println(parents);
        System.out.println(childs);
    }

    public static class Human
    {
        //напишите тут ваш код
        private String name;
        private boolean sex;
        private int age;
        private ArrayList<Human> children;

        public Human()
        {
            this.name=null;
            this.sex=true;
            this.age=10;
            this.children=new ArrayList<Human>();
        }

        public Human(String name, boolean sex, int age, ArrayList<Human> child)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = child;
        }
        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0)
            {
                text += ", дети: "+this.children.get(0).name;

                for (int i = 1; i < childCount; i++)
                {
                    Human child = this.children.get(i);
                    text += ", "+child.name;
                }
            }

            return text;
        }
    }

}
