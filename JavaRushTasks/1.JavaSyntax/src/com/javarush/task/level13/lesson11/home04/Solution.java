package com.javarush.test.level13.lesson11.home04;

/* Запись в файл
1. Прочесть с консоли имя файла.
2. Считывать строки с консоли, пока пользователь не введет строку "exit".
3. Вывести абсолютно все введенные строки в файл, каждую строчку с новой стороки.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        OutputStream outStream = new FileOutputStream(file);
//        for (byte b: file.getBytes())
//            outStream.write(b);

        String s;
        do
        {
            s = reader.readLine();
            if (!s.equals("exit"))
                s = s + System.lineSeparator();
            for (byte b : s.getBytes())
                outStream.write(b);
        }while (!s.equals("exit"));
        outStream.close();
    }
}
