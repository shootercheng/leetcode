package com.scd.exercise.m11;

import java.util.Arrays;

/**
 * @author James
 */
public class Code1608 {

    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int j = 0;
        while (j <= len) {
            int index = findMinIndex(nums, j);
            if (index != -1) {
                int count = len - index;
                if (count == j) {
                    return j;
                }
            }
            j++;
        }
        return -1;
    }

    public int findMinIndex(int[] nums, int find) {
        int index = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= find) {
                index = i;
                break;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        Code1608 code1608 = new Code1608();
        System.out.println(code1608.specialArray(new int[]{3,5}));
        System.out.println(code1608.specialArray(new int[]{0,0}));
        System.out.println(code1608.specialArray(new int[]{0,4,3,0,4}));
        System.out.println(code1608.specialArray(new int[]{3,6,7,7,0}));
    }
}
