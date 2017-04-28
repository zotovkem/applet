package com.javarush.test.level05.lesson09.task05;

/* Создать класс прямоугольник (Rectangle)
Создать класс прямоугольник (Rectangle). Его данными будут top, left, width, height (левая координата, верхняя, ширина и высота). Создать для него как можно больше конструкторов:
Примеры:
-	заданы 4 параметра: left, top, width, height
-	ширина/высота не задана (оба равны 0)
-	высота не задана (равно ширине) создаём квадрат
-	создаём копию другого прямоугольника (он и передаётся в параметрах)
*/

public class Rectangle
{
    //напишите тут ваш код
    private int left, top, width, height;

    public Rectangle()
    {
        this.left=10;
        this.top=20;
        this.width=0;
        this.height=0;
    }


    public Rectangle(int left)
    {
        this.left=this.top=left;
        this.width=0;
        this.height=0;
    }
    public Rectangle(int left, int top)
    {
        this.left=left;
        this.top=top;
        this.width=0;
        this.height=0;
    }

    public Rectangle(int left, int top, int width,int height)
    {
        this.left=left;
        this.top=top;
        this.width=width;
        this.height=height;
    }

    public Rectangle(int left, int top, int height)
    {
        this.left=left;
        this.top=top;
        this.width=this.height=height;
    }

    public Rectangle(Rectangle MyRec)
    {
        this.left=MyRec.left;
        this.top=MyRec.top;
        this.width=MyRec.width;
        this.height=MyRec.height;
    }

}
