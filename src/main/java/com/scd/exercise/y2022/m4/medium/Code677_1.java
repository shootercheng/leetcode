package com.scd.exercise.y2022.m4.medium;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author James
 */
public class Code677_1 {

    static class MapSum {

        class Node {
            private Map<Character, Node> children = new HashMap<>();

            private int val;

            private boolean isKey;
        }

        private Node root;

        /** Initialize your data structure here. */
        public MapSum() {
            root = new Node();
        }

        public void insert(String key, int val) {
            Node curNode = root;
            char[] keyArr = key.toCharArray();
            for (char keyc : keyArr) {
                Node node = curNode.children.get(keyc);
                if (node == null) {
                    node = new Node();
                    curNode.children.put(keyc, node);
                }
                curNode = node;
            }
            curNode.isKey = true;
            curNode.val = val;
        }

        public int sum(String prefix) {
            Node node = findLastNode(prefix);
            int[] sum = new int[1];
            if (node != null) {
                if (node.isKey) {
                    sum[0] = sum[0] + node.val;
                }
                findWord(node, sum);
            }
            return sum[0];
        }

        public void findWord(Node node, int[] sum) {
            if (node.children.size() == 0) {
                return;
            }
            Map<Character, Node> map = node.children;
            for (Map.Entry<Character, Node> entry : map.entrySet()) {
                Node curNode = entry.getValue();
                if (curNode.isKey) {
                    sum[0] = sum[0] + curNode.val;
                }
                findWord(curNode, sum);
            }
        }

        public Node findLastNode(String prefix) {
            Node curNode = root;
            char[] preArr = prefix.toCharArray();
            for (char pchar : preArr) {
                Node node = curNode.children.get(pchar);
                if (node != null) {
                    curNode = node;
                } else {
                    return null;
                }
            }
            return curNode;
        }
    }

    public static void main(String[] args) {
        MapSum mapSum = new MapSum();
        mapSum.insert("a", 3);
        mapSum.sum("ap");
        mapSum.insert("app", 2);
        mapSum.sum("ap");
    }
}
