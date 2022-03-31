package com.scd.plan.data;

import java.util.Arrays;

/**
 * @author James
 */
public class ExMergeTwo {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            nums1[m+i] = nums2[i];
        }
        Arrays.sort(nums1);
    }
}
