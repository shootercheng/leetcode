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
public class Code103 {

    class LevelTree {
        private TreeNode node;

        private int level;

        public LevelTree(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        LevelTree rootTree = new LevelTree(root, 0);
        Queue<LevelTree> queue = new ArrayDeque<>();
        queue.offer(rootTree);
        Map<Integer, List<Integer>> levelMap = new HashMap<>();
        int curLevel = 0;
        while (!queue.isEmpty()) {
            LevelTree curNode = queue.poll();
            curLevel = curNode.level;
            List<Integer> dataList = levelMap.computeIfAbsent(curLevel, k -> new ArrayList<>());
            dataList.add(curNode.node.val);
            if (curNode.node.left != null) {
                LevelTree left = new LevelTree(curNode.node.left, curLevel+1);
                queue.offer(left);
            }
            if (curNode.node.right != null) {
                LevelTree right = new LevelTree(curNode.node.right, curLevel+1);
                queue.offer(right);
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i <= curLevel; i++) {
            List<Integer> levelList = levelMap.get(i);
            if (i % 2 == 0) {
                result.add(levelList);
            } else {
                int size = levelList.size();
                List<Integer> curList = new ArrayList<>();
                for (int j = size - 1; j >= 0; j--) {
                    curList.add(levelList.get(j));
                }
                result.add(curList);
            }
        }
        return result;
    }
}
