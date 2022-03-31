package com.scd.exercise.m12;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * @author James
 */
public class Code211 {

    static class WordDictionary {
        private Map<Integer, Set<String>> dictMap;

        /** Initialize your data structure here. */
        public WordDictionary() {
            dictMap = new HashMap<>();
        }

        /** Adds a word into the data structure. */
        public void addWord(String word) {
            int lenw = word.length();
            Set<String> wordSet = dictMap.computeIfAbsent(lenw, k -> new HashSet<>());
            wordSet.add(word);
        }

        /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
        public boolean search(String word) {
            int lenw = word.length();
            Set<String> wordSet = dictMap.get(lenw);
            if (wordSet == null) {
                return false;
            }
            if (word.contains(".")) {
                String regexWord = word.replaceAll("\\.", "\\\\w");
                Pattern pattern = Pattern.compile(regexWord);
                for (String wd : wordSet) {
                    if (pattern.matcher(wd).matches()) {
                        return true;
                    }
                }
                return false;
            } else {
                return wordSet.contains(word);
            }
        }
    }

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("b\\w\\w");
        if (pattern.matcher("bcc").matches()) {
            System.out.println("bcc");
        }
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bcc");
        wordDictionary.addWord("acc");
        System.out.println(wordDictionary.search("a.."));
    }
}
