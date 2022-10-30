package com.scd.exercise.y2022.m6.medium;

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
 * 二叉树每层的最大值
 * @author James
 */
public class CodeOffer044 {

    class LevelTree {
        private TreeNode node;

        private int level;

        public LevelTree(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    public List<Integer> largestValues(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Map<Integer, List<Integer>> levelMap = new HashMap<>();
        Queue<LevelTree> queue = new ArrayDeque<>();
        LevelTree rootLevel = new LevelTree(root, 1);
        queue.offer(rootLevel);
        while (!queue.isEmpty()) {
            LevelTree curTree = queue.poll();
            int level = curTree.level;
            int nextLevel = level + 1;
            List<Integer> valList = levelMap.computeIfAbsent(level, k -> new ArrayList<>());
            valList.add(curTree.node.val);
            if (curTree.node.left != null) {
                LevelTree node = new LevelTree(curTree.node.left, nextLevel);
                queue.offer(node);
            }
            if (curTree.node.right != null) {
                LevelTree node = new LevelTree(curTree.node.right, nextLevel);
                queue.offer(node);
            }
        }
        List<Integer> result = new ArrayList<>();
        Set<Map.Entry<Integer, List<Integer>>> entrySet = levelMap.entrySet();
        for (Map.Entry<Integer, List<Integer>> entry : entrySet) {
            List<Integer> sortedList = entry.getValue().stream().sorted().collect(Collectors.toList());
            result.add(sortedList.get(sortedList.size() - 1));
        }
        return result;
    }
}
