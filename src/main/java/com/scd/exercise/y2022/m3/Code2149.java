package com.scd.exercise.y2022.m3;

import java.util.ArrayList;
import java.util.List;

/**
 * @author James
 */
public class Code2149 {

    public int[] rearrangeArray(int[] nums) {
        List<Integer> less = new ArrayList<>();
        List<Integer> more = new ArrayList<>();
        for (int num : nums) {
            if (num < 0) {
                less.add(num);
            } else {
                more.add(num);
            }
        }
        int lenn = nums.length;
        int[] result = new int[lenn];
        int index = 0;
        for (int i = 0; i < lenn; i = i + 2) {
            result[i] = more.get(index);
            result[i+1] = less.get(index);
            index++;
        }
        return result;
    }
}
