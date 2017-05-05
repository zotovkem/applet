package com.javarush.task.task19.task1904;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = "c:\\1.txt";
        try {
            fileName = reader.readLine();
            reader.close();
            System.out.println(new PersonScannerAdapter(new Scanner(new FileInputStream(fileName))).read());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static class PersonScannerAdapter implements PersonScanner {

        private Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException {
            String[] arrPerson = new String[6];
            arrPerson = this.fileScanner.next().split(" ");
            this.fileScanner.close();
            return new Person(arrPerson[0], arrPerson[1], arrPerson[2], new Date(arrPerson[3] + arrPerson[4] + arrPerson[5]));
        }

        @Override
        public void close() throws IOException {
            this.fileScanner.close();

        }
    }
}
