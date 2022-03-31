package com.scd.contest;

/**
 * @author James
 */
public class Code5704 {

    public int maximumScore(int[] nums, int k) {
        int lenn = nums.length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < lenn; i++) {
            for (int j = 0; j < lenn; j++) {
                if (k >= i && k <= j) {
                    int source = calSource(i, j, nums);
                    if (source > max) {
                        max = source;
                    }
                }
            }
        }
        return max;
    }

    private int calSource(int start, int end, int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int i = start; i <= end; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
        }
        return min * (end - start + 1);
    }

    public static void main(String[] args) {
        Code5704 code5704 = new Code5704();
        code5704.maximumScore(new int[]{1,2,3,4,5}, 1);
    }
}
