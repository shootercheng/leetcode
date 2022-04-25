package com.scd.contest.week289;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author James
 */
public class Code6071 {

    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int task : tasks) {
            Integer count = countMap.computeIfAbsent(task, k -> 0);
            countMap.put(task, ++count);
        }
        int sum = 0;
        Set<Map.Entry<Integer, Integer>> entrySet = countMap.entrySet();
        for (Map.Entry<Integer, Integer> entry : entrySet) {
            int val = entry.getValue();
            if (val < 2) {
                return -1;
            }
            int max3 = val / 3;
            int count = 0;
            boolean isFind = false;
            for (int i = max3; i >= 0; i--) {
                int left = val - 3 * i;
                if (left % 2 == 0) {
                    count = i + left / 2;
                    isFind = true;
                    break;
                }
            }
            if (!isFind) {
                return -1;
            }
            sum = sum + count;
        }
        return sum;
    }

    public static void main(String[] args) {
        Code6071 code6071 = new Code6071();
        code6071.minimumRounds(new int[]{7,7,7,7,7,7});
    }
}
