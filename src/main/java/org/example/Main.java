package org.example;

public class Main {
    public static void main(String[] args) {
        MyList<Integer> list = new MyArrayList<>();

        list.add(10);
        list.add(20);
        list.add(30);
        list.addFirst(5);
        list.addLast(40);

        System.out.println("First: " + list.getFirst());   // 5
        System.out.println("Last: " + list.getLast());     // 40
        System.out.println("Size: " + list.size());        // 5

        list.removeFirst();
        System.out.println("After removeFirst, first: " + list.getFirst()); // 10

        list.sort();
        System.out.println("After sort:");
        for (int i : list) {
            System.out.print(i + " ");
        }
    }
}
