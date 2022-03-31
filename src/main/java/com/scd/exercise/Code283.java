package com.scd.exercise;

/**
 * @author James
 */
public class Code283 {

    public void moveZeroes(int[] nums) {
        int len = nums.length;
        int endIndex = len - 1;
        for (int i = len - 1; i >= 0; i--) {
            if (nums[i] == 0) {
                for (int j = i; j < endIndex; j++) {
                    nums[j] = nums[j + 1];
                }
                nums[endIndex--] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[] input = {0,1,0,0,0};
        Code283 code283 = new Code283();
        code283.moveZeroes(input);
        System.out.println(input);
    }
}
