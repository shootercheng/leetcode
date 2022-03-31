package com.scd.exercise;

import java.util.HashSet;
import java.util.Set;

/**
 * @author James
 */
public class Code271 {

    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return true;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.contains(num)) {
                set.add(num);
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
