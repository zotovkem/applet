package com.javarush.test.level15.lesson12.home04;

/**
 * Created by admin on 01.02.2017.
 */
public class Earth implements Planet
{
    private static Earth instance;

    private Earth(){}
    public static Earth getInstance()
    {
        if (Solution.thePlanet == null)
        {
            instance = new Earth();
        }
        return instance;
    }
}
