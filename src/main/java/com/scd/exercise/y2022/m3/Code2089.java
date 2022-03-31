package com.scd.exercise.y2022.m3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2089. 找出数组排序后的目标下标
 * @author James
 */
public class Code2089 {

    public List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);
        List<Integer> result = new ArrayList<>();
        int lenn = nums.length;
        for (int i = 0; i < lenn; i++) {
            if (nums[i] == target) {
                result.add(i);
            }
        }
        return result;
    }
}
