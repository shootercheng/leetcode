package com.scd.exercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * @author James
 */
public class Code110 {

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int leftDepth = treeDepth(node.left);
            int rightDepth = treeDepth(node.right);
            if (Math.abs(leftDepth - rightDepth) > 1) {
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

    public int treeDepth(TreeNode tree) {
        if (tree != null) {
            int left = treeDepth(tree.left);
            int right = treeDepth(tree.right);
            int max = Math.max(left, right);
            return max + 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        TreeNode tree = TreeCommon.createNullEleTree(Arrays.asList(1, null, 2, null, 3, null, 4));
        Code110 code110 = new Code110();
        int depth = code110.treeDepth(tree);
        System.out.println(depth);
    }
}
