package com.javarush.test.level14.lesson06.home01;


public class BelarusianHen extends Hen
{
    @Override
    int getCountOfEggsPerMonth()
    {
        return 70;
    }
    @Override
    public String getDescription()
    {
        return super.getDescription()+" Моя страна - "+Country.BELARUS+". Я несу "+this.getCountOfEggsPerMonth()+" яиц в месяц.";
    }
}
