package com.scd.exercise.y2021.m1;

import com.scd.exercise.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author James
 */
public class Code1161 {

    class LevelTree {
        private TreeNode treeNode;

        private int level;

        public LevelTree(TreeNode treeNode, int level) {
            this.treeNode = treeNode;
            this.level = level;
        }
    }

    public int maxLevelSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        LevelTree rootLevel = new LevelTree(root, 0);
        Queue<LevelTree> queue = new ArrayDeque<>();
        queue.offer(rootLevel);
        Map<Integer, Integer> levelValueMap = new HashMap<>();
        while (!queue.isEmpty()) {
            LevelTree node = queue.poll();
            int currentLevel = node.level;
            Integer sum = levelValueMap.computeIfAbsent(currentLevel, k -> 0);
            sum = sum + node.treeNode.val;
            levelValueMap.put(currentLevel, sum);
            if (node.treeNode.left != null) {
                int level = currentLevel + 1;
                LevelTree levelTree = new LevelTree(node.treeNode.left, level);
                queue.offer(levelTree);
            }
            if (node.treeNode.right != null) {
                int level = currentLevel + 1;
                LevelTree levelTree = new LevelTree(node.treeNode.right, level);
                queue.offer(levelTree);
            }
        }
        List<Integer> sumList = levelValueMap.values().stream().sorted().collect(Collectors.toList());
        int max = sumList.get(sumList.size() - 1);
        Set<Map.Entry<Integer, Integer>> entrySet = levelValueMap.entrySet();
        int result = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Integer> entry : entrySet) {
            if (entry.getValue() == max) {
                Integer key = entry.getKey();
                if (key < result) {
                    result = key;
                }
            }
        }
        return result;
    }
}
