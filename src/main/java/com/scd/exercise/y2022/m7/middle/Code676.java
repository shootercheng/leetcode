package com.scd.exercise.y2022.m7.middle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author James
 */
public class Code676 {

    class MagicDictionary {
        private Map<Integer, List<String>> WORD_MAP;

        public MagicDictionary() {
            WORD_MAP = new HashMap<>();
        }

        public void buildDict(String[] dictionary) {
            for (String dict : dictionary) {
                List<String> wordList = WORD_MAP.computeIfAbsent(dict.length(), k -> new ArrayList<>());
                wordList.add(dict);
            }
        }

        public boolean search(String searchWord) {
            int lens = searchWord.length();
            List<String> wordList = WORD_MAP.get(lens);
            if (wordList == null) {
                return false;
            }
            for (String word : wordList) {
                int count = 0;
                for (int i = 0; i < lens; i++) {
                    if (searchWord.charAt(i) != word.charAt(i)) {
                        if (++count >= 2) {
                            break;
                        }
                    }
                }
                if (count == 1) {
                    return true;
                }
            }
            return false;
        }
    }

}
