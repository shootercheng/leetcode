package com.scd.exercise.y2022.m5.medium;

import com.scd.exercise.TreeCommon;
import com.scd.exercise.TreeNode;

import java.util.Arrays;

/**
 * @author James
 */
public class Code6057 {
    public int averageOfSubtree(TreeNode root) {
        int[] result = new int[1];
        travelTree(root, result);
        return result[0];
    }

    private void travelTree(TreeNode root, int[] result) {
        if (root != null) {
            int averge = calAverage(root);
            if (averge == root.val) {
                result[0]++;
            }
            travelTree(root.left, result);
            travelTree(root.right, result);
        }
    }

    private int calAverage(TreeNode node) {
        int[] arr = new int[2];
        travelTreeAndAdd(node, arr);
        return arr[0] / arr[1];
    }

    private void travelTreeAndAdd(TreeNode temp, int[] arr) {
        if (temp != null) {
            arr[0] = arr[0] + temp.val;
            arr[1] = arr[1] + 1;
            travelTreeAndAdd(temp.left, arr);
            travelTreeAndAdd(temp.right, arr);
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeCommon.createNullEleTree(Arrays.asList(4,8,5,0,1,null,6));
        Code6057 code6057 = new Code6057();
        code6057.averageOfSubtree(treeNode);
    }
}
