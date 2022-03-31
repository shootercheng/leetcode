package com.scd.exercise.m12;

import com.scd.exercise.TreeCommon;
import com.scd.exercise.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * @author James
 */
public class Code572 {

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
            node.path.append(node.treeNode.val).append("_");
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

    public boolean isSubtree(TreeNode s, TreeNode t) {
        List<String> sPaths = binaryTreePaths(s);
        List<String> tPaths = binaryTreePaths(t);
        sPaths = sPaths.stream().sorted().collect(Collectors.toList());
        tPaths = tPaths.stream().sorted().collect(Collectors.toList());
        if (sPaths.size() == tPaths.size()) {
            int size = sPaths.size();
            boolean isAllSame = true;
            for (int i = 0; i < size; i++) {
                if (sPaths.get(i).equals(tPaths.get(i))) {
                    isAllSame = false;
                    break;
                }
            }
            if (isAllSame) {
                return true;
            }
        }
        for (String tPath : tPaths) {
            boolean checked = false;
            for (String sPath : sPaths) {
                if (sPath.length() > tPath.length()) {
                    String temp = sPath.substring(0, sPath.length() - tPath.length());
                    if (sPath.endsWith(tPath) && temp.endsWith("_")) {
                        checked = true;
                    }
                }
            }
            if (!checked) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode s = TreeCommon.createBinaryTree(Arrays.asList(3,4,5,1,2));
        TreeNode t = TreeCommon.createBinaryTree(Arrays.asList(4,1,2));
        Code572 code572 = new Code572();
//        System.out.println(code572.isSubtree(s, t));
//        [3,4,5,1,2]
//        [4,1,2,1]
        System.out.println(code572.isSubtree(TreeCommon.createBinaryTree(Arrays.asList(3,4,5,1,2)),
                TreeCommon.createBinaryTree(Arrays.asList(4,1,2,1))));
    }
}
