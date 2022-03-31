package com.scd.exercise.y2021.m1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author James
 */
public class Code341 {

    public class NestedIterator implements Iterator<Integer> {
        private int moveIndex;

        private List<Integer> intList;

        public NestedIterator(List<NestedInteger> nestedList) {
            moveIndex = 0;
            intList = new ArrayList<>();
            for (NestedInteger nestedInteger : nestedList) {
                createNestedList(nestedInteger, intList);
            }
        }

        public void createNestedList(NestedInteger nestedInteger, List<Integer> intList) {
            if (!nestedInteger.isInteger()) {
                List<NestedInteger> nestedList = nestedInteger.getList();
                for (NestedInteger newNestInteger : nestedList) {
                    createNestedList(newNestInteger, intList);
                }
            } else {
                intList.add(nestedInteger.getInteger());
            }
        }

        @Override
        public Integer next() {
            int curInt = intList.get(moveIndex);
            moveIndex++;
            return curInt;
        }

        @Override
        public boolean hasNext() {
            return moveIndex < intList.size();
        }
    }
}
