package org.example;

public class MyArrayList<T> implements MyList<T> {
    private Object[] data;
    private int size;

    public MyArrayList() {
        data = new Object[5];
        size = 0;
    }

    public void add(T item) {
        if (size == data.length) {
            increaseCapacity();
        }
        data[size++] = item;
    }

    public void addFirst(T item) {
        add(0, item);
    }

    public void addLast(T item) {
        add(item);
    }

    public void add(int index, T item) {
        if (index < 0 || index > size) {
            System.out.println("Index out of bounds");
            return;
        }
        if (size == data.length) {
            increaseCapacity();
        }
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = item;
        size++;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Index out of bounds");
            return null;
        }
        return (T) data[index];
    }

    public T getFirst() {
        return get(0);
    }

    public T getLast() {
        return get(size - 1);
    }

    public void set(int index, T item) {
        if (index < 0 || index >= size) return;
        data[index] = item;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) return;
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
    }

    public void removeFirst() {
        remove(0);
    }

    public void removeLast() {
        remove(size - 1);
    }

    public void clear() {
        data = new Object[5];
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean exists(Object o) {
        return indexOf(o) != -1;
    }

    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(o)) return i;
        }
        return -1;
    }

    public int lastIndexOf(Object o) {
        for (int i = size - 1; i >= 0; i--) {
            if (data[i].equals(o)) return i;
        }
        return -1;
    }

    public Object[] toArray() {
        Object[] result = new Object[size];
        for (int i = 0; i < size; i++) {
            result[i] = data[i];
        }
        return result;
    }

    public void sort() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                Comparable a = (Comparable) data[j];
                if (a.compareTo(data[j + 1]) > 0) {
                    Object temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }
        System.out.println("Sorted successfully");
    }

    public java.util.Iterator<T> iterator() {
        return new java.util.Iterator<T>() {
            int pos = 0;
            public boolean hasNext() {
                return pos < size;
            }
            public T next() {
                return (T) data[pos++];
            }
        };
    }

    private void increaseCapacity() {
        Object[] newData = new Object[data.length * 2];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }
}
