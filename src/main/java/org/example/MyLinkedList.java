package org.example;

public class MyLinkedList<T> implements MyList<T> {
    private class MyNode {
        T data;
        MyNode next;
        MyNode prev;

        public MyNode(T data) {
            this.data = data;
        }
    }

    private MyNode head;
    private MyNode tail;
    private int size;

    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void add(T item) {
        MyNode node = new MyNode(item);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        size++;
    }

    public void addFirst(T item) {
        MyNode node = new MyNode(item);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
        size++;
    }

    public void addLast(T item) {
        add(item);
    }

    public T get(int index) {
        if (index < 0 || index >= size) return null;

        MyNode current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.data;
    }

    @Override
    public void add(int index, T item) {
        if (index < 0 || index > size) return;

        if (index == 0) {
            addFirst(item);
            return;
        }

        if (index == size) {
            addLast(item);
            return;
        }

        MyNode current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        MyNode newNode = new MyNode(item);
        newNode.prev = current.prev;
        newNode.next = current;
        current.prev.next = newNode;
        current.prev = newNode;

        size++;
    }

    public T getFirst() {
        return head != null ? head.data : null;
    }

    public T getLast() {
        return tail != null ? tail.data : null;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) return;

        MyNode current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        if (current.prev != null) {
            current.prev.next = current.next;
        } else {
            head = current.next;
        }

        if (current.next != null) {
            current.next.prev = current.prev;
        } else {
            tail = current.prev;
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
        head = null;
        tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public void set(int index, T item) {
        if (index < 0 || index >= size) return;

        MyNode current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        current.data = item;
    }

    public boolean exists(Object o) {
        MyNode current = head;
        while (current != null) {
            if (current.data.equals(o)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public int indexOf(Object o) {
        MyNode current = head;
        int index = 0;
        while (current != null) {
            if (current.data.equals(o)) return index;
            current = current.next;
            index++;
        }
        return -1;
    }

    public int lastIndexOf(Object o) {
        MyNode current = tail;
        int index = size - 1;
        while (current != null) {
            if (current.data.equals(o)) return index;
            current = current.prev;
            index--;
        }
        return -1;
    }

    public Object[] toArray() {
        Object[] arr = new Object[size];
        MyNode current = head;
        int i = 0;
        while (current != null) {
            arr[i++] = current.data;
            current = current.next;
        }
        return arr;
    }

    public void sort() {
        if (size <= 1) return;

        for (int i = 0; i < size - 1; i++) {
            MyNode current = head;
            for (int j = 0; j < size - 1 - i; j++) {
                Comparable a = (Comparable) current.data;
                if (a.compareTo(current.next.data) > 0) {
                    T temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                }
                current = current.next;
            }
        }
    }

    public java.util.Iterator<T> iterator() {
        return new java.util.Iterator<T>() {
            private MyNode current = head;

            public boolean hasNext() {
                return current != null;
            }

            public T next() {
                T val = current.data;
                current = current.next;
                return val;
            }
        };
    }
}
