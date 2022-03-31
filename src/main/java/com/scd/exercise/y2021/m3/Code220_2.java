package com.scd.exercise.y2021.m3;

/**
 * @author James
 */
public class Code220_2 {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int lenn = nums.length;
        if (k == 0) {
            return false;
        }
        for (int i = 0; i < lenn; i = i + k) {
            int j = i + 1;
            int maxIndex = i + k;
            while (j <= maxIndex && j < lenn) {
                long subAbs = Math.abs((long) nums[i] - (long) nums[j]);
                if (subAbs <= t) {
                    return true;
                }
                j++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Code220_2 code220_2 = new Code220_2();
        int[] nums = {
                1,2,5,6,7,2,4
        };
        code220_2.containsNearbyAlmostDuplicate(nums, 4, 0);
    }
}
