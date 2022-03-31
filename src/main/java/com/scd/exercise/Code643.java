package com.scd.exercise;

/**
 * @author James
 */
public class Code643 {

    public double findMaxAverage(int[] nums, int k) {
        int lenn = nums.length;
        int max = 0;
        int loop = lenn - k;
        boolean isInitMax = false;
        for (int i = 0; i <= loop; i++) {
            int calSum = calSum(i, k, nums);
            if (!isInitMax) {
                max = calSum;
                isInitMax = true;
            } else {
                if (calSum > max) {
                    max = calSum;
                }
            }
        }
        return max / k;
    }

    private int calSum(int i, int k, int[] nums) {
        int sum = 0;
        int loop = i + k;
        for (int j = i; j < loop; j++) {
            sum = sum + nums[j];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6};
        Code643 code643 = new Code643();
        System.out.println(code643.findMaxAverage(nums, 1));
    }
}
