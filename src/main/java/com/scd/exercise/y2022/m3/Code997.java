package com.scd.exercise.y2022.m3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 997. 找到小镇的法官
 * @author James
 */
public class Code997 {

    public int findJudge(int N, int[][] trust) {
        int[] temp = new int[N];
        Map<Integer, List<Integer>> tempMap = new HashMap<>();
        for (int[] tArr : trust) {
            if (tArr[0] > N) {
                continue;
            }
            temp[tArr[0] - 1] = 1;
            List<Integer> val = tempMap.computeIfAbsent(tArr[0], k -> new ArrayList<>());
            val.add(tArr[1]);
        }
        int count = 0;
        int result = -1;
        for (int i = 0; i < N; i++) {
            if (temp[i] == 0) {
                count++;
                result = i + 1;
            }
        }
        if (count == 1) {
            for (int[] tArr : trust) {
                if (tArr[0] == result) {
                    continue;
                }
                List<Integer> val = tempMap.get(tArr[0]);
                if (val == null || !val.contains(result)) {
                    return -1;
                }
            }
            return result;
        }
        return -1;
    }

    public static void main(String[] args) {
        Code997 code997 = new Code997();
        code997.findJudge(3, new int[][]{{1,2},{2,3},{1,3}});    }
}
