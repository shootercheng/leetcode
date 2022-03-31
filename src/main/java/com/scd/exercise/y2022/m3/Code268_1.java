package com.scd.exercise.y2022.m3;

import java.util.HashSet;
import java.util.Set;

/**
 * 268. 丢失的数字
 * @author James
 */
public class Code268_1 {

    public int missingNumber(int[] nums) {
        int lenn = nums.length;
        int[] fillArr = new int[lenn + 1];
        for (int num : nums) {
            fillArr[num] = 1;
        }
        for (int i = 0; i < lenn + 1; i++) {
            if (fillArr[i] == 0) {
                return i;
            }
        }
        return -1;
    }
}
