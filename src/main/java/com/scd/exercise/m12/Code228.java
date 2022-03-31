package com.scd.exercise.m12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author James
 */
public class Code228 {

    public List<String> summaryRanges(int[] nums) {
        int lenn = nums.length;
        if (lenn == 0) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        List<String> resultList = new ArrayList<>();
        int startIndex = 0;
        int endIndex = 1;
        while (endIndex < lenn) {
            if (nums[endIndex] - nums[endIndex - 1] == 1) {
                endIndex = endIndex + 1;
            } else {
                if (endIndex - 1 == startIndex) {
                    resultList.add(String.valueOf(nums[startIndex]));
                } else {
                    resultList.add(nums[startIndex] + "->" + nums[endIndex - 1]);
                }
                startIndex = endIndex;
                endIndex = endIndex + 1;
            }
        }
        if (endIndex - 1 == startIndex) {
            resultList.add(String.valueOf(nums[startIndex]));
        } else {
            resultList.add(nums[startIndex] + "->" + nums[endIndex - 1]);
        }
        return resultList;
    }
}
