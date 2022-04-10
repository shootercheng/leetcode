package com.scd.exercise.y2022.m4.medium;

/**
 * 2023. 连接后等于目标字符串的字符串对
 * @author James
 */
public class Code2023 {

    public int numOfPairs(String[] nums, String target) {
        int lenn = nums.length;
        int count = 0;
        for (int i = 0; i < lenn; i++) {
            for (int j = 0; j < lenn; j++) {
                if (i != j && (nums[i] + nums[j]).equals(target)) {
                    count++;
                }
            }
        }
        return count;
    }
}
