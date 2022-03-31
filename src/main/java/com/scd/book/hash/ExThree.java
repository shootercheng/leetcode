package com.scd.book.hash;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 两个数组的交集
 * @author James
 */
public class ExThree {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums1) {
            set.add(num);
        }
        Set<Integer> result = new HashSet<>();
        for (int num : nums2) {
            if (set.contains(num)) {
                result.add(num);
            }
        }
        int[] numArr = new int[result.size()];
        int index = 0;
        for (int num : result) {
            numArr[index++] = num;
        }
        return numArr;
    }
}
