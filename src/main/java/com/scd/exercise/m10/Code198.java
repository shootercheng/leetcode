package com.scd.exercise.m10;

/**
 * @author James
 */
public class Code198 {

    public int rob(int[] nums) {
        int nlen = nums.length;
        if (nlen == 1) {
            return nums[0];
        } else {
            int evenSum = 0;
            int oddSum = 0;
            for (int i = 0; i < nlen; i = i + 2) {
                oddSum = oddSum + nums[i];
                if (i < nlen - 1) {
                    evenSum = evenSum + nums[i+1];
                }
            }
            if (evenSum > oddSum) {
                return evenSum;
            } else {
                return oddSum;
            }
        }
    }

    public static void main(String[] args) {
        Code198 code198 = new Code198();
        System.out.println(code198.rob(new int[]{1}));
        System.out.println(code198.rob(new int[]{1,2}));
        System.out.println(code198.rob(new int[]{1,2,3}));
        System.out.println(code198.rob(new int[]{1,2,3,8}));
    }
}
