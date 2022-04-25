package com.scd.exercise.y2022.m4.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * 139. 单词拆分
 * @author James
 */
public class Code139 {

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

        public int findLongestIndex(String input) {
            Node curNode = root;
            char[] sCharArr = input.toCharArray();
            int lens = sCharArr.length;
            for (int i = 0; i < lens; i++) {
                char schar = sCharArr[i];
                Node node = curNode.children.get(schar);
                if (node == null) {
                    if (curNode.isKey) {
                        return i;
                    } else {
                        return -1;
                    }
                }
                curNode = node;
            }
            if (curNode.isKey) {
                return lens;
            }
            return -1;
        }
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        TrieTree trieTree = new TrieTree();
        for (String word : wordDict) {
            trieTree.insert(word);
        }
        while (s.length() > 0) {
            int index = trieTree.findLongestIndex(s);
            if (index == -1) {
                return false;
            }
            if (index <= s.length()) {
                s = s.substring(index);
                if ("".equals(s)) {
                    return true;
                }

            }
        }
        return false;
    }

    public static void main(String[] args) {
        Code139 code139 = new Code139();
        code139.wordBreak("bb", Arrays.asList("b","bbb"));
        Stack<Integer> stack = new Stack<>();
    }
}
