package com.scd.exercise.y2022.m5.medium;

import com.scd.exercise.TreeCommon;
import com.scd.exercise.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 面试题 04.06. 后继者
 * @author James
 */
public class CodeM0406 {

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        List<TreeNode> treeNodeList = new ArrayList<>();
        travelTree(root, treeNodeList, p);
        int lent = treeNodeList.size();
        int index = -1;
        for (int i = 0; i < lent; i++) {
            if (treeNodeList.get(i) == p) {
                index = i;
                break;
            }
        }
        if (index + 1 < lent) {
            return treeNodeList.get(index + 1);
        }
        return null;
    }

    public TreeNode travelTree(TreeNode root, List<TreeNode> treeNodeList, TreeNode p) {
        if (root != null) {
            travelTree(root.left, treeNodeList, p);
            treeNodeList.add(root);
            travelTree(root.right, treeNodeList, p);
        }
        return null;
    }

    public static void main(String[] args) {
        TreeNode root = TreeCommon.createNullEleTree(Arrays.asList(2,null,3));
        CodeM0406 codeM0406 = new CodeM0406();
        codeM0406.inorderSuccessor(root, new TreeNode(3));
    }
}
