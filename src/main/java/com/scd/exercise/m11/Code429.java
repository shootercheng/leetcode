package com.scd.exercise.m11;

import com.scd.exercise.Node;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * @author James
 */
public class Code429 {

    class LevelTree {
        private Node node;

        private Integer level;

        public LevelTree(Node node, Integer level) {
            this.node = node;
            this.level = level;
        }
    }

    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<LevelTree> queue = new ArrayDeque<>();
        LevelTree rootTree = new LevelTree(root, 1);
        queue.offer(rootTree);
        Map<Integer, List<Integer>> levelValMap = new HashMap<>();
        while (!queue.isEmpty()) {
            LevelTree curLevelTree = queue.poll();
            Integer curLevel = curLevelTree.level;
            List<Integer> valList = levelValMap.computeIfAbsent(curLevel, k -> new ArrayList<>());
            valList.add(curLevelTree.node.val);
            if (curLevelTree.node.children != null) {
                List<Node> childList = curLevelTree.node.children;
                Integer childLevel = curLevel + 1;
                for (Node node : childList) {
                    LevelTree nodeLevelTree = new LevelTree(node, childLevel);
                    queue.offer(nodeLevelTree);
                }
            }
        }
        List<Integer> levelList = levelValMap.keySet().stream().sorted().collect(Collectors.toList());
        List<List<Integer>> result = new ArrayList<>();
        for (Integer level : levelList) {
            result.add(levelValMap.get(level));
        }
        return result;
    }
}
