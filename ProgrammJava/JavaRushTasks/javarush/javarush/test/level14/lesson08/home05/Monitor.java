package com.javarush.test.level14.lesson08.home05;

/**
 * Created by e.zotov.kmr on 28.01.2017.
 */
public class Monitor implements CompItem
{
    @Override
    public String getName()
    {
        return this.getClass().getSimpleName();
    }
}
