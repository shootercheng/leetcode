package com.scd.exercise;

/**
 * @author James
 */
public class CodeOffer53 {

    public int missingNumber(int[] nums) {
        boolean[] booleans = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            booleans[nums[i]] = true;
        }
        for (int i = 0; i < booleans.length; i++) {
            if (!booleans[i]) {
                return i;
            }
        }
        return 0;
    }
}
