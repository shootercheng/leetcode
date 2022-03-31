package com.scd.exercise.m11;

import com.scd.exercise.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author James
 */
public class Code129 {

    class PathTree {
        private TreeNode treeNode;

        private StringBuilder path;

        public PathTree(TreeNode treeNode, StringBuilder path) {
            this.treeNode = treeNode;
            this.path = path;
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> resultList = new ArrayList<>();
        if (root == null) {
            return resultList;
        }
        Queue<PathTree> queue = new ArrayDeque<>();
        StringBuilder path = new StringBuilder("");
        PathTree pathTree = new PathTree(root, path);
        queue.offer(pathTree);
        while (!queue.isEmpty()) {
            PathTree node = queue.poll();
            node.path.append(node.treeNode.val);
            if (node.treeNode.left != null) {
                PathTree ltreeNode = new PathTree(node.treeNode.left, new StringBuilder(node.path));
                queue.offer(ltreeNode);
            }
            if (node.treeNode.right != null) {
                PathTree rtreeNode = new PathTree(node.treeNode.right, new StringBuilder(node.path));
                queue.offer(rtreeNode);
            }
            if (node.treeNode.left == null && node.treeNode.right == null) {
                String nodePath = node.path.toString();
                resultList.add(nodePath);
            }
        }
        return resultList;
    }

    public int sumNumbers(TreeNode root) {
        List<String> stringList = binaryTreePaths(root);
        Integer sum = 0;
        for (String s : stringList) {
            sum = sum + Integer.parseInt(s);
        }
        return sum;
    }
}
