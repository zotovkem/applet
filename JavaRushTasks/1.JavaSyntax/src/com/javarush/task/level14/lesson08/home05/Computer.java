package com.javarush.test.level14.lesson08.home05;

/**
 * Created by e.zotov.kmr on 28.01.2017.
 */
public class Computer
{
    private Keyboard keyboard;
    private Monitor monitor;
    private Mouse mouse;

    public Computer()
    {
        this.keyboard = new Keyboard();
        this.monitor = new Monitor();
        this.mouse = new Mouse();
    }

    public Keyboard getKeyboard()
    {
        return keyboard;
    }

    public void setKeyboard(Keyboard keyboard)
    {
        this.keyboard = keyboard;
    }

    public Monitor getMonitor()
    {
        return monitor;
    }

    public void setMonitor(Monitor monitor)
    {
        this.monitor = monitor;
    }

    public Mouse getMouse()
    {
        return mouse;
    }

    public void setMouse(Mouse mouse)
    {
        this.mouse = mouse;
    }
}
