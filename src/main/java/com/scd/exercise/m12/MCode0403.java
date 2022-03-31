package com.scd.exercise.m12;

import com.scd.exercise.ListNode;
import com.scd.exercise.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * @author James
 */
public class MCode0403 {

    class LevelTree {
        private TreeNode node;

        private int level;

        public LevelTree(TreeNode node, Integer level) {
            this.node = node;
            this.level = level;
        }
    }

    public ListNode[] listOfDepth(TreeNode root) {
        if (root == null) {
            return null;
        }
        LevelTree rootTree = new LevelTree(root, 0);
        Queue<LevelTree> queue = new ArrayDeque<>();
        queue.offer(rootTree);
        Map<Integer, List<Integer>> levelMap = new HashMap<>();
        while (!queue.isEmpty()) {
            LevelTree node = queue.poll();
            int curLevel = node.level;
            List<Integer> rowList = levelMap.computeIfAbsent(curLevel, k -> new ArrayList<>());
            rowList.add(node.node.val);
            if (node.node.left != null) {
                LevelTree levelTree = new LevelTree(node.node.left, curLevel + 1);
                queue.offer(levelTree);
            }
            if (node.node.right != null) {
                LevelTree levelTree = new LevelTree(node.node.right, curLevel + 1);
                queue.offer(levelTree);
            }
        }
        int size = levelMap.size();
        ListNode[] result = new ListNode[size];
        for (int i = 0; i < size; i++) {
            result[i] = createListNode(levelMap.get(i));
        }
        return result;
    }

    private ListNode createListNode(List<Integer> list) {
        ListNode root = new ListNode();
        ListNode temp = root;
        for (Integer nodeval : list) {
            ListNode curNode = new ListNode(nodeval);
            temp.next = curNode;
            temp = curNode;
        }
        return root.next;
    }
}
