package com.scd.exercise.y2022.m3;

import com.scd.exercise.CodeOffer05;
import com.scd.exercise.TreeCommon;
import com.scd.exercise.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author James
 */
public class CodeOffer052 {

    public TreeNode increasingBST(TreeNode root) {
        List<Integer> dataList = new ArrayList<>();
        travelTree(root, dataList);
        TreeNode tree = new TreeNode();
        TreeNode temp = tree;
        for (int i = 0; i < dataList.size(); i++) {
            TreeNode newTreeNode = new TreeNode(dataList.get(i));
            temp.right = newTreeNode;
            temp = newTreeNode;
        }
        return tree.right;
    }

    private void travelTree(TreeNode treeNode, List<Integer> dataList) {
        if (treeNode != null) {
            travelTree(treeNode.left, dataList);
            dataList.add(treeNode.val);
            travelTree(treeNode.right, dataList);
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeCommon.createNullEleTree(Arrays.asList(5,3,6,2,4,null,8,1,null,null,null,7,9));
        CodeOffer052 codeOffer052 = new CodeOffer052();
        codeOffer052.increasingBST(treeNode);
    }
}
