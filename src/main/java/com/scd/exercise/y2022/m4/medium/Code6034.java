package com.scd.exercise.y2022.m4.medium;

/**
 * 6034. 数组的三角和
 * @author James
 */
public class Code6034 {

    public int triangularSum(int[] nums) {
        int loop = nums.length - 1;
        if (loop == 0) {
            return nums[0];
        }
        for (int i = 0; i < loop; i++) {
            nums = createTempNum(nums);
        }
        return nums[0];
    }

    private int[] createTempNum(int[] nums) {
        int lenn = nums.length;
        int[] temp = new int[lenn - 1];
        int index = 0;
        for (int i = 0; i < lenn - 1; i++) {
            int sum = nums[i] + nums[i+1];
            if (sum > 9) {
                sum = sum % 10;
            }
            temp[index++] = sum;
        }
        return temp;
    }
}
