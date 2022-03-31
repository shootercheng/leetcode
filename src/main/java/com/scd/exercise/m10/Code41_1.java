package com.scd.exercise.m10;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author James
 */
public class Code41_1 {

    public int firstMissingPositive(int[] nums) {
        Set<Integer> intSet = new HashSet<>();
        int max = 0;
        for (int num : nums) {
            if (num > 0) {
                intSet.add(num);
            }
            if (num > max) {
                max = num;
            }
        }
        for (int i = 1; i <= max; i++) {
            if (!intSet.contains(i)) {
                return i;
            }
        }
        return max+1;
    }

    public static void main(String[] args) {
        Code41_1 code41_1 = new Code41_1();
        code41_1.firstMissingPositive(new int[]{Integer.MAX_VALUE});
    }
}
