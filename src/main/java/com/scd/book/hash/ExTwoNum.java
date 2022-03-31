package com.scd.book.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 两数之和
 * @author James
 */
public class ExTwoNum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, List<Integer>> mapList = new HashMap<>();
        int lenn = nums.length;
        for (int i = 0; i < lenn; i++) {
            List<Integer> indexList = mapList.computeIfAbsent(nums[i], k -> new ArrayList<>());
            indexList.add(i);
        }
        int[] result = new int[2];
        for (int i = 0; i < lenn; i++) {
            int other = target - nums[i];
            List<Integer> indexList = mapList.get(other);
            if (indexList != null) {
                for (Integer index : indexList) {
                    if (index != i) {
                        result[0] = i;
                        result[1] = index;
                        return result;
                    }
                }
            }
        }
        return result;
    }
}
