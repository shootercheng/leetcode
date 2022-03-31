package com.scd.exercise.m12;

import com.scd.exercise.TreeNode;

import java.util.ArrayList;

/**
 * @author James
 */
public class Code1448 {

    public int goodNodes(TreeNode root) {
        int[] count = new int[1];
        int max = Integer.MIN_VALUE;
        traverseTree(root, max, count);
        return count[0];
    }

    private void traverseTree(TreeNode root, int max, int[] count) {
        if (root != null) {
            int curVal = root.val;
            if (curVal >= max) {
                count[0]++;
                max = curVal;
            }
            traverseTree(root.left, max, count);
            traverseTree(root.right, max, count);
        }
    }
}
