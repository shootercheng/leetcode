package com.scd.exercise.y2022.m5;

import java.util.HashMap;
import java.util.Map;

/**
 * @author James
 */
public class Code2190 {

    public int mostFrequent(int[] nums, int key) {
        int lenn = nums.length;
        Map<Integer, Integer> countMap = new HashMap<>();
        int maxCount = 0;
        int maxTarget = 0;
        for (int i = 0; i < lenn; i++) {
            if (nums[i] == key && i+1 < lenn) {
                Integer count = countMap.computeIfAbsent(nums[i+1], k -> 0);
                countMap.put(nums[i+1], ++count);
                if (count > maxCount) {
                    maxCount = count;
                    maxTarget = nums[i+1];
                }
            }
        }
        return maxTarget;
    }

    public static void main(String[] args) {
        Code2190 code2190 = new Code2190();
        code2190.mostFrequent(new int[]{1,100,200,1,100,1,2,2,2}, 1);
    }
}
