package com.scd.exercise.y2022.m3;

import java.util.ArrayList;
import java.util.List;

/**
 * @author James
 */
public class Code2161 {

    public int[] pivotArray(int[] nums, int pivot) {
        List<Integer> less = new ArrayList<>();
        List<Integer> more = new ArrayList<>();
        List<Integer> equal = new ArrayList<>();
        for (int num : nums) {
            if (num < pivot) {
                less.add(num);
            } else if (num == pivot) {
                equal.add(num);
            } else {
                more.add(num);
            }
        }
        int[] result = new int[nums.length];
        int startIndex = 0;
        fillResult(result, less, startIndex);
        startIndex = startIndex + less.size();
        fillResult(result, equal, startIndex);
        startIndex = startIndex + equal.size();
        fillResult(result, more, startIndex);
        return result;
    }

    private void fillResult(int[] result, List<Integer> list, int startIndex) {
        int lenl = list.size();
        for (int i = 0; i < lenl; i++) {
            result[startIndex+i] = list.get(i);
        }
    }

    public static void main(String[] args) {
        int[] nums = {9,12,5,10,14,3,10};
        Code2161 code2161 = new Code2161();
        code2161.pivotArray(nums, 10);
    }
}
