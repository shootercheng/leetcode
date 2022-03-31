package com.scd.exercise.y2021.m8;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author James
 */
public class CodeOffer110_2 {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        Queue<List<Integer>> queue = new ArrayDeque<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        queue.offer(path);
        int end = graph.length - 1;
        List<List<Integer>> resultList = new ArrayList<>();
        while (!queue.isEmpty()) {
            List<Integer> curPath = queue.poll();
            Integer last = curPath.get(curPath.size() - 1);
            if (last == end) {
                resultList.add(curPath);
            }
            if (last < graph.length) {
                int[] targetNode = graph[last];
                for (int target : targetNode) {
                    List<Integer> newPath = new ArrayList<>(curPath);
                    newPath.add(target);
                    queue.offer(newPath);
                }
            }
        }
        return resultList;
    }

    public static void main(String[] args) {
        int[][] graph = new int[][]{
                {1,2},{3},{3},{}
        };
        CodeOffer110_2 codeOffer110_2 = new CodeOffer110_2();
        System.out.println(codeOffer110_2.allPathsSourceTarget(graph));
    }
}
