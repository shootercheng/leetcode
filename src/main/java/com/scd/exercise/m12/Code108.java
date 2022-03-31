package com.scd.exercise.m12;

import com.scd.exercise.TreeNode;

/**
 * @author James
 */
public class Code108 {

    public TreeNode sortedArrayToBST(int[] nums) {
        int lenn = nums.length;
        if (lenn == 0) {
            return new TreeNode();
        }
        int mid = lenn / 2;
        TreeNode root = new TreeNode(nums[mid]);
        TreeNode temp = root;
        for (int i = 0; i < mid; i++) {
            TreeNode curNode = new TreeNode(nums[i]);
            temp.left = curNode;
            temp = curNode;
        }
        temp = root;
        for (int i = mid + 1; i < lenn; i++) {
            TreeNode curNode = new TreeNode(nums[i]);
            temp.right = curNode;
            temp = curNode;
        }
        return root;
    }
}
