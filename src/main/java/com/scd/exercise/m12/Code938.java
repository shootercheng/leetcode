package com.scd.exercise.m12;

import com.scd.exercise.TreeNode;

/**
 * @author James
 */
public class Code938 {

    public int rangeSumBST(TreeNode root, int L, int R) {
        int[] sum = new int[1];
        preTraverValTree(root, L, R, sum);
        return sum[0];
    }

    private void preTraverValTree(TreeNode root, int low, int high, int[] sum) {
        if (root != null) {
            if (root.val >= low && root.val <= high) {
                sum[0] = sum[0] + root.val;
            }
            preTraverValTree(root.left, low, high, sum);
            preTraverValTree(root.right, low, high, sum);
        }
    }
}
