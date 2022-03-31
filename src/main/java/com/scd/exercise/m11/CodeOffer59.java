package com.scd.exercise.m11;

import java.util.ArrayList;
import java.util.List;

/**
 * @author James
 */
public class CodeOffer59 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int lenn = nums.length;
        if (lenn == 0) {
            return nums;
        }
        List<Integer> maxList = new ArrayList<>();
        for (int i = 0; i <= lenn - k; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i; j < i+k; j++) {
                if (nums[j] > max) {
                    max = nums[j];
                }
            }
            maxList.add(max);
        }
        int mSize = maxList.size();
        int[] result = new int[mSize];
        for (int i = 0; i < mSize; i++) {
            result[i] = maxList.get(i);
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
