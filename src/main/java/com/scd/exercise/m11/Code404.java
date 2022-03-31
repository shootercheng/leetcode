package com.scd.exercise.m11;

import com.scd.exercise.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author James
 */
public class Code404 {

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int sum = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                queue.offer(node.left);
                if (node.left.left == null && node.left.right == null) {
                    sum = sum + node.left.val;
                }
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return sum;
    }
}
