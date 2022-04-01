package com.scd.exercise.y2022.m4.easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 2032. 至少在两个数组中出现的值
 * @author James
 */
public class Code2032 {

    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        Set<Integer> set1 = createSet(nums1);
        Set<Integer> set2 = createSet(nums2);
        Set<Integer> set3 = createSet(nums3);
        Set<Integer> result = new HashSet<>();
        findResult(set1, set2, result);
        findResult(set1, set3, result);
        findResult(set2, set3, result);
        return new ArrayList<>(result);
    }

    private void findResult(Set<Integer> set1, Set<Integer> set2, Set<Integer> result) {
        for (Integer integer : set1) {
            if (set2.contains(integer)) {
                result.add(integer);
            }
        }
    }

    private Set<Integer> createSet(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        return set;
    }
}
