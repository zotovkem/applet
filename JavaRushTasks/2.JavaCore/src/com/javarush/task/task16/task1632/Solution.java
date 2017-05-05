package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        threads.add(new MyTheads1());
        threads.add(new MyTheads2());
        threads.add(new MyTheads3());
        threads.add(new MyTheads4());
        threads.add(new MyTheads5());
    }

    public static void main(String[] args) {
        for (Thread thread: threads) {
            thread.start();
        }
    }

    public static class MyTheads1 extends Thread {
        @Override
        public void run() {
            super.run();
            while (true) {
            }
        }
    }
        public static class MyTheads2 extends Thread {
            @Override
            public void run() {
                super.run();
                while (true) {
                    if (this.isInterrupted())
                        System.out.println("InterruptedException");
                }
            }
        }

        public static class MyTheads3 extends Thread {
            @Override
            public void run() {
                super.run();
                while (true) {
                    try {
                        System.out.println("Ура");
                        sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        public static class MyTheads4 extends Thread implements Message{
            @Override
            public void run() {
                super.run();
                if (isAlive())
                    showWarning();
            }

            @Override
            public void showWarning() {
                this.interrupt();
            }
        }
        public static class MyTheads5 extends Thread {
            @Override
            public void run() {
                super.run();
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                String num;
                int sum = 0;
                try {
                    while (!(num = reader.readLine()).equals("N")) {
                        sum = sum + Integer.parseInt(num);
                    }
                    System.out.println(sum);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }