package com.scd.exercise.m11;

import com.scd.exercise.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * @author James
 */
public class Code662 {

    class LevelTree {
        private TreeNode treeNode;

        private int level;

        public LevelTree(TreeNode treeNode, int level) {
            this.treeNode = treeNode;
            this.level = level;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return 0;
        }
        LevelTree rootLevel = new LevelTree(root, 0);
        Queue<LevelTree> queue = new ArrayDeque<>();
        queue.offer(rootLevel);
        Map<Integer, List<Integer>> levelValueMap = new HashMap<>();
        while (!queue.isEmpty()) {
            LevelTree node = queue.poll();
            int currentLevel = node.level;
            List<Integer> list = levelValueMap.computeIfAbsent(currentLevel, k -> new ArrayList<>());
            list.add(node.treeNode.val);
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
        Integer max = 0;
        for (List<Integer> list : levelValueMap.values()) {
            if (list.size() > max) {
                max = list.size();
            }
        }
        return max;
    }

}
