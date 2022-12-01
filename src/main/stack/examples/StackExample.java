package main.stack.examples;

import main.stack.Stack;
import main.stack.StackImpl;

public class StackExample {

    public static void main(String[] args) {
        Stack<String> stack = new StackImpl<>();
        System.out.println("isEmpty before: " + stack.isEmpty());

        stack.push("one");
        stack.push("two");
        stack.push("three");

        System.out.println("isEmpty after: " + stack.isEmpty());
        System.out.println("Stack size: " + stack.size());
        System.out.println("Stack content:");
        for (String s : stack) {
            System.out.println(s);
        }

        System.out.println("Peek: " + stack.peek());
        System.out.println("Pop: " + stack.pop());
        System.out.println("Peek: " + stack.peek());

        System.out.println("Stack size: " + stack.size());
        System.out.println("Stack content:");
        for (String s : stack) {
            System.out.println(s);
        }
    }
}