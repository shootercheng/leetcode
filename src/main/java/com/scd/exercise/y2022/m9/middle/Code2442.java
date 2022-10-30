package com.scd.exercise.y2022.m9.middle;

import java.util.HashSet;
import java.util.Set;

public class Code2442 {

    public int countDistinctIntegers(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
            int reverseNum = reverseNum(num);
            numSet.add(reverseNum);
        }
        return numSet.size();
    }

    private int reverseNum(int num) {
        StringBuilder stringBuilder = new StringBuilder();
        while (num > 9) {
            int mod = num % 10;
            num = num / 10;
            stringBuilder.append(mod);
        }
        stringBuilder.append(num);
        return Integer.parseInt(stringBuilder.toString());
    }
}
