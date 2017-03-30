package com.javarush.test.level05.lesson09.task05;

/**
 * Created by e.zotov.kmr on 19.11.2016.
 */
class Salary2
{
    int value = 1000;
    Salary2()
    {

    }
    Salary2(Salary2 x)
    {
        x.value = x.value * 3;
        this.value+=1;
    }
    public static void main(String args[])
    {
        Salary2 s1 = new Salary2();
        Salary2 s2 = new Salary2(s1);
        System.out.println("s1.value=" +s1.value);
        System.out.println("s2.value="+s2.value);
    }
}