package com.scd.exercise.m12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author James
 */
public class Code1399 {

    public int countLargestGroup(int n) {
        Map<Integer, List<Integer>> numMap = new HashMap<>();
        int maxSize = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            int sumEachNum = addEachNum(i);
            List<Integer> list = numMap.computeIfAbsent(sumEachNum, k -> new ArrayList<>());
            list.add(i);
            if (list.size() > maxSize) {
                maxSize = list.size();
            }
        }
        int count = 0;
        for (List<Integer> list : numMap.values()) {
            if (list.size() == maxSize) {
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

    public static void main(String[] args) {
        Code1399 code1399 = new Code1399();
        System.out.println(code1399.countLargestGroup(13));
//        for (int i = 0; i <= 1000; i++) {
//            System.out.println(i + "______" + code1399.addEachNum(i));
//        }
    }
}
