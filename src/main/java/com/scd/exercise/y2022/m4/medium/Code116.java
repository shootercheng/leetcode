package com.scd.exercise.y2022.m4.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * 116. 填充每个节点的下一个右侧节点指针
 * @author James
 */
public class Code116 {

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    class LevelNode {
        Node node;

        int level;

        public LevelNode(Node node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        Queue<LevelNode> queue = new ArrayDeque<>();
        LevelNode levelNode = new LevelNode(root, 1);
        Map<Integer, List<Node>> levelNodeMap = new HashMap<>();
        queue.offer(levelNode);
        while (!queue.isEmpty()) {
            LevelNode curNode = queue.poll();
            int level = curNode.level;
            List<Node> nodeList = levelNodeMap.computeIfAbsent(level, k -> new ArrayList<>());
            int nSize = nodeList.size();
            if (nSize > 0) {
                nodeList.get(nSize - 1).next = curNode.node;
            }
            nodeList.add(curNode.node);
            if (curNode.node.left != null) {
                LevelNode newNode = new LevelNode(curNode.node.left, level+1);
                queue.offer(newNode);
            }
            if (curNode.node.right != null) {
                LevelNode newNode = new LevelNode(curNode.node.right, level+1);
                queue.offer(newNode);
            }
        }
        return root;
    }
}
