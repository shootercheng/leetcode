package com.scd.contest;

/**
 * @author James
 */
public class Code5607_1 {

    public int waysToMakeFair(int[] nums) {
        int lenn = nums.length;
        if (lenn == 0) {
            return 0;
        }
        int sum1 = 0;
        int sum2 = 0;
        for (int j = 0; j < lenn; j++) {
            if (j % 2 == 0) {
                sum2 = sum2 + nums[j];
            } else {
                sum1 = sum1 + nums[j];
            }
        }
        int count = 0;
        for (int i = 0; i < lenn; i++) {
            if (i % 2 == 0) {
                if (sum2 - nums[i] == sum1) {
                    count++;
                }
            } else {
                if (sum1 - nums[i] == sum2) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {

    }
}
