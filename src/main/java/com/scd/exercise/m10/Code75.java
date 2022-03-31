package com.scd.exercise.m10;

/**
 * @author James
 */
public class Code75 {

    public void sortColors(int[] nums) {

    }

    public void bbsort(int[] nums) {
        int nlen = nums.length;
        for (int j = 0; j < nlen; j++) {
            for (int i = 0; i < nlen - j - 1; i++) {
                if (nums[i] > nums[i + 1]) {
                    int temp = nums[i];
                    nums[i] = nums[i + 1];
                    nums[i + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Code75 code75 = new Code75();
        int[] input = new int[]{5,4,3,2,1};
        code75.bbsort(input);
        System.out.println(input);
    }
}
