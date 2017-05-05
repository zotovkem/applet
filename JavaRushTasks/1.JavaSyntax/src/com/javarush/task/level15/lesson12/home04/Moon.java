package com.javarush.test.level15.lesson12.home04;

/**
 * Created by admin on 01.02.2017.
 */
public class Moon implements Planet
{
    private static Moon instance;

    private Moon(){}

    public static Moon getInstance()
    {
        if (Solution.thePlanet == null)
        {
            instance = new Moon();
        }
        return instance;
    }
}
