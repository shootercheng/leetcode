package com.scd.exercise.y2021.m3;

import com.scd.exercise.TreeNode;

/**
 * @author James
 */
public class Code654 {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        int max = Integer.MIN_VALUE;
        int lenn = nums.length;
        int maxIndex = -1;
        for (int i = 0; i < lenn; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }
        TreeNode root = new TreeNode(max);
        createTree(root, 0, maxIndex,nums.length - 1, nums);
        return root;
    }

    public void createTree(TreeNode treeNode, int startIndex, int maxIndex, int rightIndex, int[] nums) {
        int leftMax = Integer.MIN_VALUE;
        int leftMaxIndex = -1;
        for (int i = startIndex; i < maxIndex; i++) {
            if (nums[i] > leftMax) {
                leftMax = nums[i];
                leftMaxIndex = i;
            }
        }
        if (leftMaxIndex != -1) {
            treeNode.left = new TreeNode(leftMax);
            createTree(treeNode.left, startIndex, leftMaxIndex, maxIndex - 1, nums);
        }
        int rightMax = Integer.MIN_VALUE;
        int rightMaxIndex = -1;
        for (int i = maxIndex + 1; i <= rightIndex; i++) {
            if (nums[i] > rightMax) {
                rightMax = nums[i];
                rightMaxIndex = i;
            }
        }
        if (rightMaxIndex != -1) {
            treeNode.right = new TreeNode(rightMax);
            createTree(treeNode.right, maxIndex + 1, rightMaxIndex, rightIndex, nums);
        }
    }

    public static void main(String[] args) {
        Code654 code654 = new Code654();
        int[] nums = {3,2,1,6,0,5};
        code654.constructMaximumBinaryTree(nums);
    }
}
