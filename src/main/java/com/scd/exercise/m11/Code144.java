package com.scd.exercise.m11;

import com.scd.exercise.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author James
 */
public class Code144 {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorderTraversal(root, result);
        return result;
    }

    public void preorderTraversal(TreeNode root, List<Integer> result) {
        if (root != null) {
            result.add(root.val);
            preorderTraversal(root.left, result);
            preorderTraversal(root.right, result);
        }
    }
}
