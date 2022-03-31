package com.scd.exercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * @author James
 */
public class Code111 {

    class LevelTree {
        private TreeNode treeNode;

        private Integer level;

        public LevelTree(TreeNode treeNode, Integer level) {
            this.treeNode = treeNode;
            this.level = level;
        }
    }

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<LevelTree> queue = new ArrayDeque<>();
        LevelTree levelTree = new LevelTree(root, 1);
        queue.offer(levelTree);
        Integer minLevel = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            LevelTree node = queue.poll();
            TreeNode treeNode = node.treeNode;
            Integer curLevel = node.level;
            if (treeNode.left == null && treeNode.right == null) {
                if (minLevel > curLevel) {
                    minLevel = curLevel;
                }
            }
            Integer level = curLevel + 1;
            if (treeNode.left != null) {
                queue.offer(new LevelTree(treeNode.left, level));
            }
            if (treeNode.right != null) {
                queue.offer(new LevelTree(treeNode.right, level));
            }
        }
        if (minLevel == Integer.MAX_VALUE) {
            return 1;
        }
        return minLevel;
    }

    public int minDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<LevelTree> queue = new ArrayDeque<>();
        LevelTree levelTree = new LevelTree(root, 1);
        queue.offer(levelTree);
        Integer minLevel = 0;
        while (!queue.isEmpty()) {
            LevelTree node = queue.poll();
            TreeNode treeNode = node.treeNode;
            Integer curLevel = node.level;
            if (treeNode.left == null && treeNode.right == null) {
                return curLevel;
            }
            Integer level = curLevel + 1;
            if (treeNode.left != null) {
                queue.offer(new LevelTree(treeNode.left, level));
            }
            if (treeNode.right != null) {
                queue.offer(new LevelTree(treeNode.right, level));
            }
        }
        return minLevel;
    }

    public static void main(String[] args) {
        Code111 code111 = new Code111();
        TreeNode treeNode = TreeCommon.createNullEleTree(Arrays.asList(1,2,null,3,4,5,6));
        System.out.println(code111.minDepth(treeNode));
    }
}
