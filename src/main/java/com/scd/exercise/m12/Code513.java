package com.scd.exercise.m12;

import com.scd.exercise.TreeNode;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * @author James
 */
public class Code513 {

    class LevelTree {
        private TreeNode node;

        private int level;

        public LevelTree(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    public int findBottomLeftValue(TreeNode root) {
        LevelTree levelTree = new LevelTree(root, 0);
        Queue<LevelTree> queue = new ArrayDeque<>();
        queue.offer(levelTree);
        Map<Integer, Integer> rowMap = new HashMap<>();
        int maxLevel = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            LevelTree curTree = queue.poll();
            int curLevel = curTree.level;
            if (!rowMap.containsKey(curLevel)) {
                rowMap.put(curLevel, curTree.node.val);
            }
            if (curLevel > maxLevel) {
                maxLevel = curLevel;
            }
            if (curTree.node.left != null) {
                LevelTree tree = new LevelTree(curTree.node.left, curLevel + 1);
                queue.offer(tree);
            }
            if (curTree.node.right != null) {
                LevelTree tree = new LevelTree(curTree.node.right, curLevel + 1);
                queue.offer(tree);
            }
        }
        return rowMap.get(maxLevel);
    }
}
