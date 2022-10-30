package com.scd.exercise.y2022.m6.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author James
 */
public class Code6092 {

    public int[] arrayChange(int[] nums, int[][] operations) {
        Map<Integer, Integer> numIndexMap = new HashMap<>();
        int lenn = nums.length;
        for (int i = 0; i < lenn; i++) {
            numIndexMap.put(nums[i], i);
        }
        for (int[] arr : operations) {
            int index = numIndexMap.get(arr[0]);
            nums[index] = arr[1];
            numIndexMap.put(nums[index], index);
        }
        return nums;
    }

    public static void main(String[] args) {
        Code6092 code6092 = new Code6092();
        code6092.arrayChange(new int[]{1,2}, new int[][]{{1,3},{2,1},{3,2}});
    }
}
