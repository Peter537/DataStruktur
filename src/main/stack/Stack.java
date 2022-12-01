package main.stack;

public interface Stack<E> extends Iterable<E> {

    /**
     * Information about the stack
     */
    int size();

    default boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Modification of the stack
     */
    void push(E element);

    E pop();

    E peek();
}