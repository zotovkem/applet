package com.javarush.test.level15.lesson12.home05;

/* Перегрузка конструкторов
1. В классе Solution создайте по 3 конструктора для каждого модификатора доступа.
2. В отдельном файле унаследуйте класс SubSolution от класса Solution.
3. Внутри класса SubSolution создайте конструкторы командой Alt+Insert -> Constructors.
4. Исправьте модификаторы доступа конструкторов в SubSolution так, чтобы они соответствовали конструкторам класса Solution.
*/

public class Solution {
    public Solution(){}
    public Solution(String i){}
    public Solution(boolean i){}

    Solution(int i,int ii){}
    Solution(String i,String ii){}
    Solution(boolean i,boolean ii){}

    protected Solution(int i,int ii, int iii){}
    protected Solution(String i,String ii, String iii){}
    protected Solution(boolean i,boolean ii, boolean iiii){}

    private Solution(Object i){}
    private Solution(Double i){}
    private Solution(Character i){}

}

