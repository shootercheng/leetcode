package com.scd.exercise.m11;

import com.scd.exercise.TreeNode;

import java.util.List;

/**
 * @author James
 */
public class Code617_1 {

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        return null;
    }
}
