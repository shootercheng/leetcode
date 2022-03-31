package com.scd.exercise.m11;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author James
 */
public class Code448 {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        int lenn = nums.length;
        List<Integer> result = new ArrayList<>();
        boolean[] finds = new boolean[lenn];
        for (int i = 0; i < lenn; i++) {
            finds[nums[i] - 1] = true;
        }
        for (int i = 0; i < lenn; i++) {
            if (!finds[i]) {
                result.add(i+1);
            }
        }
        return result;
    }
}
