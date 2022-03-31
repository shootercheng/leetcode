package com.scd.exercise;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author James
 */
public class Code506 {

    public String[] findRelativeRanks(int[] nums) {
        Map<Integer, Integer> numIndexMap = new HashMap<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            numIndexMap.put(nums[i], i);
        }
        bubbleSort(nums);
        String[] results = new String[len];
        if (len == 1) {
            results[numIndexMap.get(nums[0])] = "Gold Medal";
        } else if (len == 2) {
            results[numIndexMap.get(nums[0])] = "Gold Medal";
            results[numIndexMap.get(nums[1])] = "Silver Medal";
        } else {
            results[numIndexMap.get(nums[0])] = "Gold Medal";
            results[numIndexMap.get(nums[1])] = "Silver Medal";
            results[numIndexMap.get(nums[2])] = "Bronze Medal";
            for (int i = 3; i < len; i++) {
                results[numIndexMap.get(nums[i])] = String.valueOf(i + 1);
            }
        }
        return results;
    }

    private void bubbleSort(int[] nums) {
        int len = nums.length;
        for (int j = 0; j < len; j++) {
            for (int i = 0; i < len - j - 1; i++) {
                if (nums[i] < nums[i + 1]) {
                    int temp = nums[i];
                    nums[i] = nums[i + 1];
                    nums[i + 1] = temp;
                }
            }
        }
    }

    public String[] findRelativeRanks2(int[] nums) {
        Map<Integer, Integer> numIndexMap = new HashMap<>();
        int len = nums.length;
        List<Integer> list = new ArrayList<>(len);
        for (int i = 0; i < len; i++) {
            numIndexMap.put(nums[i], i);
            list.add(nums[i]);
        }
        List<Integer> sortedList = list.stream().sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        String[] results = new String[len];
        if (len == 1) {
            results[numIndexMap.get(sortedList.get(0))] = "Gold Medal";
        } else if (len == 2) {
            results[numIndexMap.get(sortedList.get(0))] = "Gold Medal";
            results[numIndexMap.get(sortedList.get(1))] = "Silver Medal";
        } else {
            results[numIndexMap.get(sortedList.get(0))] = "Gold Medal";
            results[numIndexMap.get(sortedList.get(1))] = "Silver Medal";
            results[numIndexMap.get(sortedList.get(2))] = "Bronze Medal";
            for (int i = 3; i < len; i++) {
                results[numIndexMap.get(sortedList.get(i))] = String.valueOf(i + 1);
            }
        }
        return results;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        Code506 code506 = new Code506();
//        code506.bubbleSort(nums);
//        System.out.println(nums);
        String[] results = code506.findRelativeRanks(nums);
        System.out.println(results);
    }
}
