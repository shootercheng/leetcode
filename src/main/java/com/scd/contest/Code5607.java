package com.scd.contest;

/**
 * @author James
 */
public class Code5607 {

    public int waysToMakeFair(int[] nums) {
        int lenn = nums.length;
        if (lenn == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < lenn; i++) {
            if (isRight(i, nums)) {
                count++;
            }
        }
        return count;
    }

    private boolean isRight(int i, int[] nums) {
        int sum1 = 0;
        int sum2 = 0;
        for (int j = 0; j < i; j++) {
            if (j % 2 == 0) {
                sum2 = sum2 + nums[j];
            } else {
                sum1 = sum1 + nums[j];
            }
        }
        for (int j = i+1; j < nums.length; j++) {
            int curIndex = j - 1;
            if (curIndex % 2 == 0) {
                sum2 = sum2 + nums[j];
            } else {
                sum1 = sum1 + nums[j];
            }
        }
        return sum1 == sum2;
    }
}
