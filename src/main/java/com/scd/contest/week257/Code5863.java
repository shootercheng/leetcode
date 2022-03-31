package com.scd.contest.week257;

/**
 * @author James
 */
public class Code5863 {
    public int countQuadruplets(int[] nums) {
        int len = nums.length;
        int count = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                for (int k = j; k < len; k++) {
                    for (int l = k; l < len; l++) {
                        if (nums[i] + nums[j] + nums[k] == nums[l]
                                && i < j && j < k && k < l) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }
}
