package com.scd.exercise.y2022.m5.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author James
 */
public class Code6064 {

    public int maxConsecutive(int bottom, int top, int[] special) {
        Set<Integer> specSet = new HashSet<>();
        for (int num : special) {
            specSet.add(num);
        }
        int max = Integer.MIN_VALUE;
        int count = 0;
        for (int i = bottom; i <= top; i++) {
            if (!specSet.contains(i)) {
                count++;
            } else {
                if (count > max) {
                    max = count;
                }
                count = 0;
            }
        }
        if (count > max) {
            max = count;
        }
        return max;
    }

    public int maxConsecutive2(int bottom, int top, int[] special) {
        Arrays.sort(special);
        int max = 0;
        if (bottom < special[0]) {
            int count = special[0] - bottom;
            if (count > max) {
                max = count;
            }
        }
        int lens = special.length;
        int temp = special[0];
        for (int i = 1; i < lens; i++) {
            int cur = special[i];
            int count = cur - temp - 1;
            if (count > max) {
                max = count;
            }
            temp = cur;
        }
        if (top > special[lens - 1]) {
            int count = top - special[lens - 1];
            if (count > max) {
                max = count;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Code6064 code6064 = new Code6064();
        code6064.maxConsecutive2(1,1000000000, new int[]{4,6});
    }
}
