package com.scd.exercise.y2021.m7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author James
 */
public class Code1743 {

    public int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer, Set<Integer>> numListMap = new HashMap<>();
        int lena = adjacentPairs.length;
        if (lena == 1) {
            return adjacentPairs[0];
        }
        for (int i = 0; i < lena; i++) {
            int[] adjacent = adjacentPairs[i];
            Set<Integer> zeroIndexSet = numListMap.computeIfAbsent(adjacent[0], k -> new HashSet<>());
            zeroIndexSet.add(i);
            Set<Integer> oneIndexSet = numListMap.computeIfAbsent(adjacent[1], k -> new HashSet<>());
            oneIndexSet.add(i);
        }
        Set<Map.Entry<Integer, Set<Integer>>> entrySet = numListMap.entrySet();
        List<int[]> numList = new ArrayList<>();
        for (Map.Entry<Integer, Set<Integer>> entry : entrySet) {
            Set<Integer> indexSet = entry.getValue();
            if (indexSet.size() == 1) {
                int[] numArr = new int[2];
                numArr[0] = indexSet.iterator().next();
                numArr[1] = entry.getKey();
                numList.add(numArr);
            }
        }
        int[] startIndexNum = numList.get(0);
        int[] endIndexNum = numList.get(1);
        swapData(adjacentPairs, lena, startIndexNum, endIndexNum);
        return getResult(adjacentPairs);
    }

    private int[] getResult(int[][] adjacentPairs) {
        List<Integer> resultList = new ArrayList<>();
        Set<Integer> numSet = new HashSet<>();
        for (int[] adj : adjacentPairs) {
            if (!numSet.contains(adj[0])) {
                numSet.add(adj[0]);
                resultList.add(adj[0]);
            }
            if (!numSet.contains(adj[1])) {
                numSet.add(adj[1]);
                resultList.add(adj[1]);
            }
        }
        int[] result = new int[resultList.size()];
        int index = 0;
        for (int num : resultList) {
            result[index++] = num;
        }
        return result;
    }

    private void swapData(int[][] adjacentPairs, int lena, int[] startIndexNum, int[] endIndexNum) {
        if (adjacentPairs[startIndexNum[0]][0] != startIndexNum[1]) {
            swap(0, 1, adjacentPairs[startIndexNum[0]]);
        }
        if (adjacentPairs[endIndexNum[0]][1] != endIndexNum[1]) {
            swap(0, 1, adjacentPairs[endIndexNum[0]]);
        }
        if (startIndexNum[0] != 0) {
            swap(startIndexNum[0], 0, adjacentPairs);
        }
        if (endIndexNum[0] != lena - 1) {
            swap(endIndexNum[0], lena - 1, adjacentPairs);
        }
    }

    public void swap(int indexi, int indexj, int[][] adjacentPairs) {
        int[] temp = adjacentPairs[indexi];
        adjacentPairs[indexi] = adjacentPairs[indexj];
        adjacentPairs[indexj] = temp;
    }

    public void swap(int indexi, int indexj, int[] adjacent) {
        int temp = adjacent[indexi];
        adjacent[indexi] = adjacent[indexj];
        adjacent[indexj] = temp;
    }

    public static void main(String[] args) {
        Code1743 code1743 = new Code1743();
//        int[][] adjacentPairs = {{2,1},{3,4},{3,2}};
//        System.out.println(code1743.restoreArray(adjacentPairs));
        int[][] adjacentPairs1 = {{4,-10},{-1,3},{4,-3},{-3,3}};
        System.out.println(code1743.restoreArray(adjacentPairs1));
    }
}
