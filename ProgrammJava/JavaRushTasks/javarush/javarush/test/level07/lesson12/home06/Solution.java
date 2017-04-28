package com.javarush.test.level07.lesson12.home06;

/* Семья
Создай класс Human с полями имя(String), пол(boolean),возраст(int), отец(Human), мать(Human). Создай объекты и заполни их так, чтобы получилось:
Два дедушки, две бабушки, отец, мать, трое детей. Вывести объекты на экран.
Примечание:
Если написать свой метод String toString() в классе Human, то именно он будет использоваться при выводе объекта на экран.
Пример вывода:
Имя: Аня, пол: женский, возраст: 21, отец: Павел, мать: Катя
Имя: Катя, пол: женский, возраст: 55
Имя: Игорь, пол: мужской, возраст: 2, отец: Михаил, мать: Аня
…
*/

public class Solution
{
    public static void main(String[] args)
    {
        //напишите тут ваш код
        Human grantFather1 = new Human("Petr",true,60,null,null);
        Human grantFather2 = new Human("Fedor",true,62,null,null);
        Human grantMother1 = new Human("Manya",false,55,null,null);
        Human grantMother2 = new Human("Galya",false,56,null,null);
        Human mother = new Human("Sveta",false,33,grantFather1,grantMother1);
        Human father = new Human("Joni",true,34,grantFather2,grantMother2);
        Human child1 = new Human("Vika",false,14,father,mother);
        Human child2 = new Human("Kolya",true,10,father,mother);
        Human child3 = new Human("Olya",false,5,father,mother);
        System.out.println(grantFather1);
        System.out.println(grantFather2);
        System.out.println(grantMother1);
        System.out.println(grantMother2);
        System.out.println(mother);
        System.out.println(father);
        System.out.println(child1);
        System.out.println(child2);
        System.out.println(child3);


    }

    public static class Human
    {
        //напишите тут ваш код
        private String name;
        private boolean sex;
        private int age;
        private Human father;
        private Human mother;

        public Human(String name, boolean sex, int age, Human father, Human mother)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }

}
