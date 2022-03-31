package com.scd.exercise;

import java.util.Arrays;

/**
 * @author James
 */
public class Code104 {
    public int maxDepth(TreeNode root) {
        if (root != null) {
            int leftDepth = maxDepth(root.left);
            int rightDepth = maxDepth(root.right);
            int maxDepth = leftDepth > rightDepth ? leftDepth : rightDepth;
            return maxDepth + 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        Code104 code104 = new Code104();
        TreeNode treeNode = TreeCommon.createTree(Arrays.asList(1,2));
        System.out.println(code104.maxDepth(treeNode));
    }
}
