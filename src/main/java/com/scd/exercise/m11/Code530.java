package com.scd.exercise.m11;

import com.scd.exercise.TreeCommon;
import com.scd.exercise.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * @author James
 */
public class Code530 {

    public int getMinimumDifference(TreeNode root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        List<Integer> valList = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            valList.add(node.val);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        valList = valList.stream().sorted().collect(Collectors.toList());
        int loop = valList.size() - 1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < loop; i++) {
            int subAbs = Math.abs(valList.get(i) - valList.get(i+1));
            if (subAbs < min) {
                min = subAbs;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeCommon.createBinaryTree(Arrays.asList(1, null, 2));
        Code530 code530 = new Code530();
        System.out.println(code530.getMinimumDifference(treeNode));
    }
}
