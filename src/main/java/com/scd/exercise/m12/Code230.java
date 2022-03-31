package com.scd.exercise.m12;

import com.scd.exercise.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author James
 */
public class Code230 {

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> valList = new ArrayList<>();
        traverseTree(root, valList);
        valList = valList.stream().sorted().collect(Collectors.toList());
        return valList.get(k - 1);
    }

    private void traverseTree(TreeNode root, List<Integer> valList) {
        if (root != null) {
            valList.add(root.val);
            traverseTree(root.left, valList);
            traverseTree(root.right, valList);
        }
    }
}
