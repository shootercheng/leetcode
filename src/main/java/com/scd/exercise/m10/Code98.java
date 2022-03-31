package com.scd.exercise.m10;

import com.scd.exercise.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author James
 */
public class Code98 {

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            if (treeNode.left != null) {
                if (treeNode.val <= treeNode.left.val) {
                    return false;
                }
                queue.offer(treeNode.left);
            }
            if (treeNode.right != null) {
                if (treeNode.val >= treeNode.right.val) {
                    return false;
                }
                queue.offer(treeNode.right);
            }
        }
        return true;
    }
}
