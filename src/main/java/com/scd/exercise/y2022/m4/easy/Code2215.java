package com.scd.exercise.y2022.m4.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author James
 */
public class Code2215 {

    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = createSet(nums1);
        Set<Integer> set2 = createSet(nums2);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        result.add(list1);
        result.add(list2);
        set1.forEach(num -> {
            if (!set2.contains(num)) {
                list1.add(num);
            }
        });
        set2.forEach(num -> {
            if (!set1.contains(num)) {
                list2.add(num);
            }
        });
        return result;
    }

    private Set<Integer> createSet(int[] nums1) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums1) {
            set.add(num);
        }
        return set;
    }
}
