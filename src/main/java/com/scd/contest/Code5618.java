package com.scd.contest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author James
 */
public class Code5618 {

    public int maxOperations(int[] nums, int k) {
        int lenn = nums.length;
        int count = 0;
        boolean[] used = new boolean[lenn];
        for (int i = 0; i < lenn; i++) {
            for (int j = 1; j < lenn; j++) {
                if (i != j && !used[i] && !used[j]) {
                    if (nums[i] == k - nums[j]) {
                        used[i] = true;
                        used[j] = true;
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public int maxOperations2(int[] nums, int k) {
        int lenn = nums.length;
        int count = 0;
        Map<Integer, List<Integer>> dataIndexMap = new HashMap<>();
        for (int i = 0; i < lenn; i++) {
            List<Integer> indexList = dataIndexMap.computeIfAbsent(nums[i],  a -> new ArrayList<>());
            indexList.add(i);
        }
        boolean[] used = new boolean[lenn];
        for (int i = 0; i < lenn; i++) {
            if (!used[i]) {
                List<Integer> curList = dataIndexMap.get(nums[i]);
                if (curList != null && curList.size() > 0) {
                    curList.remove(0);
                }
                used[i] = true;
                int other = k - nums[i];
                List<Integer> indexList = dataIndexMap.get(other);
                if (indexList != null && indexList.size() > 0) {
                    count++;
                    used[indexList.get(0)] = true;
                    indexList.remove(0);
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {3,1,3,4,3};
        Code5618 code5618 = new Code5618();
        System.out.println(code5618.maxOperations2(nums, 6));
    }
}
