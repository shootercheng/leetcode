package com.scd.exercise;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * @author James
 */
public class Code107 {

    class LevelTreeNode {
        private Integer level;

        private TreeNode treeNode;

        public LevelTreeNode(Integer level, TreeNode treeNode) {
            this.treeNode = treeNode;
            this.level = level;
        }

        public Integer getLevel() {
            return level;
        }
    }

    public List<List<Integer>> traverseList(TreeNode root) {
        List<List<Integer>> resultList = new ArrayList<>();
        if (root == null) {
            return resultList;
        }
        List<LevelTreeNode> list = new ArrayList<>();
        Queue<LevelTreeNode> queue = new ArrayDeque<>();
        LevelTreeNode levelTreeNode = new LevelTreeNode(1, root);
        list.add(levelTreeNode);
        queue.offer(levelTreeNode);
        while (!queue.isEmpty()) {
            LevelTreeNode node = queue.poll();
            Integer level = node.level;
            System.out.print(node.treeNode.val + " ");
            level = level + 1;
            if (node.treeNode.left != null) {
                LevelTreeNode leftLevelNode = new LevelTreeNode(level, node.treeNode.left);
                queue.offer(leftLevelNode);
                list.add(leftLevelNode);
            }
            if (node.treeNode.right != null) {
                LevelTreeNode rightLevelNode = new LevelTreeNode(level, node.treeNode.right);
                queue.offer(rightLevelNode);
                list.add(rightLevelNode);
            }
        }
        System.out.println(list);
        Map<Integer, List<LevelTreeNode>> listMap = list.stream().collect(Collectors.groupingBy(LevelTreeNode::getLevel));
        System.out.println(listMap);
        return resultList;
    }

    public List<List<Integer>> traverseList2(TreeNode root) {
        List<List<Integer>> resultList = new ArrayList<>();
        if (root == null) {
            return resultList;
        }
        Queue<LevelTreeNode> queue = new ArrayDeque<>();
        LevelTreeNode levelTreeNode = new LevelTreeNode(1, root);
        queue.offer(levelTreeNode);
        Map<Integer, List<Integer>> levelValMap = new LinkedHashMap<>();
        levelValMap.put(1, Arrays.asList(root.val));
        while (!queue.isEmpty()) {
            LevelTreeNode node = queue.poll();
            Integer level = node.level + 1;
            List<Integer> list = levelValMap.computeIfAbsent(level, k -> new ArrayList<>());
            if (node.treeNode.left != null) {
                LevelTreeNode leftLevelNode = new LevelTreeNode(level, node.treeNode.left);
                queue.offer(leftLevelNode);
                list.add(node.treeNode.left.val);
            }
            if (node.treeNode.right != null) {
                LevelTreeNode rightLevelNode = new LevelTreeNode(level, node.treeNode.right);
                queue.offer(rightLevelNode);
                list.add(node.treeNode.right.val);
            }
        }
        Stack<List<Integer>> stack = new Stack<>();
        levelValMap.forEach((level, list) -> {
            if (list.size() > 0) {
                stack.push(list);
            }
        });
        while (!stack.isEmpty()) {
            resultList.add(stack.pop());
        }
        return resultList;
    }

    public static void main(String[] args) {
        List<Integer> list =  Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        TreeNode root = TreeCommon.createTree(list);
        List<Integer> numList = new ArrayList<>();
        numList.add(0,1);
        numList.add(0,2);
        numList.add(0,3);
        System.out.println(numList);
        Code107 code107 = new Code107();
        code107.traverseList2(root);
    }
}
