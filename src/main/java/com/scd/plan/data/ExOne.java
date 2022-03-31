package com.scd.plan.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author James
 */
public class ExOne {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, List<Integer>> numIndexMap = new HashMap<>(16);
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            List<Integer> indexList = numIndexMap.get(nums[i]);
            if (indexList == null) {
                indexList = new ArrayList<>();
                numIndexMap.put(nums[i], indexList);
            }
            indexList.add(i);
        }
        int[] result = new int[2];
        for (int i = 0; i < len; i++) {
            int other = target - nums[i];
            List<Integer> indexList = numIndexMap.get(other);
            if (indexList != null) {
                Integer index = Integer.valueOf(i);
                indexList.remove(index);
                if (indexList.size() > 0) {
                    result[0] = i;
                    result[1] = indexList.get(0);
                    return result;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ExOne exOne = new ExOne();
        exOne.twoSum(new int[]{3,3,3}, 6);
    }
}
