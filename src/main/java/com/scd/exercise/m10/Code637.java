package com.scd.exercise.m10;

import com.scd.exercise.TreeCommon;
import com.scd.exercise.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * @author James
 */
public class Code637 {

    class LevelTree {
        private TreeNode treeNode;

        private Integer level;

        public LevelTree(TreeNode treeNode, Integer level) {
            this.treeNode = treeNode;
            this.level = level;
        }
    }

    public List<Double> averageOfLevels(TreeNode root) {
        Queue<LevelTree> queue = new ArrayDeque<>();
        LevelTree rootLevel = new LevelTree(root, 0);
        queue.offer(rootLevel);
        int maxLevel = Integer.MIN_VALUE;
        Map<Integer, List<Integer>> levelMap = new HashMap<>();
        while (!queue.isEmpty()) {
            LevelTree levelTree = queue.poll();
            int level = levelTree.level + 1;
            List<Integer> nodeList = levelMap.computeIfAbsent(level, k -> new ArrayList<>());
            nodeList.add(levelTree.treeNode.val);
            if (levelTree.treeNode.left != null) {
                LevelTree leftLevel = new LevelTree(levelTree.treeNode.left, level);
                queue.offer(leftLevel);
            }
            if (levelTree.treeNode.right != null) {
                LevelTree rightLevel = new LevelTree(levelTree.treeNode.right, level);
                queue.offer(rightLevel);
            }
            if (level > maxLevel) {
                maxLevel = level;
            }
        }
        List<Double> result = new ArrayList<>(levelMap.size());
        for (int i = 1; i <= maxLevel; i++) {
            List<Integer> nodeList = levelMap.get(i);
            if (nodeList != null) {
                long sum = 0;
                for (Integer val : nodeList) {
                    sum = sum + val;
                }
                double average = sum / (double) nodeList.size();
                result.add(average);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Code637 code637 = new Code637();
        TreeNode treeNode = TreeCommon.createBinaryTree(Arrays.asList(3,9,20,15,7));
        System.out.println(code637.averageOfLevels(treeNode));
    }
}
