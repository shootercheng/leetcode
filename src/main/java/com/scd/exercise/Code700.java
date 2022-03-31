package com.scd.exercise;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author James
 */
public class Code700 {

    public TreeNode searchBST(TreeNode root, int val) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.val == val) {
                return node;
            }
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return null;
    }
}
