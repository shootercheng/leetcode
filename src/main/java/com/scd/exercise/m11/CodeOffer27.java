package com.scd.exercise.m11;

import com.scd.exercise.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author James
 */
public class CodeOffer27 {

    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return new TreeNode(0);
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return root;
    }
}
