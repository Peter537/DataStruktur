package main.linkedlist.examples;

import main.linkedlist.LinkedList;
import main.linkedlist.LinkedListImpl;

public class LinkedListExample {

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedListImpl<>();
        list.addFirst("one");
        list.addFirst("two");
        list.addFirst("three");

        System.out.println("List size: " + list.size());
        for (String s : list) {
            System.out.println(s);
        }

        System.out.println("First element: " + list.peekFirst());

        LinkedList<Integer> list2 = new LinkedListImpl<>();
        list2.addFirst(1);
        list2.addFirst(2);
        list2.addFirst(3);
        list2.addFirst(4);

        System.out.println("List size: " + list2.size());
        for (Integer i : list2) {
            System.out.println(i);
        }

        System.out.println("Removed first element: " + list2.removeFirst());

        System.out.println("List size: " + list2.size());
        for (Integer i : list2) {
            System.out.println(i);
        }

        System.out.println("Element at index 0: " + list2.get(0));
        System.out.println("Element at index 1: " + list2.get(1));
        System.out.println("Element at index 2: " + list2.get(2));
        System.out.println("Element at index 4: " + list2.get(3)); // IndexOutOfBoundsException
    }
}