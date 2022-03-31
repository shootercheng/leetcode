package com.scd.exercise.y2021.m1;

import com.scd.exercise.TreeNode;

import java.util.Arrays;

/**
 * @author James
 */
public class Code654 {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        int lenn = nums.length;
        int maxIndex = findMaxIndex(0, lenn, nums);
        TreeNode root = new TreeNode(nums[maxIndex]);
        constructMax(maxIndex, nums, root);
        return root;
    }

    private void constructMax(int maxIndex, int[] nums, TreeNode root) {
        int leftMaxIndex = findMaxIndex(0, maxIndex, nums);
        if (leftMaxIndex != 0) {
            constructMax(maxIndex, nums, root);
        }
        int lenn = nums.length;
    }

    private int findMaxIndex(int start, int end, int[] nums) {
        int maxIndex = -1;
        int max = Integer.MIN_VALUE;
        for (int i = start; i < end; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
