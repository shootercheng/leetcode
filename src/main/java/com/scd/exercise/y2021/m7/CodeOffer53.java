package com.scd.exercise.y2021.m7;

import java.util.HashMap;
import java.util.Map;

/**
 * @author James
 */
public class CodeOffer53 {
    public int search(int[] nums, int target) {
        int lenn = nums.length;
        int startIndex = -1;
        for (int i = 0; i < lenn; i++) {
            if (nums[i] == target) {
                startIndex = i;
                break;
            }
        }
        int endIndex = -1;
        for (int i = lenn - 1; i > 0; i--) {
            if (nums[i] == target) {
                endIndex = i;
                break;
            }
        }
        if (startIndex == -1 && endIndex == -1) {
            return 0;
        }
        return endIndex - startIndex + 1;
    }
}
