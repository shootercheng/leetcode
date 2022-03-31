package com.scd.exercise;

/**
 * @author James
 */
public class Code1512 {

    public int numIdenticalPairs(int[] nums) {
        int len = nums.length;
        int count = 0;
        boolean[][] finds = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (nums[i] == nums[j] && !finds[i][j] && i != j) {
                    finds[i][j] = finds[j][i] = true;
                    count++;
                }
            }
        }
        return count;
    }
}
