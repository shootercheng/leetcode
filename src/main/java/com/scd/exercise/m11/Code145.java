package com.scd.exercise.m11;

import com.scd.exercise.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author James
 */
public class Code145 {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        postorderTraversal(root, resultList);
        return resultList;
    }

    public void postorderTraversal(TreeNode root, List<Integer> list) {
        if (root != null) {
            postorderTraversal(root.left, list);
            postorderTraversal(root.right, list);
            list.add(root.val);
        }
    }
}
