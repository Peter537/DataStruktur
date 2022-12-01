package main.stack;

import main.linkedlist.LinkedList;
import main.linkedlist.LinkedListImpl;

import java.util.Iterator;

public class StackImpl<E> implements Stack<E> {

    private final LinkedList<E> stack;

    public StackImpl() {
        this.stack = new LinkedListImpl<>();
    }

    @Override
    public int size() {
        return getStack().size();
    }

    @Override
    public void push(E element) {
        getStack().addFirst(element);
    }

    @Override
    public E pop() {
        return getStack().removeFirst();
    }

    @Override
    public E peek() {
        return getStack().peekFirst();
    }

    private LinkedList<E> getStack() {
        return this.stack;
    }

    @Override
    public Iterator<E> iterator() {
        return getStack().iterator();
    }
}