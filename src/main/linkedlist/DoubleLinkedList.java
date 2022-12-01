package main.linkedlist;

public interface DoubleLinkedList<T> extends LinkedList<T> {

    /**
     * Information about the list
     */
    T peekLast();

    /**
     * Modification of the list
     */
    void addLast(T element);

    T removeLast();
}