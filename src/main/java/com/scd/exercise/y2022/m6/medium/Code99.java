package com.scd.exercise.y2022.m6.medium;

import com.scd.exercise.TreeCommon;
import com.scd.exercise.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author James
 */
public class Code99 {

    public void recoverTree(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        travelTree(root, list);
        List<TreeNode> sortedList = list.stream().sorted(this::sortVal).collect(Collectors.toList());
        int lens = list.size();
        for (int i = 0; i < lens; i++) {
            TreeNode origin = list.get(i);
            TreeNode sort = sortedList.get(i);
            if (origin.val != sort.val) {
                int temp = origin.val;
                origin.val = sort.val;
                sort.val = temp;
                break;
            }
        }
    }

    private int sortVal(TreeNode treeNode1, TreeNode treeNode2) {
        return Integer.compare(treeNode1.val, treeNode2.val);
    }

    private void travelTree(TreeNode root, List<TreeNode> list) {
        if (root != null) {
            travelTree(root.left, list);
            list.add(root);
            travelTree(root.right, list);
        }
    }

    public static void main(String[] args) {
        TreeNode root = TreeCommon.createNullEleTree(Arrays.asList(5,3,9,-2147483648,2));
        System.out.println(root);
        Code99 code99 = new Code99();
        code99.recoverTree(root);
    }
}
