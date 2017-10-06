package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/
public class Solution implements Serializable {
    public static void main(String[] args) {
        ByteArrayOutputStream buf = new ByteArrayOutputStream();
        Solution savedObject = new Solution(4);
        Solution loadedObject = new Solution(5);

        try {
            ObjectOutputStream out = new ObjectOutputStream(buf);
            out.writeObject(savedObject);
            out.close();
            ByteArrayInputStream inBuf = new ByteArrayInputStream(buf.toByteArray());
            ObjectInputStream in = new ObjectInputStream(inBuf);
            loadedObject = (Solution) in.readObject();
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(savedObject + "\n" + loadedObject);
        if (loadedObject.string.equals(savedObject.string)) {
            System.out.println("eguals");
        } else {
            System.out.println("not eguals");
        }
    }

    transient private final String pattern = "dd MMMM yyyy, EEEE";
    transient private Date currentDate;
    transient private int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
