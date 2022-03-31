package com.scd.exercise.m12;

import com.scd.exercise.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author James
 */
public class Code1315_1 {

    public int sumEvenGrandparent(TreeNode root) {
        int[] sum = new int[1];
        List<Integer> pathList = new ArrayList<>();
        preTraverseTree(root, sum);
        return sum[0];
    }

    private void preTraverseTree(TreeNode root, int[] sum) {
        if (root != null) {
            if (root.val % 2 == 0) {
                if (root.left != null) {
                    if (root.left.left != null) {
                        sum[0] = sum[0] + root.left.left.val;
                    }
                    if (root.left.right != null) {
                        sum[0] = sum[0] + root.left.right.val;
                    }
                }
                if (root.right != null) {
                    if (root.right.left != null) {
                        sum[0] = sum[0] + root.right.left.val;
                    }
                    if (root.right.right != null) {
                        sum[0] = sum[0] + root.right.right.val;
                    }
                }
            }
            preTraverseTree(root.left, sum);
            preTraverseTree(root.right, sum);
        }
    }
}
