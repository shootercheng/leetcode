package com.scd.exercise;

import java.util.HashSet;
import java.util.Set;

/**
 * @author James
 */
public class Code268 {

    public int missingNumber(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            numSet.add(nums[i]);
        }
        for (int ele : nums) {
            numSet.remove(ele);
        }
        if (numSet.size() == 1) {
            return numSet.iterator().next();
        }
        return n;
    }

    public static void main(String[] args) {
    }
}
