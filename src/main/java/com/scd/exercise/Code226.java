package com.scd.exercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * @author James
 */
public class Code226 {

    public TreeNode invertTree(TreeNode root) {
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


    public static void main(String[] args) {
        TreeNode tree = TreeCommon.createTree(Arrays.asList(1,2,3));
        TreeNode temp = tree.left;
        tree.left = tree.right;
        tree.right = temp;
        System.out.println(temp);
    }
}
