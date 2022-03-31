package com.scd.exercise.y2021.m3;

import com.scd.exercise.TreeCommon;
import com.scd.exercise.TreeNode;

import java.util.Arrays;

/**
 * @author James
 */
public class Code606 {

    public String tree2str(TreeNode t) {
        StringBuilder res = new StringBuilder();
        preTraverseTree(t, res);
        return res.toString();
    }

    private void preTraverseTree(TreeNode t, StringBuilder res) {
        if (t != null) {
            res.append(t.val);
            preTraverseTree(t.left, res);
            preTraverseTree(t.right, res);
        }
    }

    public static void main(String[] args) {
        Code606 code606 = new Code606();
        TreeNode treeNode = TreeCommon.createBinaryTree(Arrays.asList(1,2,3,4));
        System.out.println(code606.tree2str(treeNode));
//        TreeNode treeNode1 = TreeCommon.createBinaryTree(Arrays.asList(1,2,3,null,4));
//        System.out.println(code606.tree2str(treeNode1));
    }
}
