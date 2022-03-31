package com.scd.exercise;

/**
 * @author James
 */
public class Code1704 {

    public int missingNumber(int[] nums) {
        boolean[] finds = new boolean[nums.length + 1];
        for (int n : nums) {
            if (n > 0 && n <= nums.length) {
                finds[n] = true;
            }
        }
        int len = finds.length;
        for (int i = 0; i < len; i++) {
            if (!finds[i]) {
                return i;
            }
        }
        return -1;
    }
}
