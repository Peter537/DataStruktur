package main.range.examples;

import main.range.Range;

public class RangeExample {

    public static void main(String[] args) {
        Range range = new Range(7, 10);
        for (Integer i : range) {
            System.out.println(i);
        }
    }
}