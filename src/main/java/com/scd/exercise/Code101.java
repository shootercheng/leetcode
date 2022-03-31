package com.scd.exercise;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author James
 */
public class Code101 {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        // 只有一个节点的情况
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null || left.val != right.val) {
            return false;
        }
        Queue<TreeNode> leftQueue = new ArrayDeque<>();
        leftQueue.offer(left);
        Queue<TreeNode> rightQueue = new ArrayDeque<>();
        rightQueue.offer(right);
        while (!leftQueue.isEmpty() || !rightQueue.isEmpty()) {
            TreeNode leftTree = leftQueue.poll();
            TreeNode rightTree = rightQueue.poll();
            if (leftTree == null || rightTree == null) {
                return false;
            }
            boolean leftSym = (leftTree.left == null && rightTree.right == null) ||
                                (leftTree.left != null && rightTree.right != null
                                        && leftTree.left.val == rightTree.right.val);
            boolean rightSym = (leftTree.right == null && rightTree.left == null) ||
                            (leftTree.right != null && rightTree.left != null
                            && leftTree.right.val == rightTree.left.val);
            if (!leftSym || !rightSym) {
                return false;
            }
            if (leftTree.left != null) {
                leftQueue.offer(leftTree.left);
            }
            if (leftTree.right != null) {
                leftQueue.offer(leftTree.right);
            }
            if (rightTree.right != null) {
                rightQueue.offer(rightTree.right);
            }
            if (rightTree.left != null) {
                rightQueue.offer(rightTree.left);
            }
        }
        return true;
    }
}
