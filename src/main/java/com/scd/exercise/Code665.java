package com.scd.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * @author James
 */
public class Code665 {

    public boolean checkPossibility(int[] nums) {
        int len = nums.length;
        int count = 0;
        for (int i = 0; i < len - 1; i++) {
            if (nums[i] < nums[i+1]) {
                count++;
                if (count > 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
