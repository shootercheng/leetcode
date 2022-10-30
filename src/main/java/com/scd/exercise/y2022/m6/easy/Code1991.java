package com.scd.exercise.y2022.m6.easy;

/**
 * @author James
 */
public class Code1991 {

    public int findMiddleIndex(int[] nums) {
        int lenn = nums.length;
        int[] numSumArr = new int[lenn];
        int sum = 0;
        for (int i = 0; i < lenn; i++) {
            sum = sum + nums[i];
            numSumArr[i] = sum;
        }
        for (int i = 0; i < lenn; i++) {
            int left;
            if (i == 0) {
                left = sum - nums[i];
                if (left == 0) {
                    return i;
                }
            } else {
                left = sum - nums[i] - numSumArr[i - 1];
                if (left == numSumArr[i - 1]) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Code1991 code1991 = new Code1991();
        code1991.findMiddleIndex(new int[]{1,0});
    }
}
