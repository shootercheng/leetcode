package com.scd.exercise.m11;

import com.scd.exercise.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 未完成
 * @author James
 */
public class Code993 {

    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
            if (node.left != null && node.right != null) {
                if (node.left.left != null && node.right.left != null &&
                        ((node.left.left.val == x && node.right.left.val == y) ||
                                (node.left.left.val == y && node.right.left.val == x))) {
                    return true;
                }
                if (node.left.left != null && node.right.right != null &&
                        ((node.left.left.val == x && node.right.right.val == y) ||
                                (node.left.left.val == y && node.right.right.val == x))) {
                    return true;
                }
                if (node.left.right != null && node.right.left != null &&
                        ((node.left.right.val == x && node.right.left.val == y) ||
                                (node.left.right.val == y && node.right.left.val == x))) {
                    return true;
                }
                if (node.left.right != null && node.right.right != null &&
                        ((node.left.right.val == x && node.right.right.val == y) ||
                                (node.left.right.val == y && node.right.right.val == x))) {
                    return true;
                }
            }
        }
        return false;
    }
}
