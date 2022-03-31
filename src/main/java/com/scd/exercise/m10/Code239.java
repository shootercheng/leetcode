package com.scd.exercise.m10;

import java.util.ArrayList;
import java.util.List;

/**
 * @author James
 */
public class Code239 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int nlen = nums.length;
        List<Integer> maxList = new ArrayList<>();
        for (int i=0; i < nlen - k + 1; i++) {
            int max = Integer.MIN_VALUE;
            for (int j=i; j < i+k; j++) {
                if (nums[j] > max) {
                    max = nums[j];
                }
            }
            maxList.add(max);
        }
        int lenMax = maxList.size();
        int[] result = new int[lenMax];
        for (int i = 0; i < lenMax; i++) {
            result[i] = maxList.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        Code239 code239 = new Code239();
        int[] nums = {1,3,-1,-3,5,3,6,7};
        code239.maxSlidingWindow(nums, 3);
    }
}
