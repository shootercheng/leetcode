package com.scd.exercise.m11;

import com.scd.exercise.TreeCommon;
import com.scd.exercise.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * @author James
 */
public class Code437 {

    class SeqNode {
        private TreeNode node;

        private Integer seq;

        public SeqNode(TreeNode node, Integer seq) {
            this.node = node;
            this.seq = seq;
        }
    }

    class PathTree {
        private SeqNode node;

        private List<SeqNode> pathList;


        public PathTree(SeqNode node, List<SeqNode> pathList) {
            this.node = node;
            this.pathList = pathList;
        }
    }

    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        int seq = 0;
        Queue<PathTree> pathTreeQueue = new ArrayDeque<>();
        List<SeqNode> rootList = new ArrayList<>();
        SeqNode rootSeqNode = new SeqNode(root, seq++);
        rootList.add(rootSeqNode);
        PathTree rootPathTree = new PathTree(rootSeqNode, rootList);
        pathTreeQueue.offer(rootPathTree);
        int count = 0;
        Set<String> nodeHashSet = new HashSet<>();
        while (!pathTreeQueue.isEmpty()) {
            PathTree curNode = pathTreeQueue.poll();
            if (curNode.node.node.left != null) {
                List<SeqNode> pathList = new ArrayList<>(curNode.pathList);
                SeqNode seqNode = new SeqNode(curNode.node.node.left, seq++);
                pathList.add(seqNode);
                PathTree leftPathTree = new PathTree(seqNode, pathList);
                pathTreeQueue.offer(leftPathTree);
            }
            if (curNode.node.node.right != null) {
                List<SeqNode> pathList = new ArrayList<>(curNode.pathList);
                SeqNode seqNode = new SeqNode(curNode.node.node.right, seq++);
                pathList.add(seqNode);
                PathTree leftPathTree = new PathTree(seqNode, pathList);
                pathTreeQueue.offer(leftPathTree);
            }
            if (curNode.node.node.left == null && curNode.node.node.right == null) {
                List<SeqNode> onePathList = curNode.pathList;
                int size = onePathList.size();
                for (int i = 0; i < size; i++) {
                    int pathSum = 0;
                    for (int j = i; j < size; j++) {
                        int curNum = onePathList.get(j).node.val;
                        pathSum = pathSum + curNum;
                        if (pathSum == sum) {
                            String hashStr = getSeqStr(i, j, onePathList);
                            if (!nodeHashSet.contains(hashStr)) {
                                nodeHashSet.add(hashStr);
                                count++;
                            }
                        }
                    }
                }
            }
        }
        return count;
    }

    private String getSeqStr(int startIndex, int i, List<SeqNode> onePathList) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int j = startIndex; j <= i; j++) {
            SeqNode treeNode = onePathList.get(j);
            stringBuilder.append(treeNode.seq).append("_");
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Code437 code437 = new Code437();
//        TreeNode root = TreeCommon.createBinaryTree(Arrays.asList(-2,null,-3));
//        System.out.println(code437.pathSum(root, -5));
//        TreeNode root1 = TreeCommon.createBinaryTree(Arrays.asList(10,5,-3,3,2,null,11,3,-2,null,1));
//        System.out.println(code437.pathSum(root1, 8));
//        TreeNode root2 = TreeCommon.createBinaryTree(Arrays.asList(1));
//        System.out.println(code437.pathSum(root2, 1));
        TreeNode root3 = TreeCommon.createBinaryTree(Arrays.asList(1,-2,-3,1,3,-2,null,-1));
        System.out.println(code437.pathSum(root3, -1));
    }
}
