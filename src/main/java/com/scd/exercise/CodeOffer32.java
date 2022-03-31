package com.scd.exercise;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * @author James
 */
public class CodeOffer32 {

    class LevelTree {
        private TreeNode treeNode;

        private int level;

        public LevelTree(TreeNode treeNode, int level) {
            this.treeNode = treeNode;
            this.level = level;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        LevelTree levelTree = new LevelTree(root, 1);
        Map<Integer, List<Integer>> map = new LinkedHashMap<>();
        map.put(1, Arrays.asList(levelTree.treeNode.val));
        Queue<LevelTree> queue = new ArrayDeque<>();
        queue.offer(levelTree);
        while (!queue.isEmpty()) {
            LevelTree node = queue.poll();
            int level = node.level + 1;
            if (node.treeNode.left != null) {
                LevelTree leftNode = new LevelTree(node.treeNode.left, level);
                List<Integer> list = map.computeIfAbsent(level, k -> new ArrayList<>());
                list.add(leftNode.treeNode.val);
                queue.offer(leftNode);
            }
            if (node.treeNode.right != null) {
                LevelTree rightNode = new LevelTree(node.treeNode.right, level);
                List<Integer> list = map.computeIfAbsent(level, k -> new ArrayList<>());
                list.add(rightNode.treeNode.val);
                queue.offer(rightNode);
            }
        }
        Set<Map.Entry<Integer, List<Integer>>> entrySet = map.entrySet();
        for (Map.Entry<Integer, List<Integer>> entry : entrySet) {
            result.add(entry.getValue());
        }
        return result;
    }
}
