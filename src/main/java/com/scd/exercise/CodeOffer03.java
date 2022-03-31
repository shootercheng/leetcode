package com.scd.exercise;

import java.util.HashSet;
import java.util.Set;

/**
 * @author James
 */
public class CodeOffer03 {

    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return num;
            } else {
                set.add(num);
            }
        }
        return Integer.MAX_VALUE;
    }

    public static void main(String[] args) {

    }
}
