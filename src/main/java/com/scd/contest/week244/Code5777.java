package com.scd.contest.week244;

import java.util.Arrays;

/**
 * @author James
 */
public class Code5777 {

    public int reductionOperations(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int temp = nums[0];
        int sum = 0;
        for (int i = 1; i < len; i++) {
            int cur = nums[i];
            if (cur != temp) {
                sum = len - i + sum;
                temp = cur;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Code5777 code5777 = new Code5777();
        System.out.println(code5777.reductionOperations(new int[]{1,1,2,2,3}));
    }

}
