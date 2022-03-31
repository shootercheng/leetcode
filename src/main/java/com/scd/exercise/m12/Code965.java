package com.scd.exercise.m12;

import com.scd.exercise.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author James
 */
public class Code965 {

    public boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            return false;
        }
        int first = root.val;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode curNode = queue.poll();
            if (curNode.val != first) {
                return false;
            }
            if (curNode.left != null) {
                queue.offer(curNode.left);
            }
            if (curNode.right != null) {
                queue.offer(curNode.right);
            }
        }
        return true;
    }
}
