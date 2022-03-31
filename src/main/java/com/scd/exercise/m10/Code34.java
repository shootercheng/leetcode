package com.scd.exercise.m10;

/**
 * @author James
 */
public class Code34 {

    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1,-1};
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] == target) {
                result[0] = i;
                break;
            }
        }
        for (int i = len - 1; i >= 0; i--) {
            if (nums[i] == target) {
                result[1] = i;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Code34 code34 = new Code34();
        int[] nums = {1,2,3,4,5};
        code34.searchRange(nums, 3);
    }
}
