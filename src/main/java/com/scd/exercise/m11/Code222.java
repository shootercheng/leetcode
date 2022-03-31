package com.scd.exercise.m11;

import com.scd.exercise.TreeNode;

/**
 * @author James
 */
public class Code222 {

    public int countNodes(TreeNode root) {
        int[] sum = new int[1];
        traverseValTree(root, sum);
        return sum[0];
    }

    public void traverseValTree(TreeNode root, int[] sum) {
        if (root != null) {
            sum[0] = sum[0] + 1;
            traverseValTree(root.left, sum);
            traverseValTree(root.right, sum);
        }
    }
}
