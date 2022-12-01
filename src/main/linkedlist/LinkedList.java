package main.linkedlist;

public interface LinkedList<T> extends Iterable<T> {

    /**
     * Information about the list
     */
    int size();

    T peekFirst();

    T get(int index);

    /**
     * Modification of the list
     */
    void addFirst(T element);

    T removeFirst();
}