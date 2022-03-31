package com.scd.exercise.y2021.m1;

import com.scd.exercise.TreeNode;

/**
 * @author James
 */
public class CodeOffer07 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = new TreeNode(preorder[0]);
        int leni = inorder.length;
        int inIndex = -1;
        for (int i = 0; i < leni; i++) {
            if (inorder[i] == preorder[0]) {
                inIndex = i;
                break;
            }
        }
        createTree(root, preorder, inorder, 1, inIndex, preorder.length);
        return root;
    }

    private void createTree(TreeNode root, int[] preorder, int[] inorder, int preIndex, int inIndex, int count) {
        if (root.val == preorder[0]) {
            root.left = new TreeNode(preorder[preIndex]);
            root.right = new TreeNode();
        } else {

        }
    }
}
