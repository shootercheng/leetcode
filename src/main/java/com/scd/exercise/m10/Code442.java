package com.scd.exercise.m10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author James
 */
public class Code442 {

    public List<Integer> findDuplicates(int[] nums) {
        int lenn = nums.length;
        List<Integer> result = new ArrayList<>();
        if (lenn == 0) {
            return result;
        }
        Arrays.sort(nums);
        int temp = nums[0];
        for (int i = 1; i < lenn; i++) {
            int curNum = nums[i];
            if (curNum == temp) {
                result.add(curNum);
            }
            temp = curNum;
        }
        return result;
    }
}
