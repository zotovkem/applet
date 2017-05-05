package com.javarush.task.task17.task1714;

/* 
Comparable
*/

public class Beach implements Comparable<Beach> {
    private String name;      //название
    private float distance;   //расстояние
    private int quality;    //качество

    public Beach(String name, float distance, int quality) {
        this.name = name;
        this.distance = distance;
        this.quality = quality;
    }

    public synchronized String getName() {
        return name;
    }

    public synchronized void setName(String name) {
        this.name = name;
    }

    public synchronized float getDistance() {
        return distance;
    }

    public synchronized void setDistance(float distance) {
        this.distance = distance;
    }

    public synchronized int getQuality() {
        return quality;
    }

    public synchronized void setQuality(int quality) {
        this.quality = quality;
    }

    public static void main(String[] args) {
        System.out.println(new Beach("1", 3, 1).compareTo(new Beach("2", 2, 1)));

    }

    @Override
    public synchronized int compareTo(Beach o) {
        int a = (int) (getQuality()/getDistance()*100);
        int b = (int) (o.getQuality()/o.getDistance()*100);
        int c = getName().compareTo(o.getName());
        return   c+b - a;
    }
}
