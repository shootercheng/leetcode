package com.scd.exercise;

import java.util.Arrays;

/**
 * @author James
 */
public class CodeOffer55 {

    public int maxDepth(TreeNode root) {
        if (root != null) {
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            return Math.max(left, right) + 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeCommon.createTree(Arrays.asList(1,2,3,4,5));
        CodeOffer55 codeOffer55 = new CodeOffer55();
        System.out.println(codeOffer55.maxDepth(treeNode));
    }
}
