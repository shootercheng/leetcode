package com.scd.exercise.m11;

/**
 * @author James
 */
public class Code705 {

    class MyHashSet {
        private int[] values;

        /** Initialize your data structure here. */
        public MyHashSet() {
            values = new int[1000001];
        }

        public void add(int key) {
            values[key] = 1;
        }

        public void remove(int key) {
            values[key] = 0;
        }

        /** Returns true if this set contains the specified element */
        public boolean contains(int key) {
            return values[key] == 1;
        }
    }
}
