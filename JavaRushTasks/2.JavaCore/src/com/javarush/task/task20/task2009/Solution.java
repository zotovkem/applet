package com.javarush.task.task20.task2009;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/*
Как сериализовать static?
*/
public class Solution {
    public static class ClassWithStatic implements Serializable {
        public static String staticString = "it's test static string";
        public int i;
        public int j;

        public static void deserializeStaticState(ObjectOutputStream os) throws IOException {
            os.writeObject(staticString);
        }

        public static void serializeStaticState(ObjectInputStream os) throws IOException {
            try {
                staticString = (String) os.readObject();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        public static void main(String[] args) {

        }
    }
}