package com.javarush.test.level12.lesson09.task03;

/* Fly, Move, Eat для классов Dog, Car, Duck, Airplane
Есть public интерфейсы Fly(летать), Move(передвигаться), Eat(есть).
Добавь эти интерфейсы классам Dog(собака), Car(автомобиль), Duck(утка), Airplane(самолет).
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    public interface Fly
    {
        public void fly();
    }

    public interface Move
    {
        public void move();
    }

    public interface Eat
    {
        public void eat();
    }

    public class Dog implements Eat,Move
    {
        @Override
        public void move()
        {

        }

        @Override
        public void eat()
        {

        }
    }

    public class Duck implements Eat,Move,Fly
    {
        @Override
        public void move()
        {

        }

        @Override
        public void eat()
        {

        }

        @Override
        public void fly()
        {

        }
    }

    public class Car implements Move
    {
        @Override
        public void move()
        {

        }
    }

    public class Airplane implements Move, Fly
    {
        @Override
        public void fly()
        {

        }

        @Override
        public void move()
        {

        }
    }
}
