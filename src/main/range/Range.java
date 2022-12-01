package main.range;

import java.util.Iterator;

public class Range implements Iterable<Integer> {

    private final int begin;
    private final int end;

    public Range(int begin, int end) {
        this.begin = begin;
        this.end = end;
    }

    public int getBegin() {
        return this.begin;
    }

    public int getEnd() {
        return this.end;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new RangeIterator(getBegin());
    }

    private class RangeIterator implements Iterator<Integer> {

        private int current;

        public RangeIterator(int begin) {
            this.current = begin;
        }

        private int getCurrent() {
            return this.current;
        }

        @Override
        public boolean hasNext() {
            return getCurrent() <= getEnd();
        }

        @Override
        public Integer next() {
            return this.current++;
        }
    }
}