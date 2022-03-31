package com.scd.book.hash;

/**
 * @author James
 */
public class ExfourSumCount {

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int lenn = nums1.length;
        int count = 0;
        for (int i = 0; i < lenn; i++) {
            for (int j = 0; j < lenn; j++) {
                for (int k = 0; k < lenn; k++) {
                    for (int l = 0; l < lenn; l++) {
                        if (nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }
}
