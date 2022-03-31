package com.scd.exercise.dp;

/**
 * @author James
 */
public class Code53 {

    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum = sum + nums[k];
                }
                if (sum > max) {
                    max = sum;
                }
            }
        }
        return max;
    }

    public int maxSubArray2(int[] nums) {
        int len = nums.length;
        if (len < 1) {
            return -1;
        }
        int[] record = new int[len];
        record[0] = nums[0];
        for (int i = 1; i < len; i++) {
            if (record[i - 1] < 0) {
                record[i] = nums[i];
            } else {
                record[i] = record[i - 1] + nums[i];
            }
        }
        int max = Integer.MIN_VALUE;
        for (int num : record) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Code53 code53 = new Code53();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(code53.maxSubArray(nums));
        System.out.println(code53.maxSubArray2(nums));
    }
}
