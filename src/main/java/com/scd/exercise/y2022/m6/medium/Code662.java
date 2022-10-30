package com.scd.exercise.y2022.m6.medium;

import com.scd.exercise.TreeCommon;
import com.scd.exercise.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * 二叉树最大宽度
 * @author James
 */
public class Code662 {

    class LevelTree {
        private TreeNode node;

        private int level;

        public LevelTree(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        Map<Integer, List<Integer>> levelMap = new HashMap<>();
        List<Integer> rootList = new ArrayList<>();
        rootList.add(root.val);
        levelMap.put(1, rootList);
        Queue<LevelTree> queue = new ArrayDeque<>();
        LevelTree rootLevel = new LevelTree(root, 1);
        queue.offer(rootLevel);
        while (!queue.isEmpty()) {
            LevelTree curTree = queue.poll();
            int level = curTree.level;
            int nextLevl = level + 1;
            List<Integer> valList = levelMap.computeIfAbsent(nextLevl, k -> new ArrayList<>());
            if (curTree.node.left != null) {
                LevelTree node = new LevelTree(curTree.node.left, nextLevl);
                queue.offer(node);
                valList.add(curTree.node.left.val);
            } else {
                valList.add(null);
            }
            if (curTree.node.right != null) {
                LevelTree node = new LevelTree(curTree.node.right, nextLevl);
                queue.offer(node);
                valList.add(curTree.node.right.val);
            } else {
                valList.add(null);
            }
        }
        Set<Map.Entry<Integer, List<Integer>>> entrySet = levelMap.entrySet();
        int maxWidth = 0;
        for (Map.Entry<Integer, List<Integer>> entry : entrySet) {
            int curWidth = calWidth(entry.getKey(), entry.getValue());
            if (curWidth > maxWidth) {
                maxWidth = curWidth;
            }
        }
        return maxWidth;
    }

    private int calWidth(int level, List<Integer> valueList) {
        int lenv = valueList.size();
        if (lenv == 0) {
            return 0;
        }
        int leftCount = 0;
        for (int i = 0; i < lenv; i++) {
            if (valueList.get(i) == null) {
                leftCount++;
            } else {
                break;
            }
        }
        if (leftCount != lenv) {
            int rightCount = 0;
            for (int i = lenv - 1; i >= 0; i--) {
                if (valueList.get(i) == null) {
                    rightCount++;
                } else {
                    break;
                }
            }
            return (int) Math.pow(2, level - 1) - leftCount - rightCount;
        }
        return 0;
    }

    public static void main(String[] args) {
        Code662 code662 = new Code662();
        TreeNode root = TreeCommon.createNullEleTree(Arrays.asList(1,3,2,5,null,null,9,6,null,null,7));
        code662.widthOfBinaryTree(root);
    }
}
