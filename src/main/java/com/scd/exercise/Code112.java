package com.scd.exercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * @author James
 */
public class Code112 {

    class PathTree {
        private TreeNode treeNode;

        private int sum;

        public PathTree(TreeNode treeNode, int sum) {
            this.treeNode = treeNode;
            this.sum = sum;
        }
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        Queue<PathTree> queue = new ArrayDeque<>();
        int pathNum = root.val;
        PathTree pathTree = new PathTree(root, pathNum);
        queue.offer(pathTree);
        while (!queue.isEmpty()) {
            PathTree node = queue.poll();
            if (node.treeNode.left != null) {
                int leftSum = node.sum + node.treeNode.left.val;
                PathTree ltreeNode = new PathTree(node.treeNode.left, leftSum);
                queue.offer(ltreeNode);
            }
            if (node.treeNode.right != null) {
                int rigthSum = node.sum + node.treeNode.right.val;
                PathTree rtreeNode = new PathTree(node.treeNode.right, rigthSum);
                queue.offer(rtreeNode);
            }
            if (node.treeNode.left == null && node.treeNode.right == null) {
                if (node.sum == sum) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode node = TreeCommon.createTree(Arrays.asList(1,2,3,4,5));
        Code112 code112 = new Code112();
        System.out.println(code112.hasPathSum(node, 7));
        System.out.println(code112.hasPathSum(node, 8));
        System.out.println(code112.hasPathSum(node, 4));
    }

}
