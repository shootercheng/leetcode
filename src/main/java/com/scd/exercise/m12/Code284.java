package com.scd.exercise.m12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author James
 */
public class Code284 {

    class PeekingIterator implements Iterator<Integer> {
        private List<Integer> list = new ArrayList<>();

        private int moveIndex = 0;

        public PeekingIterator(Iterator<Integer> iterator) {
            // initialize any member here.
            while (iterator.hasNext()) {
                list.add(iterator.next());
            }
        }

        // Returns the next element in the iteration without advancing the iterator.
        public Integer peek() {
            return list.get(moveIndex);
        }

        // hasNext() and next() should behave the same as in the Iterator interface.
        // Override them if needed.
        @Override
        public Integer next() {
            int element = list.get(moveIndex);
            moveIndex++;
            return element;
        }

        @Override
        public boolean hasNext() {
            return moveIndex < list.size();
        }
    }
}
