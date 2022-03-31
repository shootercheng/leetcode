package com.scd.exercise.m11;

import com.scd.exercise.TreeCommon;
import com.scd.exercise.TreeNode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * @author James
 */
public class Code543 {

    public int diameterOfBinaryTree(TreeNode root) {
        if (root != null) {
            int max = Integer.MIN_VALUE;
            Queue<TreeNode> queue = new ArrayDeque<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                TreeNode curNode = queue.poll();
                int left = getTreeDeep(curNode.left);
                int right = getTreeDeep(curNode.right);
                int sum = left + right;
                if (sum > max) {
                    max = sum;
                }
                if (curNode.left != null) {
                    queue.offer(curNode.left);
                }
                if (curNode.right != null) {
                    queue.offer(curNode.right);
                }
            }
            return max;
        }
        return 0;
    }

    public int getTreeDeep(TreeNode node) {
        if (node != null) {
            int leftHeight = getTreeDeep(node.left);
            int rightHeight = getTreeDeep(node.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }
        return 0;
    }

    public static void main(String[] args) {
//        int[] nums = {1,2,3,4,5};
        TreeNode treeNode = TreeCommon.createBinaryTree(Arrays.asList(1,2,3,4,5));
        Code543 code543 = new Code543();
        System.out.println(code543.getTreeDeep(treeNode.left));
        System.out.println(code543.getTreeDeep(treeNode.right));
    }
}
