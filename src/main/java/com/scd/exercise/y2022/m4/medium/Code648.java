package com.scd.exercise.y2022.m4.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 648. 单词替换
 * @author James
 */
public class Code648 {

    class TrieTree {

        class Node {
            Map<Character, Node> children = new HashMap<>();

            boolean isKey;
        }

        private Node root;

        public TrieTree() {
            root = new Node();
        }

        public void insert(String keyWord) {
            Node curNode = root;
            char[] keyArr = keyWord.toCharArray();
            for (char keyChar : keyArr) {
                Node node = curNode.children.get(keyChar);
                if (node == null) {
                    node = new Node();
                    curNode.children.put(keyChar, node);
                }
                curNode = node;
            }
            curNode.isKey = true;
        }

        public String findLastNode(String word) {
            Node curNode = root;
            char[] wCharArr = word.toCharArray();
            StringBuilder stringBuilder = new StringBuilder();
            for (char wchar : wCharArr) {
                Node node = curNode.children.get(wchar);
                if (node != null) {
                    curNode = node;
                } else {
                    break;
                }
                stringBuilder.append(wchar);
                if (curNode.isKey) {
                    return stringBuilder.toString();
                }
            }
            return word;
        }
    }


    public String replaceWords(List<String> dictionary, String sentence) {
        TrieTree trieTree = new TrieTree();
        for (String dic : dictionary) {
            trieTree.insert(dic);
        }
        String[] sentenceArr = sentence.split("\\s+");
        StringBuilder result = new StringBuilder();
        int lens = sentenceArr.length;
        for (int i = 0; i < lens; i++) {
            result.append(trieTree.findLastNode(sentenceArr[i]));
            if (i != lens -1) {
                result.append(" ");
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Code648 code648 = new Code648();
        code648.replaceWords(Arrays.asList("cat","bat","rat"), "the cattle was rattled by the battery");
    }
}
