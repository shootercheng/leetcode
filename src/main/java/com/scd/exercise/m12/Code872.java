package com.scd.exercise.m12;

import com.scd.exercise.TreeCommon;
import com.scd.exercise.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

/**
 * @author James
 */
public class Code872 {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> dataList1 = new ArrayList<>();
        List<Integer> dataList2 = new ArrayList<>();
        traverseTree(root1, dataList1);
        traverseTree(root2, dataList2);
        int lendata1 = dataList1.size();
        int lendata2 = dataList2.size();
        if (lendata1 != lendata2) {
            return false;
        }
        for (int i = 0; i < lendata1; i++) {
            if (dataList1.get(i).intValue() != dataList2.get(i)) {
                return false;
            }
        }
        return true;
    }

    private void traverseTree(TreeNode root, List<Integer> dataList) {
        if (root != null) {
            if (root.left == null && root.right == null) {
                dataList.add(root.val);
            }
            traverseTree(root.left, dataList);
            traverseTree(root.right, dataList);
        }
    }

    public static void main(String[] args) {
//        [3,5,1,6,2,9,8,null,null,7,4]
//[3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]
        TreeNode tree1 = TreeCommon.createBinaryTree(Arrays.asList(3,5,1,6,2,9,8,null,null,7,4));
        TreeNode tree2 = TreeCommon.createBinaryTree(Arrays.asList(3,5,1,6,7,4,2,null,null,null,null,null,null,9,8));
        Code872 code872 = new Code872();
        System.out.println(code872.leafSimilar(tree1, tree2));
    }
}
