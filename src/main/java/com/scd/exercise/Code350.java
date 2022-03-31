package com.scd.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * @author James
 */
public class Code350 {

    public int[] intersect(int[] nums1, int[] nums2) {
        int lens1 = nums1.length;
        int lens2 = nums2.length;
        boolean[] num1Mark = new boolean[lens1];
        boolean[] num2Mark = new boolean[lens2];
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < lens1; i++) {
            for (int j = 0; j < lens2; j++) {
                if (nums1[i] == nums2[j] && !num1Mark[i] && !num2Mark[j]) {
                    num1Mark[i] = true;
                    num2Mark[j] = true;
                    result.add(nums1[i]);
                }
            }
        }
        int rsize = result.size();
        int[] resultNum = new int[rsize];
        for (int i = 0; i < rsize; i++) {
            resultNum[i] = result.get(i);
        }
        return resultNum;
    }
}
