package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.*;

/*
Построй дерево(1)
*/
public class CustomTree extends AbstractList implements Cloneable, Serializable {
    public static void main(String[] args) throws UnsupportedOperationException {
        CustomTree list = new CustomTree();
        for (int i = 1; i < 16; i++) {
            list.add(String.valueOf(i));
        }

        while (list.iterator.hasNext()) {
            System.out.println(((Entry) list.iterator.next()).elementName);
        }

//        System.out.println("Expected 3, actual is " + ((CustomTree) list).getParent("8"));
        list.remove("5");
        //System.out.println("Expected null, actual is " + ((CustomTree) list).getParent("11"));
    }

    //Корень дерева
    Entry<String> root = new Entry("0");
    Iterator iterator = new EntryIterator();
    Entry<String> last;
    int size = 0;

    //Итератор дерева
    class EntryIterator implements Iterable<Entry>, Iterator<Entry> {
        private Entry current;
        private Entry last;
        int nextIndex = 0;

        public EntryIterator() {
            this.current = CustomTree.this.root;
        }

        public Iterator<Entry> iterator() {
            return this;
        }

        public boolean hasNext() {
            return nextIndex < CustomTree.this.size;
        }

        public Entry next() {
            LinkedList linkedList = new LinkedList();
            linkedList.poll()
            nextIndex++;
            if (current.parent != null) {
                //Переход между ветками
                if (current.parent.leftChild.equals(current)) {
                    current = current.parent.rightChild;


                    return current;
                }
                //Шаги по ветке дерева.
                if (current.parent.rightChild.equals(current)) {
                    if (last != null){
                        if (!last.availableToAddLeftChildren) {
                            current = last.leftChild;
                            last = current;
                            return current;
                        }}
                    last = current;
                    current = current.parent.leftChild.leftChild;
                    return current;
                }
            }
            //Вывод чилдов рута
            if (!current.availableToAddLeftChildren) {
                current = current.leftChild;
                return current;
            }
            if (!current.availableToAddRightChildren) {
                current = current.rightChild;
            }
            return current;
        }
    }

    //Встроенный класс Entry. Узды дерева.
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
        Entry parent = root.isAvailableToAddChildren() ? root : getLastElement(root.leftChild);
//        Entry parent = getLastElement(root);
        //Заполняем сам узел.
        Entry entry = new Entry(elementName);
        if (!root.availableToAddRightChildren || !root.availableToAddLeftChildren)
            if (!last.parent.isAvailableToAddChildren()) {
                entry.lineNumber = parent.lineNumber + 1;
                parent = getLastElement(root.leftChild);
            }

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
        //
        last = entry;
        size++;
    }

    private Entry getLastElement(Entry entry) {
        if (entry.isAvailableToAddChildren()) {
            return entry;
        } else {
            if (entry.parent.rightChild.isAvailableToAddChildren()) {
                return entry.parent.rightChild;
            } else {
                return getLastElement(entry.leftChild);
            }
        }
//        return root;
    }

    public String getParent(String elementName) {
        Entry entry = new Entry(elementName);
        return walkTheTree(entry).parent.elementName;
    }

    private Entry walkTheTree(Entry entry) {
        Entry entryStart = root;
        while (!entryStart.isAvailableToAddChildren()) {
            if (!entryStart.availableToAddLeftChildren) entryStart = entryStart.leftChild;
            if (entryStart.elementName.equals(entry.elementName)) return entryStart;
        }
        while (!entryStart.isAvailableToAddChildren()) {
            if (!entryStart.availableToAddRightChildren) entryStart = entryStart.rightChild;
            if (entryStart.elementName.equals(entry.elementName)) return entryStart;
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
