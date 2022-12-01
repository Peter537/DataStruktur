package main.linkedlist;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListImpl<T> implements LinkedList<T> {

    private LinkedListNode<T> first;
    private int size;

    public LinkedListImpl() {
        this.first = null;
        this.size = 0;
    }

    @Override
    public void addFirst(T data) {
        this.first = new LinkedListNode<>(data, getFirst());
        this.size++;
    }

    @Override
    public T removeFirst() {
        if (getFirst() == null) {
            throw new NoSuchElementException("The list is empty!");
        }
        T result = getFirst().getData();
        this.first = getFirst().getNext();
        this.size--;
        return result;
    }

    @Override
    public T peekFirst() {
        if (getFirst() == null) {
            throw new NoSuchElementException("The list is empty!");
        }
        return getFirst().getData();
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size());
        }
        LinkedListNode<T> current = getFirst();
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current.getData();
    }

    @Override
    public int size() {
        return this.size;
    }

    private LinkedListNode<T> getFirst() {
        return this.first;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator<>(getFirst());
    }

    private static class LinkedListNode<T> {

        private final T data;
        private final LinkedListNode<T> next;

        public LinkedListNode(T data, LinkedListNode<T> next) {
            this.data = data;
            this.next = next;
        }

        public T getData() {
            return this.data;
        }

        public LinkedListNode<T> getNext() {
            return this.next;
        }
    }

    private static class LinkedListIterator<T> implements Iterator<T> {

        private LinkedListNode<T> current;

        public LinkedListIterator(LinkedListNode<T> first) {
            this.current = first;
        }

        private LinkedListNode<T> getCurrent() {
            return this.current;
        }

        @Override
        public boolean hasNext() {
            return getCurrent() != null;
        }

        @Override
        public T next() {
            T result = getCurrent().getData();
            this.current = getCurrent().getNext();
            return result;
        }
    }
}