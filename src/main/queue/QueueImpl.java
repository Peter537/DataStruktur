package main.queue;

import main.linkedlist.DoubleLinkedList;
import main.linkedlist.DoubleLinkedListImpl;

import java.util.Iterator;

public class QueueImpl<E> implements Queue<E> {

    private final DoubleLinkedList<E> queue;

    public QueueImpl() {
        this.queue = new DoubleLinkedListImpl<>();
    }

    @Override
    public int size() {
        return getQueue().size();
    }

    @Override
    public void enqueue(E element) {
        getQueue().addLast(element);
    }

    @Override
    public E dequeue() {
        return getQueue().removeFirst();
    }

    @Override
    public E peek() {
        return getQueue().peekFirst();
    }

    private DoubleLinkedList<E> getQueue() {
        return this.queue;
    }

    @Override
    public Iterator<E> iterator() {
        return getQueue().iterator();
    }
}