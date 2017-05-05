package com.javarush.test.level15.lesson02.task04;

/* ООП - книги
1. Создайте public static класс MarkTwainBook, который наследуется от Book. Имя автора [Mark Twain]. Параметр конструктора - имя книги.
2. В классе MarkTwainBook реализуйте все абстрактные методы.
3. Для метода getBook расширьте тип возвращаемого результата.
4. Создайте по аналогии AgathaChristieBook. Имя автора [Agatha Christie].
5. В классе Book реализуйте тело метода getOutputByBookType так, чтобы он возвращал:
5.1. agathaChristieOutput для книг Агаты Кристи;
5.2. markTwainOutput для книг Марка Твена.
*/

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Solution {
    public static void main(String[] args) {
        List<Book> books = new LinkedList<Book>();
        books.add(new MarkTwainBook("Tom Sawyer"));
        books.add(new AgathaChristieBook("Hercule Poirot"));
        System.out.println(books);
    }

    public static class MarkTwainBook extends Book
    {
        private String nameBook;
        public MarkTwainBook(String nameBook)
        {
            super("Mark Twain");
            this.nameBook = nameBook;
        }

        @Override
        public MarkTwainBook getBook()
        {
            return this;
        }

        @Override
        public String getName()
        {
            return this.nameBook;
        }
    }
    public static class AgathaChristieBook extends Book
    {
        private String nameBook;
        public AgathaChristieBook(String nameBook)
        {
            super("Agatha Christie");
            this.nameBook = nameBook;
        }

        @Override
        public AgathaChristieBook getBook()
        {
            return this;
        }

        @Override
        public String getName()
        {
            return this.nameBook;
        }
    }

    public abstract static class Book {
        private String author;

        public Book(String author) {
            this.author = author;
        }

        public abstract Book getBook();

        public abstract String getName();

        private String getOutputByBookType() {
            String agathaChristieOutput = author + ", " + getBook().getName() + " is a detective";
            String markTwainOutput = getBook().getName() + " book was written by " + author;

            String output = "output";
            //Add your code here
            if (this instanceof MarkTwainBook)
                output = markTwainOutput;
            else if (this instanceof AgathaChristieBook)
                output = agathaChristieOutput;

            return output;
        }

        public String toString() {
            return getOutputByBookType();
        }
    }
}
