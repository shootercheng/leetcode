package com.scd.exercise;

import java.util.Arrays;

/**
 * @author James
 */
public class Code414 {

    public int thirdMax(int[] nums) {
        Arrays.sort(nums);
        int lenn = nums.length;
        if (lenn > 2) {
            int count = 0;
            for (int i = lenn - 1; i > 0; i--) {
                if (nums[i] - nums[i-1] != 0) {
                    if (++count == 2) {
                        return nums[i - 1];
                    }
                }
            }
        }
        return nums[lenn - 1];
    }

    public static void main(String[] args) {
        Code414 code414 = new Code414();
        int[] nums = {1,2,-2147483648};
        int res = code414.thirdMax(nums);
        System.out.println(res);
    }
}
