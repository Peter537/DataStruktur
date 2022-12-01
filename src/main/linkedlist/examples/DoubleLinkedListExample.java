package main.linkedlist.examples;

import main.linkedlist.DoubleLinkedList;
import main.linkedlist.DoubleLinkedListImpl;

public class DoubleLinkedListExample {

    public static void main(String[] args) {
        DoubleLinkedList<String> list = new DoubleLinkedListImpl<>();
        list.addFirst("one");
        list.addFirst("two");
        list.addFirst("three");

        list.addLast("four");

        System.out.println("List size: " + list.size());
        for (String s : list) {
            System.out.println(s);
        }

        System.out.println("First element: " + list.peekFirst());
        System.out.println("Last element: " + list.peekLast());

        System.out.println("Removed first element: " + list.removeFirst());
        for (String s : list) {
            System.out.println(s);
        }

        System.out.println("Removed last element: " + list.removeLast());
        for (String s : list) {
            System.out.println(s);
        }

        System.out.println("Element at index 0: " + list.get(0));
        System.out.println("Element at index 1: " + list.get(1));
    }
}