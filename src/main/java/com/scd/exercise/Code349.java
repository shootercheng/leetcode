package com.scd.exercise;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author James
 */
public class Code349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> resultSet = new HashSet<>();
        int len1 = nums1.length;
        int len2 = nums2.length;
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                if (nums1[i] == nums2[j]) {
                    resultSet.add(nums1[i]);
                }
            }
        }
        int[] resultArr = new int[resultSet.size()];
        Iterator<Integer> iterator = resultSet.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            resultArr[i++] = iterator.next();
        }
        return resultArr;
    }

    public int[] intersection2(int[] nums1, int[] nums2) {
        Set<Integer> numS1Set = new HashSet<>();
        for (int i : nums1) {
            numS1Set.add(i);
        }
        Set<Integer> numS2Set = new HashSet<>();
        for (int j : nums2) {
            numS2Set.add(j);
        }
        Set<Integer> result = new HashSet<>();
        for (Integer i : numS1Set) {
            if (numS2Set.contains(i)) {
                result.add(i);
            }
        }
        int[] res = new int[result.size()];
        Iterator<Integer> iterator = result.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            res[i++] = iterator.next();
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,2,3};
        int[] nums2 = {1,2,3};
        Code349 code349 = new Code349();
        int[] res = code349.intersection2(nums1, nums2);
        System.out.println(res);
    }
}
