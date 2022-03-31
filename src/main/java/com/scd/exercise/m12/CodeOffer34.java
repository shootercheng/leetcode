package com.scd.exercise.m12;

import com.scd.exercise.CodeOffer39;
import com.scd.exercise.TreeCommon;
import com.scd.exercise.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author James
 */
public class CodeOffer34 {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> resultList = new ArrayList<>();
        List<Integer> pathList = new ArrayList<>();
        dfsTraverseTree(root, sum, pathList, resultList);
        return resultList;
    }

    private void dfsTraverseTree(TreeNode root, int sum, List<Integer> pathList, List<List<Integer>> resultList) {
        if (root != null) {
            pathList.add(root.val);
            if (root.left == null && root.right == null) {
                int calSum = calPathSum(pathList);
                if (sum == calSum) {
                    resultList.add(pathList);
                }
            }
            dfsTraverseTree(root.left, sum, new ArrayList<>(pathList), resultList);
            dfsTraverseTree(root.right, sum, new ArrayList<>(pathList), resultList);
        }
    }

    private int calPathSum(List<Integer> pathList) {
        int sum = 0;
        for (Integer num : pathList) {
            sum = sum + num;
        }
        return sum;
    }

    public static void main(String[] args) {
        TreeNode root = TreeCommon.createBinaryTree(Arrays.asList(5,4,8,11,null,13,4,7,2,null,null,5,1));
        CodeOffer34 codeOffer34 = new CodeOffer34();
        System.out.println(codeOffer34.pathSum(root, 22));
    }
}
