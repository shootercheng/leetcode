package com.scd.exercise.y2022.m3;

import java.util.HashSet;
import java.util.Set;

/**
 * 2176. 统计数组中相等且可以被整除的数对
 * @author James
 */
public class Code2176 {

    public int countPairs(int[] nums, int k) {
        Set<String> set = new HashSet<>();
        int lenn = nums.length;
        int count = 0;
        for (int i = 0; i < lenn; i++) {
            for (int j = 0; j < lenn; j++) {
                if (nums[i] == nums[j] && i != j) {
                    String key = i < j ? i + "_" + j : j + "_" + i;
                    if (!set.contains(key)) {
                        if ((i * j) % k == 0) {
                            count++;
                            set.add(key);
                        }
                    }
                }
            }
        }
        return count;
    }
}
