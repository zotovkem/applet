package com.javarush.test.level15.lesson12.bonus02;

/**
 * Created by admin on 02.02.2017.
 */
public abstract class DrinkMaker
{
    abstract void getRightCup();
    abstract void putIngredient();
    abstract void pour();
    void makeDrink()
    {
        getRightCup();
        putIngredient();
        pour();
    }
}
