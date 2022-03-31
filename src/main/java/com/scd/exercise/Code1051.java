package com.scd.exercise;

import java.util.Arrays;

/**
 * @author James
 */
public class Code1051 {

    public int heightChecker(int[] heights) {
        int len = heights.length;
        int[] temp = new int[len];
        System.arraycopy(heights, 0, temp, 0, len);
        Arrays.sort(temp);
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (heights[i] != temp[i]) {
                count++;
            }
        }
        return count;
    }
}
