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
public class CodeOffer32 {

    class LevelTree {
        private TreeNode treeNode;

        private int level;

        public LevelTree(TreeNode treeNode, int level) {
            this.treeNode = treeNode;
            this.level = level;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        LevelTree rootLevel = new LevelTree(root, 0);
        Queue<LevelTree> queue = new ArrayDeque<>();
        queue.offer(rootLevel);
        Map<Integer, List<Integer>> levelValueMap = new HashMap<>();
        while (!queue.isEmpty()) {
            LevelTree node = queue.poll();
            int currentLevel = node.level;
            List<Integer> list = levelValueMap.computeIfAbsent(currentLevel, k -> new ArrayList<>());
            list.add(node.treeNode.val);
            if (node.treeNode.left != null) {
                int level = currentLevel + 1;
                LevelTree levelTree = new LevelTree(node.treeNode.left, level);
                queue.offer(levelTree);
            }
            if (node.treeNode.right != null) {
                int level = currentLevel + 1;
                LevelTree levelTree = new LevelTree(node.treeNode.right, level);
                queue.offer(levelTree);
            }
        }
        List<Integer> levelList = levelValueMap.keySet().stream().sorted().collect(Collectors.toList());
        for (int i = 0; i < levelList.size(); i++) {
            if (i % 2 == 0) {
                result.add(levelValueMap.get(levelList.get(i)));
            } else {
                List<Integer> values = levelValueMap.get(levelList.get(i));
                List<Integer> dataList = reverseList(values);
                result.add(dataList);
            }
        }
        return result;
    }

    private List<Integer> reverseList(List<Integer> values) {
        List<Integer> dataList = new ArrayList<>();
        for (int j = values.size() - 1; j >= 0; j--) {
            dataList.add(values.get(j));
        }
        return dataList;
    }

    public static void main(String[] args) {
        List<Integer> inputList = Arrays.asList(3,9,20,null,null,15,7);
        TreeNode treeNode = TreeCommon.createNullEleTree(inputList);
        CodeOffer32 codeOffer32 = new CodeOffer32();
        System.out.println(codeOffer32.levelOrder(treeNode));
    }
}
