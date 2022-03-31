package com.scd.exercise.m11;

import com.scd.exercise.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author James
 */
public class Code1305 {

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> result = new ArrayList<>();
        traversalBinaryTree(root1, result);
        traversalBinaryTree(root2, result);
        return result.stream().sorted().collect(Collectors.toList());
    }

    public void traversalBinaryTree(TreeNode root, List<Integer> dataList) {
        if (root != null) {
            dataList.add(root.val);
            traversalBinaryTree(root.left, dataList);
            traversalBinaryTree(root.right, dataList);
        }
    }
}
