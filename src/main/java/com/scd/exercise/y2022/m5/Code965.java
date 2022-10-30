package com.scd.exercise.y2022.m5;

import com.scd.exercise.TreeNode;

/**
 * @author James
 */
public class Code965 {
    public boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            return false;
        }
        int temp = root.val;
        return travelTree(root, temp, true);
    }

    private boolean travelTree(TreeNode root, int temp, boolean isSame) {
        if (root != null && isSame) {
            if (root.val != temp) {
                return false;
            }
            travelTree(root.left, temp, isSame);
            travelTree(root.right, temp, isSame);
        }
        return isSame;
    }
}
