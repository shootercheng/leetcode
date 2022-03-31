package com.scd.exercise;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

/**
 * @author James
 */
public class Code113 {

    class PathTree {
        private TreeNode treeNode;

        private int sum;

        private List<Integer> nodeVal;

        public PathTree(TreeNode treeNode, int sum, List<Integer> nodeVal) {
            this.treeNode = treeNode;
            this.sum = sum;
            this.nodeVal = nodeVal;
        }
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> resultList = new ArrayList<>();
        if (root == null) {
            return resultList;
        }
        Queue<PathTree> queue = new ArrayDeque<>();
        int pathNum = root.val;
        List<Integer> nodeValList = new ArrayList<>();
        nodeValList.add(pathNum);
        PathTree pathTree = new PathTree(root, pathNum, nodeValList);
        queue.offer(pathTree);
        while (!queue.isEmpty()) {
            PathTree node = queue.poll();
            if (node.treeNode.left != null) {
                int leftSum = node.sum + node.treeNode.left.val;
                List<Integer> nodeList = new ArrayList<>();
                nodeList.addAll(node.nodeVal);
                nodeList.add(node.treeNode.left.val);
                PathTree ltreeNode = new PathTree(node.treeNode.left, leftSum, nodeList);
                queue.offer(ltreeNode);
            }
            if (node.treeNode.right != null) {
                int rigthSum = node.sum + node.treeNode.right.val;
                List<Integer> nodeList = new ArrayList<>();
                nodeList.addAll(node.nodeVal);
                nodeList.add(node.treeNode.right.val);
                PathTree rtreeNode = new PathTree(node.treeNode.right, rigthSum, nodeList);
                queue.offer(rtreeNode);
            }
            if (node.treeNode.left == null && node.treeNode.right == null) {
                if (node.sum == sum) {
                    resultList.add(node.nodeVal);
                }
            }
        }
        return resultList;
    }

    public static void main(String[] args) {
        TreeNode node = TreeCommon.createTree(Arrays.asList(1,2,3,4,5));
        Code113 code112 = new Code113();
        System.out.println(code112.pathSum(node, 7));
        System.out.println(code112.pathSum(node, 8));
        System.out.println(code112.pathSum(node, 4));
    }
}
