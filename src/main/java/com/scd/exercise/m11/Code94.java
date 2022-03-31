package com.scd.exercise.m11;

import com.scd.exercise.TreeCommon;
import com.scd.exercise.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 二叉树的中序遍历
 *
 * @author James
 */
public class Code94 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderTraversal(root, result);
        return result;
    }

    private void inorderTraversal(TreeNode root, List<Integer> result) {
        if (root != null) {
            inorderTraversal(root.left, result);
            result.add(root.val);
            inorderTraversal(root.right, result);
        }
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, null, 2, 3);
        TreeNode treeNode = TreeCommon.createNullEleTree(list);
        Code94 code94 = new Code94();
        System.out.println(code94.inorderTraversal(treeNode));
    }
}
