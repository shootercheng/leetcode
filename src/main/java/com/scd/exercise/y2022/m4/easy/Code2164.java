package com.scd.exercise.y2022.m4.easy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 2164. 对奇偶下标分别排序
 * @author James
 */
public class Code2164 {

    public int[] sortEvenOdd(int[] nums) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        int lenn = nums.length;
        for (int i = 0; i < lenn; i++) {
            if (i % 2 == 0) {
                list2.add(nums[i]);
            } else {
                list1.add(nums[i]);
            }
        }
        list1 = list1.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        list2 = list2.stream().sorted().collect(Collectors.toList());
        int[] result = new int[lenn];
        int idx = 0;
        int jdx = 0;
        for (int i = 0; i < lenn; i++) {
            if (i % 2 == 0) {
                result[i] = list2.get(idx++);
            } else {
                result[i] = list1.get(jdx++);
            }
        }
        return result;
    }
}
