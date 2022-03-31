package com.scd.exercise;

/**
 * @author James
 */
public class Code1385 {

    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int count = 0;
        int len1 = arr1.length;
        int len2 = arr2.length;
        for (int i = 0; i < len1; i++) {
            boolean isLess = false;
            for (int j = 0; j < len2; j++) {
                if (Math.abs(arr1[i] - arr2[j]) <=d ) {
                    isLess = true;
                }
            }
            if (!isLess) {
                count++;
            }
        }
        return count;
    }
}
