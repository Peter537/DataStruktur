package main.queue.examples;

import main.queue.Queue;
import main.queue.QueueImpl;

public class QueueExample {

    public static void main(String[] args) {
        Queue<String> queue = new QueueImpl<>();
        System.out.println("isEmpty before: " + queue.isEmpty());

        queue.enqueue("one");
        queue.enqueue("two");
        queue.enqueue("three");

        System.out.println("isEmpty after: " + queue.isEmpty());
        System.out.println("Queue size: " + queue.size());
        System.out.println("Queue content:");
        for (String s : queue) {
            System.out.println(s);
        }

        System.out.println("Peek: " + queue.peek());
        System.out.println("Dequeue: " + queue.dequeue());
        System.out.println("Peek: " + queue.peek());
        System.out.println("Queue size: " + queue.size());
        System.out.println("Queue content:");
        for (String s : queue) {
            System.out.println(s);
        }
    }
}