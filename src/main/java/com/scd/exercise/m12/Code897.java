package com.scd.exercise.m12;

import com.scd.exercise.TreeCommon;
import com.scd.exercise.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author James
 */
public class Code897 {

    public TreeNode increasingBST(TreeNode root) {
        List<Integer> dataList = new ArrayList<>();
        traverseTree(root, dataList);
        int dataSize = dataList.size();
        if (dataSize == 0) {
            return null;
        }
        TreeNode result = new TreeNode(dataList.get(0));
        TreeNode temp = result;
        for (int i = 1; i < dataSize; i++) {
            TreeNode node = new TreeNode(dataList.get(i));
            temp.right = node;
            temp = node;
        }
        return result;
    }

    private void traverseTree(TreeNode root, List<Integer> dataList) {
        if (root != null) {
            traverseTree(root.left, dataList);
            dataList.add(root.val);
            traverseTree(root.right, dataList);
        }
    }

    public static void main(String[] args) {
        List<Integer> inputList = Arrays.asList(5,3,6,2,4,null,8,1,null,null,null,7,9);
        TreeNode root = TreeCommon.createBinaryTree(inputList);
        Code897 code897 = new Code897();
        TreeNode result = code897.increasingBST(root);
        System.out.println(result);
    }
}
