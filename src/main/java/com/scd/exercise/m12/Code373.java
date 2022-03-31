package com.scd.exercise.m12;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author James
 */
public class Code373 {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        if (len1 == 0 || len2 == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> allDataList = new ArrayList<>();
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                List<Integer> oneList = new ArrayList<>();
                oneList.add(nums1[i]);
                oneList.add(nums2[j]);
                allDataList.add(oneList);
            }
        }
        allDataList = allDataList.stream().sorted(Comparator.comparingInt(this::sort))
                .collect(Collectors.toList());
        int size = allDataList.size();
        if (size > k) {
            return allDataList.subList(0, k);
        }
        return allDataList;
    }

    private int sort(List<Integer> list) {
        return list.get(0) + list.get(1);
    }
}
