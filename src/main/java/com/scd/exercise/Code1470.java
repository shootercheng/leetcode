package com.scd.exercise;

/**
 * @author James
 */
public class Code1470 {

    public int[] shuffle(int[] nums, int n) {
        int[] result = new int[nums.length];
        int j = 0;
        for (int i = 0; i < n; i++) {
            result[j] = nums[i];
            result[j+1] = nums[i+n];
            j = j + 2;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2,5,1,3,4,7};
        Code1470 code1470 = new Code1470();
        code1470.shuffle(nums, 3);
        System.out.println(nums);
    }
}
