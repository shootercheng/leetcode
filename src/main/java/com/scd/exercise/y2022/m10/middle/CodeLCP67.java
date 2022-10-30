package com.scd.exercise.y2022.m10.middle;

import com.scd.exercise.TreeCommon;
import com.scd.exercise.TreeNode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * 装饰树
 */
public class CodeLCP67 {

    public TreeNode expandBinaryTree(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            System.out.println(treeNode.val);
            if (treeNode.left != null) {
                queue.offer(treeNode.left);
                TreeNode newNode = new TreeNode(-1);
                TreeNode temp = treeNode.left;
                treeNode.left = newNode;
                newNode.left = temp;
            }
            if (treeNode.right != null) {
                queue.offer(treeNode.right);
                TreeNode newNode = new TreeNode(-1);
                TreeNode temp = treeNode.right;
                treeNode.right = newNode;
                newNode.right = temp;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        CodeLCP67 codeLCP67 = new CodeLCP67();
        codeLCP67.expandBinaryTree(TreeCommon.createBinaryTree(Arrays.asList(7,5,6)));
    }
}
