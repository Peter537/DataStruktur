package main.queue;

public interface Queue<E> extends Iterable<E> {

    /**
     * Information about the queue
     */
    int size();

    default boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Modification of the queue
     */
    void enqueue(E element);

    E dequeue();

    E peek();
}