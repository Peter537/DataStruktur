package main.linkedlist;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoubleLinkedListImpl<T> implements DoubleLinkedList<T> {

    private DoubleLinkedListNode<T> first;
    private DoubleLinkedListNode<T> last;
    private int size;

    public DoubleLinkedListImpl() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public T peekFirst() {
        if (getFirst() == null) {
            throw new NoSuchElementException("The list is empty!");
        }
        return getFirst().getData();
    }

    @Override
    public T peekLast() {
        if (getLast() == null) {
            throw new NoSuchElementException("The list is empty!");
        }
        return getLast().getData();
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size());
        }
        DoubleLinkedListNode<T> current;
        if (index < size() / 2) {
            current = getFirst();
            for (int i = 0; i < index; i++) {
                current = current.getNext();
            }
        } else {
            current = getLast();
            for (int i = size() - 1; i > index; i--) {
                current = current.getPrevious();
            }
        }
        return current.getData();
    }

    @Override
    public void addFirst(T data) {
        DoubleLinkedListNode<T> newNode = new DoubleLinkedListNode<>(data, getFirst(), null);
        if (getFirst() != null) {
            getFirst().setPrevious(newNode);
        }
        this.first = newNode;
        if (getLast() == null) {
            this.last = newNode;
        }
        this.size++;
    }

    @Override
    public void addLast(T data) {
        DoubleLinkedListNode<T> newNode = new DoubleLinkedListNode<>(data, null, getLast());
        if (getLast() != null) {
            getLast().setNext(newNode);
        }
        this.last = newNode;
        if (getFirst() == null) {
            this.first = newNode;
        }
        this.size++;
    }

    @Override
    public T removeFirst() {
        if (getFirst() == null) {
            throw new NoSuchElementException("The list is empty!");
        }
        T result = getFirst().getData();
        this.first = getFirst().getNext();
        if (getFirst() != null) {
            getFirst().setPrevious(null);
        }
        if (getLast() == result) {
            this.last = null;
        }
        this.size--;
        return result;
    }

    @Override
    public T removeLast() {
        if (getLast() == null) {
            throw new NoSuchElementException("The list is empty!");
        }
        T result = getLast().getData();
        this.last = getLast().getPrevious();
        if (getLast() != null) {
            getLast().setNext(null);
        }
        if (getFirst() == result) {
            this.first = null;
        }
        this.size--;
        return result;
    }

    @Override
    public Iterator<T> iterator() {
        return new DoubleLinkedListIterator<>(getFirst());
    }

    private DoubleLinkedListNode<T> getFirst() {
        return this.first;
    }

    private DoubleLinkedListNode<T> getLast() {
        return this.last;
    }

    private static class DoubleLinkedListNode<T> {

        private final T data;
        private DoubleLinkedListNode<T> next;
        private DoubleLinkedListNode<T> previous;

        public DoubleLinkedListNode(T data, DoubleLinkedListNode<T> next, DoubleLinkedListNode<T> previous) {
            this.data = data;
            this.next = next;
            this.previous = previous;
        }

        public T getData() {
            return this.data;
        }

        public DoubleLinkedListNode<T> getNext() {
            return this.next;
        }

        public DoubleLinkedListNode<T> getPrevious() {
            return this.previous;
        }

        public void setNext(DoubleLinkedListNode<T> next) {
            this.next = next;
        }

        public void setPrevious(DoubleLinkedListNode<T> previous) {
            this.previous = previous;
        }
    }

    private static class DoubleLinkedListIterator<T> implements Iterator<T> {

        private DoubleLinkedListNode<T> current;

        public DoubleLinkedListIterator(DoubleLinkedListNode<T> first) {
            this.current = first;
        }

        private DoubleLinkedListNode<T> getCurrent() {
            return this.current;
        }

        @Override
        public boolean hasNext() {
            return getCurrent() != null;
        }

        @Override
        public T next() {
            T result = getCurrent().getData();
            current = getCurrent().getNext();
            return result;
        }
    }
}