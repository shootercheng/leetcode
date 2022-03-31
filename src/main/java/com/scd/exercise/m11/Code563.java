package com.scd.exercise.m11;

import com.scd.exercise.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author James
 */
public class Code563 {

    public int findTilt(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int[] leftVal = new int[1];
            int[] rightVal = new int[1];
            if (node.left != null) {
                getNodeSum(node.left, leftVal);
                queue.offer(node.left);
            }
            if (node.right != null) {
                getNodeSum(node.right, rightVal);
                queue.offer(node.right);
            }
            sum = sum + Math.abs(leftVal[0] - rightVal[0]);
        }
        return sum;
    }

    public void getNodeSum(TreeNode node, int[] sum) {
        if (node != null) {
            sum[0] = sum[0] + node.val;
            getNodeSum(node.left, sum);
            getNodeSum(node.right, sum);
        }
    }
}
