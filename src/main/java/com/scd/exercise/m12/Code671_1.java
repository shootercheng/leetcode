package com.scd.exercise.m12;

import com.scd.exercise.TreeCommon;
import com.scd.exercise.TreeNode;

import java.util.Arrays;

/**
 * @author James
 */
public class Code671_1 {

    public int findSecondMinimumValue(TreeNode root) {
        int[] nums = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        preTraverseTree(root, nums);
        if (nums[1] == Integer.MAX_VALUE) {
            return -1;
        }
        return nums[1];
    }

    private void preTraverseTree(TreeNode root, int[] nums) {
        if (root != null) {
            int curVal = root.val;
            if (curVal != nums[0] && curVal != nums[1]) {
                if (curVal < nums[0]) {
                    int temp = nums[0];
                    nums[0] = curVal;
                    nums[1] = temp;
                } else if (curVal < nums[1]) {
                    nums[1] = curVal;
                }
            }
            preTraverseTree(root.left, nums);
            preTraverseTree(root.right, nums);
        }
    }

    public static void main(String[] args) {
        Code671_1 code671 = new Code671_1();
        TreeNode root = TreeCommon.createBinaryTree(Arrays.asList(2,2,2147483647));
        System.out.println(code671.findSecondMinimumValue(root));
    }
}
