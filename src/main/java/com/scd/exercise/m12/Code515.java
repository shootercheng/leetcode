package com.scd.exercise.m12;

import com.scd.exercise.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * Code107
 * @author James
 */
public class Code515 {

    class LevelTree {
        private TreeNode node;

        private int level;

        public LevelTree(TreeNode node, Integer level) {
            this.node = node;
            this.level = level;
        }
    }

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        LevelTree rootTree = new LevelTree(root, 0);
        Queue<LevelTree> queue = new ArrayDeque<>();
        queue.offer(rootTree);
        Map<Integer, Integer> rowMap = new HashMap<>();
        while (!queue.isEmpty()) {
            LevelTree node = queue.poll();
            int curLevel = node.level;
            Integer val = rowMap.computeIfAbsent(curLevel, k -> Integer.MIN_VALUE);
            if (node.node.val > val) {
                rowMap.put(curLevel, node.node.val);
            }
            if (node.node.left != null) {
                LevelTree levelTree = new LevelTree(node.node.left, curLevel + 1);
                queue.offer(levelTree);
            }
            if (node.node.right != null) {
                LevelTree levelTree = new LevelTree(node.node.right, curLevel + 1);
                queue.offer(levelTree);
            }
        }
        int size = rowMap.size();
        for (int i = 0; i < size; i++) {
            result.add(rowMap.get(i));
        }
        return result;
    }
}
