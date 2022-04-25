package com.scd.exercise.y2022.m4.medium;

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
public class CodeOffer049 {

    class PathTree {
        private TreeNode node;

        private List<Integer> path;

        public PathTree(TreeNode node, List<Integer> path) {
            this.node = node;
            this.path = path;
        }
    }

    public int sumNumbers(TreeNode root) {
        Queue<PathTree> queue = new ArrayDeque<>();
        List<Integer> path = new ArrayList<>();
        path.add(root.val);
        PathTree pathTree = new PathTree(root, path);
        queue.offer(pathTree);
        int sum = 0;
        while (!queue.isEmpty()) {
            PathTree curNode = queue.poll();
            List<Integer> curPath = curNode.path;
            if (curNode.node.left != null) {
                List<Integer> newPath = new ArrayList<>(curPath);
                newPath.add(curNode.node.left.val);
                PathTree newPathTree = new PathTree(curNode.node.left,  newPath);
                queue.offer(newPathTree);
            }
            if (curNode.node.right != null) {
                List<Integer> newPath = new ArrayList<>(curPath);
                newPath.add(curNode.node.right.val);
                PathTree newPathTree = new PathTree(curNode.node.right,  newPath);
                queue.offer(newPathTree);
            }
            if (curNode.node.left == null && curNode.node.right == null) {
                StringBuilder stringBuilder = new StringBuilder();
                for(Integer node : curNode.path) {
                    stringBuilder.append(node);
                }
                sum = sum + Integer.parseInt(stringBuilder.toString());
            }
        }
        return sum;
    }


    public static void main(String[] args) {
        TreeNode treeNode = TreeCommon.createNullEleTree(Arrays.asList(4,9,0,5,1));
        CodeOffer049 codeOffer049 = new CodeOffer049();
        codeOffer049.sumNumbers(treeNode);
    }
}
