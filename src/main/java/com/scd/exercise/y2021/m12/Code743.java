package com.scd.exercise.y2021.m12;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author James
 */
public class Code743 {

    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<Integer>> edgeMap = new HashMap<>();
        Map<String, Integer> delayMap = new HashMap<>();
        for (int[] edgeArr : times) {
            List<Integer> targetList = edgeMap.computeIfAbsent(edgeArr[0], l -> new ArrayList<>());
            targetList.add(edgeArr[1]);
            delayMap.put(edgeArr[0] + "_" + edgeArr[1], edgeArr[2]);
        }
        List<List<Integer>> allPath = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();
        deque.offerLast(k);
        int[] visited = new int[n];
        visited[k-1] = 1;
        Set<String> edgeSet = new HashSet<>();
        dfs(edgeMap, allPath, k, deque, visited, edgeSet);
        for (int node : visited) {
            if (node == 0) {
                return -1;
            }
        }
        int maxDelay = Integer.MIN_VALUE;
        for (List<Integer> path : allPath) {
            int start = path.get(0);
            int result = 0;
            for (int i = 1; i < path.size(); i++) {
                int next = path.get(i);
                int curDelay = delayMap.get(start + "_" + next);
                result = result + curDelay;
                start = next;
            }
            if (result > maxDelay) {
                maxDelay = result;
            }
        }
        return maxDelay;
    }

    private void dfs(Map<Integer, List<Integer>> edgeMap, List<List<Integer>> allPath, int start, Deque<Integer> deque,
                     int[] visited, Set<String> edgeSet) {
        List<Integer> targetList = edgeMap.get(start);
        if (targetList != null) {
            for (Integer target : targetList) {
                String edge = start + "_" + target;
                if (edgeSet.contains(edge)) {
                    return;
                } else {
                    edgeSet.add(edge);
                }
                visited[target - 1] = 1;
                deque.offerLast(target);
                dfs(edgeMap, allPath, target, deque, visited, edgeSet);
                deque.pollLast();
            }
        } else {
            allPath.add(new ArrayList<>(deque));
        }
    }

    public static void main(String[] args) {
        Code743 code743 = new Code743();
//        int[][] times = new int[][]{
//                {2,1,1},{2,3,1},{3,4,1}
//        };
//        [[1,2,1],[2,1,3]]
        int[][] times = new int[][]{
                {1,2,1},{2,1,3}
        };
        System.out.println(code743.networkDelayTime(times, 2, 2));
    }
}
