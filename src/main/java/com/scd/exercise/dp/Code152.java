package com.scd.exercise.dp;

/**
 * @author James
 */
public class Code152 {

    public int maxProduct(int[] nums) {
        int lenn = nums.length;
        if (lenn == 0) {
            return 0;
        }
        if (lenn == 1) {
            return nums[0];
        }
        int oneMax = Integer.MIN_VALUE;
        for (int n : nums) {
            if (n > oneMax) {
                oneMax = n;
            }
        }
        int start = nums[0];
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < lenn; i++) {
            int next = nums[i];
            int curData = start * next;
            if (curData > max) {
                max = curData;
            }
            start = next;
        }
        return oneMax > max ? oneMax : max;
    }

    public int maxProduct2(int[] nums) {
        int lenn = nums.length;
        int[] min = new int[lenn];
        int[] max = new int[lenn];
        min[0] = nums[0];
        max[0] = nums[0];
        for (int i = 1; i < lenn; i++) {
            max[i] = Math.max(nums[i], Math.max(max[i-1] * nums[i], min[i-1] * nums[i]));
            min[i] = Math.min(nums[i], Math.min(max[i-1] * nums[i], min[i-1] * nums[i]));
        }
        int maxVal = Integer.MIN_VALUE;
        for (int m : max) {
            if (m > maxVal) {
                maxVal = m;
            }
        }
        return maxVal;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,-2,4,3};
        Code152 code152 = new Code152();
        System.out.println(code152.maxProduct(nums));
    }
}
