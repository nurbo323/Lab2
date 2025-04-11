package org.example;

public class Main {
    public static void main(String[] args) {
        MyList<Integer> list = new MyArrayList<>();

        list.add(10);
        list.add(5);
        list.add(30);
        list.addFirst(3);
        list.addLast(40);

        System.out.println("First: " + list.getFirst());  // 3
        System.out.println("Last: " + list.getLast());    // 40
        System.out.println("Size: " + list.size());       // 5

        list.removeFirst();  // удалит 3
        System.out.println("After removeFirst: " + list.getFirst()); // 10

        list.sort(); // отсортирует
        System.out.println("Sorted list:");
        for (int i : list) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
