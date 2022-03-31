package com.scd.exercise.y2021.m3;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author James
 */
public class Code1742 {

    public int countBalls(int lowLimit, int highLimit) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = lowLimit; i <= highLimit; i++) {
            int number = calNumber(i);
            int count = countMap.computeIfAbsent(number, k -> 0);
            countMap.put(number, ++count);
        }
        int max = 0;
        Set<Map.Entry<Integer, Integer>> entrySet = countMap.entrySet();
        for (Map.Entry<Integer, Integer> entry : entrySet) {
            int value = entry.getValue();
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

    public int calNumber(int i) {
        int sum = 0;
        while (i != 0) {
            int mod = i % 10;
            sum = sum + mod;
            i = i / 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        Code1742 code1742 = new Code1742();
        code1742.countBalls(1, 10);
    }
}
