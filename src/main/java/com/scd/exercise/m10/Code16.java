package com.scd.exercise.m10;

/**
 * @author James
 */
public class Code16 {

    public int threeSumClosest(int[] nums, int target) {
        int nlen = nums.length;
        int dis = Integer.MAX_VALUE;
        int minSum = 0;
        for (int i = 0; i < nlen - 2; i++) {
            int sum = nums[i] + nums[i+1] + nums[i+2];
            int curDis = Math.abs(sum - target);
            if (curDis < dis) {
                dis = curDis;
                minSum = sum;
            }
        }
        return minSum;
    }

    public static void main(String[] args) {
        int[] nums = {-1,2,1,-4};
        Code16 code16 = new Code16();
        System.out.println(code16.threeSumClosest(nums, 0));
    }
}
