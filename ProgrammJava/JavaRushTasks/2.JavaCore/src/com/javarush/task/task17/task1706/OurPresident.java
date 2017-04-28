package com.javarush.task.task17.task1706;

public class OurPresident {
    private static OurPresident president;

    static {
        OurPresident tempPresident = new OurPresident();
        synchronized (tempPresident) {
            president = tempPresident;
        }
    }

    private OurPresident() {
    }

    public static OurPresident getOurPresident() {
        return president;

    }
}
