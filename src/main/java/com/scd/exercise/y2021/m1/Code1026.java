package com.scd.exercise.y2021.m1;

import com.scd.exercise.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author James
 */
public class Code1026 {

    public int maxAncestorDiff(TreeNode root) {
        List<Integer> onePath = new ArrayList<>();
        int[] result = new int[1];
        traverseTree(root, onePath, result);
        return result[0];
    }

    private void traverseTree(TreeNode root, List<Integer> onePath, int[] result) {
        if (root != null) {
            onePath.add(root.val);
            if (root.left == null && root.right == null) {
                onePath = onePath.stream().sorted().collect(Collectors.toList());
                int subVal = onePath.get(onePath.size() - 1) - onePath.get(0);
                if (subVal > result[0]) {
                    result[0] = subVal;
                }
            }
            traverseTree(root.left, new ArrayList<>(onePath), result);
            traverseTree(root.right, new ArrayList<>(onePath), result);
        }
    }
}
