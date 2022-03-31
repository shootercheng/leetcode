package com.scd.exercise.m11;

import com.scd.exercise.TreeCommon;
import com.scd.exercise.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * @author James
 */
public class Code988 {

    private static Map<Integer, Character> NUM_CHAR = new HashMap<>();

    static {
        for (int i = 0; i < 26; i++) {
            char tempChar = (char) ('a' + i);
            NUM_CHAR.put(i, tempChar);
        }
    }

    class PathTree {
        private TreeNode node;

        private StringBuilder path;

        PathTree(TreeNode node, StringBuilder path) {
            this.node = node;
            this.path = path;
        }
    }

    public String smallestFromLeaf(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<PathTree> pathTreeQueue = new ArrayDeque<>();
        StringBuilder rootBuilder = new StringBuilder();
        rootBuilder.append(NUM_CHAR.get(root.val));
        PathTree pathTree = new PathTree(root, rootBuilder);
        pathTreeQueue.offer(pathTree);
        List<String> pathList = new ArrayList<>();
        while (!pathTreeQueue.isEmpty()) {
            PathTree curNode = pathTreeQueue.poll();
            if (curNode.node.left != null) {
                StringBuilder path = new StringBuilder();
                path.append(curNode.path).append(NUM_CHAR.get(curNode.node.left.val));
                PathTree left = new PathTree(curNode.node.left, path);
                pathTreeQueue.offer(left);
            }
            if (curNode.node.right != null) {
                StringBuilder path = new StringBuilder();
                path.append(curNode.path).append(NUM_CHAR.get(curNode.node.right.val));
                PathTree right = new PathTree(curNode.node.right, path);
                pathTreeQueue.offer(right);
            }
            if (curNode.node.left == null && curNode.node.right == null) {
                pathList.add(curNode.path.reverse().toString());
            }
        }
        pathList = pathList.stream().sorted().collect(Collectors.toList());
        return pathList.get(0);
    }

    public static void main(String[] args) {
        Code988 code998 = new Code988();
        TreeNode treeNode = TreeCommon.createBinaryTree(Arrays.asList(0));
        System.out.println(code998.smallestFromLeaf(treeNode));
    }
}
