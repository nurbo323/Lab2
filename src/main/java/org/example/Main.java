package org.example;

import org.example.MyLinkedList;

public class Main {
    public static void main(String[] args) {
        MyList<Integer> list = new MyLinkedList<Integer>();


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

        MyStack<Integer> stack = new MyStack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println(stack.pop());  // 30
        System.out.println(stack.peek()); // 20
        System.out.println(stack.size()); // 2
        System.out.println(stack.isEmpty()); // false

    }

}
