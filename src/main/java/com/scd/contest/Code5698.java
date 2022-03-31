package com.scd.contest;

/**
 * @author James
 */
public class Code5698 {

    public int minElements(int[] nums, int limit, int goal) {
        int curSum = 0;
        int lenn = nums.length;
        for (int i = 0; i < lenn; i++) {
            curSum = curSum + nums[i];
        }
        int left = goal - curSum;
        if (left < 0) {
            return -1;
        } else if (left == 0) {
            return 0;
        } else {
            return 1;
        }
    }
}
