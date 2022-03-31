package com.scd.exercise.m12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author James
 */
public class Code797 {

    class Node {
        private int data;

        private List<Integer> path;

        public Node(int data, List<Integer> path) {
            this.data = data;
            this.path = path;
        }
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> allPaths = new ArrayList<>();
        int lenp = graph.length;
        Map<Node, List<Node>> graphMap = new HashMap<>();
        Map<Integer, Node> nodeMap = new HashMap<>();
        for (int i = 0; i < lenp; i++) {
            Node keyNode = createNode(i, nodeMap);
            keyNode.path.add(i);
            List<Node> targetNodes = new ArrayList<>();
            graphMap.put(keyNode, targetNodes);
            for (int j = 0; j < graph[i].length; j++) {
                Node curNode = createNode(graph[i][j], nodeMap);
                targetNodes.add(curNode);
            }
        }
        Node start = nodeMap.get(0);
        Node end = nodeMap.get(lenp - 1);
        traverValGraph(graphMap, start, end, allPaths);
        return allPaths;
    }

    private void traverValGraph(Map<Node, List<Node>> graphMap, Node start, Node end, List<List<Integer>> allPaths) {
        if (start == end) {
            allPaths.add(start.path);
        } else {
            List<Node> targetNodes = graphMap.get(start);
            if (targetNodes != null && targetNodes.size() > 0) {
                for (Node node : targetNodes) {
                    List<Integer> curPath = new ArrayList<>(start.path);
                    curPath.add(node.data);
                    node.path = curPath;
                    traverValGraph(graphMap, node, end, allPaths);
                }
            }
        }
    }

    private Node createNode(int i, Map<Integer, Node> nodeMap) {
        Node node = nodeMap.get(i);
        if (node == null) {
            List<Integer> path = new ArrayList<>();
            node = new Node(i, path);
            nodeMap.put(i, node);
        }
        return node;
    }

    public static void main(String[] args) {
        int[][] graph = {
                {1,2,3},
                {4},
                {4},
                {4},
                {}
        };
        Code797 code797 = new Code797();
        System.out.println(code797.allPathsSourceTarget(graph));
    }

}
