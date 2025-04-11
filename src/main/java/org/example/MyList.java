package org.example;

public interface MyList<T> {
    void add(T item);
    void addFirst(T item);
    void addLast(T item);
    void add(int index, T item);

    T get(int index);
    T getFirst();
    T getLast();

    void set(int index, T item);
    void remove(int index);
    void removeFirst();
    void removeLast();

    void clear();
    int size();

    boolean exists(Object o);
    int indexOf(Object o);
    int lastIndexOf(Object o);

    Object[] toArray();
    void sort();

    java.util.Iterator<T> iterator();
}
