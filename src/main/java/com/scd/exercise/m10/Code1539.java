package com.scd.exercise.m10;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author James
 */
public class Code1539 {

    public int findKthPositive(int[] arr, int k) {
        Map<Integer, Integer> numMap = new HashMap<>();
        int lena = arr.length;
        int max = arr[lena - 1];
        boolean[] finds = new boolean[max];
        for (int num : arr) {
            finds[num - 1] = true;
        }
        int key = 1;
        for (int i = 0; i < max; i++) {
            if (!finds[i]) {
                numMap.put(key++, i+1);
            }
        }
        if (k <= numMap.size()) {
            return numMap.get(k);
        }
        return max + (k - numMap.size());
    }

    public static void main(String[] args) {
        int[] nums = {1,13,18};
        Code1539 code1539 = new Code1539();
        code1539.findKthPositive(nums, 17);
    }
}
