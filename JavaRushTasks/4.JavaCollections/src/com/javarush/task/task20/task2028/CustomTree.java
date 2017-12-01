package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/* 
Построй дерево(1)
*/
public class CustomTree extends AbstractList implements Cloneable, Serializable {
    public static void main(String[] args) throws UnsupportedOperationException {
        CustomTree list = new CustomTree();
        for (int i = 1; i < 16; i++) {
            list.add(String.valueOf(i));
        }
        //System.out.println("Expected 3, actual is " + ((CustomTree) list).getParent("8"));
        list.remove("5");
        //System.out.println("Expected null, actual is " + ((CustomTree) list).getParent("11"));
    }

    //Корень дерева
    Entry<String> root = new Entry("0");

    //Встроенный класс Entry
    static class Entry<T> implements Serializable {
        String elementName;
        int lineNumber;
        boolean availableToAddLeftChildren, availableToAddRightChildren;

        Entry<T> parent, leftChild, rightChild;

        public Entry(String str) {
            this.elementName = str;
            this.availableToAddLeftChildren = true;
            this.availableToAddRightChildren = true;
        }

        void checkChildren() {
            if (leftChild != null) {
                this.availableToAddLeftChildren = false;
            }
            if (rightChild != null) {
                this.availableToAddRightChildren = false;
            }
        }

        boolean isAvailableToAddChildren() {
            return availableToAddLeftChildren || availableToAddRightChildren;
        }

    }

    private int getLineNumber(Entry entry) {
        return entry.lineNumber;
    }

    private int maxLineNumber() {
        return 0;
    }


    public void add(String elementName) {
        //Если у root нет детей, добавляем ему, иначе ищем подходящий элемент.
        Entry parent = root.isAvailableToAddChildren() ? root : getLastElement(root);
        //Заполняем сам узел.
        Entry entry = new Entry(elementName);
        entry.lineNumber = parent.lineNumber + 1;
        entry.parent = parent;
        //ставим метки занятости Родителю
        if (parent.availableToAddLeftChildren) {
            parent.leftChild = entry;
        } else {
            if (parent.availableToAddRightChildren) {
                parent.rightChild = entry;
            } else {
                throw new IllegalArgumentException("У родителя нет свободных ссылок");
            }
        }
        parent.checkChildren();
        System.out.println(getParent(entry.elementName));
    }

    private Entry getLastElement(Entry entry) {
        return entry.leftChild;
    }

    public String getParent(String elementName) {
        Entry entry = root;
        while (entry.isAvailableToAddChildren()) {
            int cmp = entry.elementName.compareTo(elementName);
            if (cmp == 0) {
                return entry.parent.elementName;
            }
            if (cmp < 0){
                entry = entry.leftChild;
            }else{
                entry = entry.rightChild;
            }
        }
        return null;
    }

    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int size() {
        return 0;
    }

    public String set(int index, String element) {
        throw new UnsupportedOperationException();
    }

    public void add(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }
}
