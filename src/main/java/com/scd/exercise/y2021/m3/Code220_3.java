package com.scd.exercise.y2021.m3;

/**
 * @author James
 */
public class Code220_3 {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int lenn = nums.length;
        if (k == 0) {
            return false;
        }
        int i = 0;
        int num = lenn / k;
        int loopEnd = num * k;
        while (i < loopEnd) {
            int end = i + k;
            if (findValue(nums, t, i, end)) {
                return true;
            }
            i = i + k;
        }
        if (loopEnd != lenn - 1) {
            if (findValue(nums, t, i, lenn)) {
                return true;
            }
        }
        return false;
    }

    private boolean findValue(int[] nums, int t, int i, int end) {
        for (int j = i; j < end; j++) {
            for (int m = i; m < end; m++) {
                if (m == j) {
                    continue;
                }
                if (Math.abs((long) nums[j] - (long) nums[m]) <= t) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Code220_3 Code220_3 = new Code220_3();
        int[] nums = {
                1,2,5,6,7,2,4
        };
        System.out.println(Code220_3.containsNearbyAlmostDuplicate(nums, 4, 0));
    }
}
