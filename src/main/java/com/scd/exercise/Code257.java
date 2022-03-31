package com.scd.exercise;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

/**
 * @author James
 */
public class Code257 {

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
            node.path.append("->");
            if (node.treeNode.left != null) {
                PathTree ltreeNode = new PathTree(node.treeNode.left, new StringBuilder(node.path));
                queue.offer(ltreeNode);
            }
            if (node.treeNode.right != null) {
                PathTree rtreeNode = new PathTree(node.treeNode.right, new StringBuilder(node.path));
                queue.offer(rtreeNode);
            }
            if (node.treeNode.left == null && node.treeNode.right == null) {
                String nodePath = node.path.substring(0, node.path.length() - 2);
                resultList.add(nodePath);
            }
        }
        return resultList;
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeCommon.createTree(Arrays.asList(1,2,3,4,5));
        Code257 code257 = new Code257();
        List<String> paths = code257.binaryTreePaths(treeNode);
        System.out.println(paths);
    }
}
