package com.scd.exercise.y2021.m7;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author James
 */
public class Code47 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        Set<String> dataSet = new HashSet<>();
        fullPermute(nums, 0, nums.length, resultList, dataSet);
        return resultList;
    }

    public void fullPermute(int[] nums, int startIndex, int len, List<List<Integer>> resultList, Set<String> dataSet) {
        if (startIndex == len - 1) {
            List<Integer> one = new ArrayList<>();
            StringBuilder stringBuilder = new StringBuilder();
            for (int num : nums) {
                one.add(num);
                stringBuilder.append(num).append(".");
            }
            String data = stringBuilder.toString();
            if (!dataSet.contains(data)) {
                dataSet.add(data);
                resultList.add(one);
            }
        } else {
            for (int i = startIndex; i < len; i++) {
                swapNum(nums, startIndex, i);
                fullPermute(nums, startIndex + 1, len, resultList, dataSet);
                swapNum(nums, i, startIndex);
            }
        }
    }

    private void swapNum(int[] nums, int startIndex, int i) {
        int temp = nums[startIndex];
        nums[startIndex] = nums[i];
        nums[i] = temp;
    }

    public static void main(String[] args) {
        Code47 code47 = new Code47();
        List<List<Integer>> result = new ArrayList<>();
        int[] nums = new int[]{1,1,2};
        Set<String> dataSet = new HashSet<>();
        code47.fullPermute(nums, 0, nums.length, result, dataSet);
        System.out.println(result);
    }
}
