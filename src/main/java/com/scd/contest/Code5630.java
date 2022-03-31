package com.scd.contest;

import java.util.HashMap;
import java.util.Map;

/**
 * @author James
 */
public class Code5630 {

    public int maximumUniqueSubarray(int[] nums) {
        int lenn = nums.length;
        int startIndex = 0;
        int endIndex = 0;
        Map<Integer, Integer> numValIndexMap = new HashMap<>();
        int max = 0;
        int sum = 0;
        while(endIndex < lenn) {
            Integer index = numValIndexMap.get(nums[endIndex]);
            if (index == null) {
                numValIndexMap.put(nums[endIndex], endIndex);
                sum = sum + nums[endIndex];
                endIndex = endIndex + 1;
            } else {
                if (sum > max) {
                    max = sum;
                }
                sum = 0;
                startIndex = index + 1;
                endIndex = startIndex;
                numValIndexMap.clear();
            }
        }
        if (sum > max) {
            max = sum;
        }
        return max;
    }

    public static void main(String[] args) {
        Code5630 code5630 = new Code5630();
        System.out.println(code5630.maximumUniqueSubarray(new int[]{4,1,2,3,2,5,6}));
    }
}
