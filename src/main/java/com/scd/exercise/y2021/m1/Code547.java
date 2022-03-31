package com.scd.exercise.y2021.m1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author James
 */
public class Code547 {

    public int findCircleNum(int[][] M) {
        int lenm = M.length;
        List<Integer> allData = new ArrayList<>();
        Map<Integer, Set<Integer>> graphMap = new HashMap<>();
        for (int i = 0; i < lenm; i++) {
            allData.add(i);
            for (int j = 0; j < M[i].length; j++) {
                if (i != j) {
                    Set<Integer> valSet = graphMap.computeIfAbsent(i, k -> new HashSet<>());
                    valSet.add(M[i][j]);
                }
            }
        }
        return 0;
    }
}
