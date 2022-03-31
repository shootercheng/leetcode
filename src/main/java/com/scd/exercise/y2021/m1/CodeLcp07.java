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
public class CodeLcp07 {

    public int numWays(int n, int[][] relation, int k) {
        Map<Integer, List<Integer>> relationMap = new HashMap<>();
        for (int[] relaArr : relation) {
            List<Integer> nextList = relationMap.computeIfAbsent(relaArr[0], a -> new ArrayList<>());
            nextList.add(relaArr[1]);
        }
        List<List<Integer>> allPath = new ArrayList<>();
        List<Integer> onePath = new ArrayList<>();
        int start = 0;
        int end = n - 1;
        int[] result = new int[1];
        Set<String> existsSet = new HashSet<>();
        traveseMap(relationMap, onePath, allPath, start, end, k, result, existsSet);
        return result[0];
    }

    private void traveseMap(Map<Integer, List<Integer>> relationMap, List<Integer> onePath,
                            List<List<Integer>> allPath, int start, int end,
                            int k, int[] result, Set<String> existsSet) {
        onePath.add(start);
        if (start == end) {
            allPath.add(onePath);
            if (onePath.size() - 1 == k) {
                result[0]++;
            }
        } else {
            List<Integer> nextList = relationMap.get(start);
            if (nextList != null && nextList.size() > 0) {
                for (Integer curNode : nextList) {
                    String relation = start + "_" + curNode;
                    if (!existsSet.contains(relation)) {
                        existsSet.add(relation);
                        traveseMap(relationMap, new ArrayList<>(onePath), allPath, curNode, end, k, result, existsSet);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] relation = {{0,2},{2,1},{3,4},{2,3},{1,4},{2,0},{0,4}};
        int k = 3;
        CodeLcp07 codeLcp07 = new CodeLcp07();
        System.out.println(codeLcp07.numWays(n, relation, k));
    }
}
