package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.Collection;
import java.util.List;

/* 
Построй дерево(1)
*/
public class CustomTree extends AbstractList implements Cloneable, Serializable {
    public static void main(String[] args) throws UnsupportedOperationException {
        List<String> list = new CustomTree();
        for (int i = 1; i < 16; i++) {
            list.add(String.valueOf(i));
        }
        //System.out.println("Expected 3, actual is " + ((CustomTree) list).getParent("8"));
        list.remove("5");
        //System.out.println("Expected null, actual is " + ((CustomTree) list).getParent("11"));
    }
    //Корень дерева

    Entry<String> root;

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

    private Entry createNewEntry(Entry parent, String elementName) {
        Entry entry = new Entry(elementName);
        entry.lineNumber = maxLineNumber();
        entry.parent = parent;
        return entry;
    }

    public void add(String elementName) {
        Entry parent = root.isAvailableToAddChildren() ? root : getLastElement(root);
        ;
        //Если у root нет детей, добавляем ему
        createNewEntry(parent, elementName);
        parent.checkChildren();
    }

    private Entry getLastElement(Entry entry) {
        return entry.leftChild;
    }

    public String getParent(String elementName) {
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
