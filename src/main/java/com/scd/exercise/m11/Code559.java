package com.scd.exercise.m11;

import com.scd.exercise.Node;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

/**
 * @author James
 */
public class Code559 {

    class LevelNode {
        private Node node;

        private Integer level;

        public LevelNode(Node node, Integer level) {
            this.node = node;
            this.level = level;
        }
    }

    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        Queue<LevelNode> levelNodeQueue = new ArrayDeque<>();
        LevelNode rootLevelNode = new LevelNode(root, 1);
        levelNodeQueue.offer(rootLevelNode);
        int maxDepth = 0;
        while (!levelNodeQueue.isEmpty()) {
            LevelNode curNode = levelNodeQueue.poll();
            int nextLevel = curNode.level + 1;
            List<Node> childList = curNode.node.children;
            if (childList != null) {
                for (Node node : childList) {
                    LevelNode curLevelNode = new LevelNode(node, nextLevel);
                    levelNodeQueue.offer(curLevelNode);
                }
            }
            maxDepth = nextLevel;
        }
        return maxDepth - 1;
    }
}
