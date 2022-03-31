package com.scd.exercise;

import java.util.Arrays;

/**
 * @author James
 */
public class Code215 {

    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        int lenn = nums.length;
        int index = lenn - k;
        return nums[index];
    }

    public static void main(String[] args) {
        Code215 code215 = new Code215();
        int[] nums = {3,2,1,5,6,4};
        System.out.println(code215.findKthLargest(nums, 2));
    }
}
