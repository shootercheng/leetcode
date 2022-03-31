package com.scd.exercise.m12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author James
 */
public class Code1399_1 {

    public int countLargestGroup(int n) {
        Map<Integer, Integer> numMap = new HashMap<>();
        int maxSize = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            int sumEachNum = addEachNum(i);
            Integer num = numMap.computeIfAbsent(sumEachNum, k -> 0);
            numMap.put(sumEachNum, ++num);
            if (num > maxSize) {
                maxSize = num;
            }
        }
        int count = 0;
        for (Integer integer : numMap.values()) {
            if (integer == maxSize) {
                count++;
            }
        }
        return count;
    }

    public int addEachNum(int n) {
        if (n < 10) {
            return n;
        }
        int temp = n;
        int sum = 0;
        while (temp >= 10) {
            int mod = temp % 10;
            temp = temp / 10;
            sum = sum + mod;
        }
        int mod = temp % 10;
        sum = sum + mod;
        return sum;
    }
}
