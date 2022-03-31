package com.scd.exercise.m10;

/**
 * @author James
 */
public class Code706 {

    class MyHashMap {

        private int[] nums = new int[1000001];

        /** Initialize your data structure here. */
        public MyHashMap() {
            for (int i = 0; i < nums.length; i++) {
                nums[i] = -1;
            }
        }

        /** value will always be non-negative. */
        public void put(int key, int value) {
            nums[key] = value;
        }

        /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
        public int get(int key) {
            return nums[key];
        }

        /** Removes the mapping of the specified value key if this map contains a mapping for the key */
        public void remove(int key) {
            nums[key] = -1;
        }
    }

}
