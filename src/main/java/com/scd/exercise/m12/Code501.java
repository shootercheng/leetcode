package com.scd.exercise.m12;

import com.scd.exercise.TreeNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author James
 */
public class Code501 {

    public int[] findMode(TreeNode root) {
        if (root == null) {
            return new int[]{};
        }
        Map<Integer, Integer> countMap = new HashMap<>();
        traverseTree(root, countMap);
        List<Map.Entry<Integer, Integer>> list = countMap.entrySet().stream()
                .sorted(Comparator.comparingInt(this::sort).reversed()).collect(Collectors.toList());
        List<Integer> result = new ArrayList<>();
        int max = list.get(0).getValue();
        result.add(list.get(0).getKey());
        int size = list.size();
        for (int i = 1; i < size; i++) {
            if (list.get(i).getValue() == max) {
                result.add(list.get(i).getKey());
            } else {
                break;
            }
        }
        int[] intRes = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            intRes[i] = result.get(i);
        }
        return intRes;
    }

    private int sort(Map.Entry<Integer, Integer> t) {
        return t.getValue();
    }

    private void traverseTree(TreeNode root, Map<Integer, Integer> countMap) {
        if (root != null) {
            Integer count = countMap.computeIfAbsent(root.val, k -> 0);
            countMap.put(root.val, ++count);
            traverseTree(root.left, countMap);
            traverseTree(root.right, countMap);
        }
    }
}
