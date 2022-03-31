package com.scd.exercise.m11;

import com.scd.exercise.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author James
 */
public class Code1325 {

    public TreeNode removeLeafNodes(TreeNode root, int target) {
        while (true) {
            if (root == null) {
                return null;
            }
            if (root.left == null && root.right == null && root.val == target) {
                return null;
            }
            Queue<TreeNode> queue = new ArrayDeque<>();
            queue.offer(root);
            int removed = 0;
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    if (node.left.left == null && node.left.right == null && node.left.val == target) {
                        node.left = null;
                        removed++;
                    } else {
                        queue.offer(node.left);
                    }
                }
                if (node.right != null) {
                    if (node.right.left == null && node.right.right == null && node.right.val == target) {
                        node.right = null;
                        removed++;
                    } else {
                        queue.offer(node.right);
                    }
                }
            }
            if (removed == 0) {
                break;
            }
        }
        return root;
    }
}
