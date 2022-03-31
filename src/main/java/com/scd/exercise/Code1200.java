package com.scd.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author James
 */
public class Code1200 {

    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        if (arr == null || arr.length < 2) {
            return new ArrayList<>();
        }
        Arrays.sort(arr);
        int alen = arr.length;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < alen - 1; i++) {
            int abs = Math.abs(arr[i+1] - arr[i]);
            if (abs < min) {
                min = abs;
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < alen - 1; i++) {
            int abs = Math.abs(arr[i+1] - arr[i]);
            if (abs == min) {
                List<Integer> stepList = new ArrayList<>();
                stepList.add(arr[i]);
                stepList.add(arr[i+1]);
                result.add(stepList);
            }
        }
        return result;
    }
}
