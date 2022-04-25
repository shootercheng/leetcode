package com.scd.exercise.y2022.m4.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author James
 */
public class Code1713 {

    class TrieTree {

        class Node {
            private Map<Character, Node> children = new HashMap<>();

            private boolean isKey;
        }

        private Node root;

        public TrieTree() {
            root = new Node();
        }

        public void insert(String dict) {
            Node curNode = root;
            char[] dicArr = dict.toCharArray();
            for (char dic : dicArr) {
                Node node = curNode.children.get(dic);
                if (node == null) {
                    node = new Node();
                    curNode.children.put(dic, node);
                }
                curNode = node;
            }
            curNode.isKey = true;
        }

        public String findLongestIndex(String input) {
            Node curNode = root;
            char[] sCharArr = input.toCharArray();
            int lens = sCharArr.length;
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < lens; i++) {
                char schar = sCharArr[i];
                Node node = curNode.children.get(schar);
                if (node == null) {
                    if (!curNode.isKey) {

                    }
                }
                curNode = node;
            }
            return "";
        }
    }
}
