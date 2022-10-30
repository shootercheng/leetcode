package com.scd.exercise.y2022.m7.middle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author James
 */
public class Code2342 {


    public int maximumSum(int[] nums) {
        Map<Integer, List<Integer>> numSumIndexMap = new HashMap<>();
        int lenn = nums.length;
        for (int i = 0; i < lenn; i++) {
            int sumNum = sumNum(nums[i]);
            List<Integer> numList = numSumIndexMap.computeIfAbsent(sumNum, k -> new ArrayList<>());
            numList.add(nums[i]);
        }
        int maxResult = -1;
        for (Map.Entry<Integer, List<Integer>> entry : numSumIndexMap.entrySet()) {
            if (entry.getValue().size() > 1) {
                List<Integer> sortedList = entry.getValue().stream().sorted().collect(Collectors.toList());
                int curSum = sortedList.get(sortedList.size() - 1) + sortedList.get(sortedList.size() - 2);
                if (curSum > maxResult) {
                    maxResult = curSum;
                }
            }
        }
        return maxResult;
    }

    private int sumNum(int num) {
        int sum = 0;
        while (num > 9) {
            int mod = num % 10;
            sum = sum + mod;
            num = num / 10;
        }
        sum = sum + num;
        return sum;
    }

    public static void main(String[] args) {
        Code2342 code2342 = new Code2342();
        int[] numArr = new int[]{368,369,307,304,384,138,90,279,35,396,114,328,251,364,300,191,438,467,183};
        for (int num : numArr) {
            System.out.println(code2342.sumNum(num));
        }
        // 369 + 279 + 396
        System.out.println(code2342.maximumSum(numArr));
    }
}
