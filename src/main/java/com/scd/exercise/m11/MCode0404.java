package com.scd.exercise.m11;

import com.scd.exercise.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author James
 */
public class MCode0404 {

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int leftHeight = getTreeDeep(node.left);
            int rightHeight = getTreeDeep(node.right);
            if (Math.abs(leftHeight - rightHeight) > 1) {
                return false;
            }
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return true;
    }

    private int getTreeDeep(TreeNode root) {
        if (root != null) {
            int left = getTreeDeep(root.left);
            int right = getTreeDeep(root.right);
            return Math.max(left, right) + 1;
        }
        return 0;
    }
}
