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
public class Code1302 {

    class LevelTree {
        private TreeNode node;

        private int level;

        public LevelTree(TreeNode node, int level) {
            this.level = level;
            this.node = node;
        }
    }

    public int deepestLeavesSum(TreeNode root) {
        LevelTree rtLevel = new LevelTree(root, 0);
        Queue<LevelTree> treeQueue = new ArrayDeque<>();
        treeQueue.offer(rtLevel);
        int maxLevel = 0;
        Map<Integer, List<Integer>> levelMap = new HashMap<>();
        while (!treeQueue.isEmpty()) {
            LevelTree ltree = treeQueue.poll();
            maxLevel = ltree.level;
            List<Integer> valList = levelMap.computeIfAbsent(maxLevel, k -> new ArrayList<>());
            valList.add(ltree.node.val);
            if (ltree.node.left != null) {
                treeQueue.offer(new LevelTree(ltree.node.left, maxLevel + 1));
            }
            if (ltree.node.right != null) {
                treeQueue.offer(new LevelTree(ltree.node.right, maxLevel + 1));
            }
        }
        int sum = 0;
        List<Integer> valList = levelMap.get(maxLevel);
        for (Integer val : valList) {
            sum = sum + val;
        }
        return sum;
    }
}
