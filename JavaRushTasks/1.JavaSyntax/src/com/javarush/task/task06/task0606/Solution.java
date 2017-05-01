package com.javarush.task.task06.task0606;

import java.io.*;

/* 
Чётные и нечётные циферки
*/

public class Solution {

    public static int even;
    public static int odd;

    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0, num = Integer.parseInt(reader.readLine());
        while (num != 0)
        {
            if ((num % 10) % 2 == 0)
                even++;
            else
                odd++;
            num /=10;
        }
        System.out.println("Even: "+even+" Odd: "+odd);
    }
}
