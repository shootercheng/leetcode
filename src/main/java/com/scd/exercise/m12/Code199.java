package com.scd.exercise.m12;

import com.scd.exercise.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * @author James
 */
public class Code199 {

    class LevelTree {
        private TreeNode treeNode;

        private int level;

        public LevelTree(TreeNode treeNode, int level) {
            this.treeNode = treeNode;
            this.level = level;
        }
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        LevelTree rootLevel = new LevelTree(root, 0);
        Queue<LevelTree> queue = new ArrayDeque<>();
        queue.offer(rootLevel);
        Map<Integer, List<Integer>> levelValueMap = new HashMap<>();
        int maxLevel = 0;
        while (!queue.isEmpty()) {
            LevelTree node = queue.poll();
            int currentLevel = node.level;
            List<Integer> list = levelValueMap.computeIfAbsent(currentLevel, k -> new ArrayList<>());
            list.add(node.treeNode.val);
            maxLevel = currentLevel;
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
        for (int i = 0; i <= maxLevel; i++) {
            List<Integer> list = levelValueMap.get(i);
            int last = list.get(list.size() - 1);
            result.add(last);
        }
        return result;
    }
}
