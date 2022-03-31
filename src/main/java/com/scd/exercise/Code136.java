package com.scd.exercise;

import java.util.HashSet;
import java.util.Set;

/**
 * @author James
 */
public class Code136 {

    public int singleNumber(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.contains(num)) {
                set.add(num);
            } else {
                set.remove(num);
            }
        }
        if (set.size() > 0) {
            return set.iterator().next();
        }
        return 0;
    }

    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        set.add(1);
    }
}
