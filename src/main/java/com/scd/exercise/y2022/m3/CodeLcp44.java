package com.scd.exercise.y2022.m3;

import com.scd.exercise.TreeNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author James
 */
public class CodeLcp44 {

    public int numColor(TreeNode root) {
        Set<Integer> num = new HashSet<>();
        travelTree(root, num);
        return num.size();
    }

    private void travelTree(TreeNode root, Set<Integer> num) {
        if (root != null) {
            num.add(root.val);
            travelTree(root.left, num);
            travelTree(root.right, num);
        }
    }
}
