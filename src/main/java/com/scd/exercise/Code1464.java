package com.scd.exercise;

import java.util.Arrays;

/**
 * @author James
 */
public class Code1464 {

    public int maxProduct(int[] nums) {
//        bubbleSort(nums);
        Arrays.sort(nums);
        int len = nums.length;
        return (nums[len - 1] - 1) * (nums[len - 2] - 1);
    }

    private void bubbleSort(int[] nums) {
        int len = nums.length;
        for (int j = 0; j < len; j++) {
            for (int i = 0; i < len - j - 1; i++) {
                if (nums[i] > nums[i + 1]) {
                    int temp = nums[i];
                    nums[i] = nums[i + 1];
                    nums[i + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {5,4,3,2,1};
        Code1464 code1464 = new Code1464();
        code1464.bubbleSort(nums);
        System.out.println(code1464.maxProduct(nums));
    }
}
