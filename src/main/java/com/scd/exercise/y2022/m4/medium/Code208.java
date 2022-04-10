package com.scd.exercise.y2022.m4.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 实现Trie(前缀树)
 * @author James
 */
public class Code208 {

    static class Trie {

        class Node {
            Map<Character, Node> children = new HashMap<>();
            boolean isWord;
        }

        private Node root;

        public Trie() {
            root = new Node();
        }

        public void insert(String word) {
            Node curNode = root;
            char[] wCharArr = word.toCharArray();
            for (char curChar : wCharArr) {
                Node node = curNode.children.get(curChar);
                if (node == null) {
                    node = new Node();
                    curNode.children.put(curChar, node);
                }
                curNode = node;
            }
            curNode.isWord = true;
        }

        public boolean search(String word) {
            Node node = findLastNode(word);
            if (node == null) {
                return false;
            }
            return node.isWord;
        }

        public boolean startsWith(String prefix) {
            return findLastNode(prefix) != null;
        }

        private Node findLastNode(String word) {
            Node curNode = root;
            char[] wCharArr = word.toCharArray();
            for (char curChar : wCharArr) {
                Node node = curNode.children.get(curChar);
                if (node == null) {
                    return null;
                }
                curNode = node;
            }
            return curNode;
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("sunchengdu");
        trie.insert("sunchengdou");
        trie.search("sun");
        trie.search("sunchengdu");
        trie.startsWith("sun");
    }
}
