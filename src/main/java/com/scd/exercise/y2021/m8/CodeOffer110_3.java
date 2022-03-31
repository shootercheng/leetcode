package com.scd.exercise.y2021.m8;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author James
 */
public class CodeOffer110_3 {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        Deque<Integer> queue = new ArrayDeque<>();
        int start = 0;
        int end = graph.length - 1;
        queue.offerLast(start);
        List<List<Integer>> resultList = new ArrayList<>();
        dfs(graph, resultList, queue, start, end);
        return resultList;
    }

    private void dfs(int[][] graph, List<List<Integer>> resultList, Deque<Integer> queue,
                     int start, int end) {
        if (start == end) {
            resultList.add(new ArrayList<>(queue));
            return;
        }
        if (start < graph.length) {
            int[] targetArr = graph[start];
            for (int target : targetArr) {
                queue.offerLast(target);
                dfs(graph, resultList, queue, target, end);
                queue.pollLast();
            }
        }
    }

    public static void main(String[] args) {
        int[][] graph = new int[][]{
                {1,2},{3},{3},{}
        };
        CodeOffer110_3 codeOffer110_3 = new CodeOffer110_3();
        System.out.println(codeOffer110_3.allPathsSourceTarget(graph));
    }
}
