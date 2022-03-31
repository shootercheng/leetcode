package com.scd.exercise.y2021.m1;

import com.scd.exercise.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author James
 */
public class MCode1712 {

    public TreeNode convertBiNode(TreeNode root) {
        List<Integer> valList = new ArrayList<>();
        traverseTree(root, valList);
        valList = valList.stream().sorted().collect(Collectors.toList());
        int vSize = valList.size();
        if (vSize == 0) {
            return null;
        }
        TreeNode result = new TreeNode(valList.get(0));
        TreeNode temp = result;
        for (int i = 1; i < vSize; i++) {
            TreeNode curNode = new TreeNode(valList.get(i));
            temp.right = curNode;
            temp = curNode;
        }
        return result;
    }

    private void traverseTree(TreeNode root, List<Integer> valList) {
        if (root != null) {
            valList.add(root.val);
            traverseTree(root.left, valList);
            traverseTree(root.right, valList);
        }
    }
}
