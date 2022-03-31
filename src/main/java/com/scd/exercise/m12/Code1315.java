package com.scd.exercise.m12;

import com.scd.exercise.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author James
 */
public class Code1315 {

    public int sumEvenGrandparent(TreeNode root) {
        int[] sum = new int[1];
        List<Integer> pathList = new ArrayList<>();
        preTraverseTree(root, sum, pathList);
        return sum[0];
    }

    private void preTraverseTree(TreeNode root, int[] sum, List<Integer> pathList) {
        if (root != null) {
            pathList.add(root.val);
            if (pathList.size() == 3) {
                Integer parent = pathList.remove(0);
                if (parent % 2 == 0) {
                    sum[0] = sum[0] + root.val;
                }
            }
            preTraverseTree(root.left, sum, new ArrayList<>(pathList));
            preTraverseTree(root.right, sum, new ArrayList<>(pathList));
        }
    }
}
