package com.scd.exercise.y2022.m4.easy;

/**
 * 剑指 Offer II 069. 山峰数组的顶部
 * @author James
 */
public class CodeOffer069 {

    public int peakIndexInMountainArray(int[] arr) {
        int lena = arr.length;
        int max = 0;
        for (int i = 0; i < lena - 1; i++) {
            if (arr[i] < arr[i+1]) {
                max = i+1;
            } else {
                break;
            }
        }
        return max;
    }
}
