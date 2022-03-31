package com.scd.exercise.y2021.m8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author James
 */
public class CodeOffer110_1 {
    class Node {
        private int val;

        private List<Integer> path;

        public Node(int val, List<Integer> path) {
            this.val = val;
            this.path = path;
        }
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        Map<Integer, List<Node>> nodeChildMap = new HashMap<>();
        Map<Integer, Node> nodeMap = new HashMap<>();
        int leng = graph.length;
        for (int i = 0; i < leng; i++) {
            Node sNode = createNode(i, nodeMap);
            sNode.path.add(i);
            List<Node> nodeList = nodeChildMap.computeIfAbsent(i, k -> new ArrayList<>());
            for (int g : graph[i]) {
                Node tNode = createNode(g, nodeMap);
                nodeList.add(tNode);
            }
        }
        Node start = nodeMap.get(0);
        Node end = nodeMap.get(leng - 1);
        List<List<Integer>> pathList = new ArrayList<>();
        traverseGraph(start, end, nodeChildMap, pathList);
        return pathList;
    }

    private Node createNode(int i, Map<Integer, Node> nodeMap) {
        Node node = nodeMap.get(i);
        if (node == null) {
            node = new Node(i, new ArrayList<>());
            nodeMap.put(i, node);
        }
        return node;
    }

    private void traverseGraph(Node start, Node end, Map<Integer, List<Node>> nodeMap, List<List<Integer>> pathList) {
        if (start == end) {
            pathList.add(start.path);
        } else {
            List<Node> tNodes = nodeMap.get(start.val);
            if (tNodes == null || tNodes.size() == 0) {
                return;
            }
            for (Node tNode : tNodes) {
                List<Integer> curPath = new ArrayList<>(start.path);
                curPath.add(tNode.val);
                tNode.path = curPath;
                traverseGraph(tNode, end, nodeMap, pathList);
            }
        }
    }

    public static void main(String[] args) {
        int[][] graph = {{1,2},{3},{3},{}};
        CodeOffer110_1 codeOffer110_1 = new CodeOffer110_1();
        System.out.println(codeOffer110_1.allPathsSourceTarget(graph));
    }
}
