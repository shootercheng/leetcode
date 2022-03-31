package com.scd.exercise.m10;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author James
 */
public class Code4 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> mergeList = new ArrayList<>();
        for (int num : nums1) {
            mergeList.add(num);
        }
        for (int num : nums2) {
            mergeList.add(num);
        }
        mergeList = mergeList.stream().sorted().collect(Collectors.toList());
        int len = mergeList.size();
        int center = len / 2;
        if (len % 2 == 0) {
            return (double) (mergeList.get(center) + mergeList.get(center - 1)) / 2;
        } else {
            return mergeList.get(center);
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};
        Code4 code4 = new Code4();
        double result = code4.findMedianSortedArrays(nums1, nums2);
        System.out.println(result);
    }
}
