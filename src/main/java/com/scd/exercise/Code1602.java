package com.scd.exercise;

import java.util.HashMap;
import java.util.Map;

/**
 * @author James
 */
public class Code1602 {

    class WordsFrequency {
        private Map<String, Integer> countMap = new HashMap<>();

        public WordsFrequency(String[] book) {
            for (String s : book) {
                Integer count = countMap.computeIfAbsent(s, k -> 0);
                countMap.put(s, ++count);
            }
        }

        public int get(String word) {
            Integer count = countMap.get(word);
            if (count == null) {
                return 0;
            }
            return count;
        }
    }
}
