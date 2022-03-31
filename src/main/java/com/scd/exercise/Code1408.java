package com.scd.exercise;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author James
 */
public class Code1408 {

    public List<String> stringMatching(String[] words) {
        List<String> result = new ArrayList<>();
        Set<Integer> indexSet = new HashSet<>();
        int len = words.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (i != j && words[i].contains(words[j])) {
                    if (!indexSet.contains(j)) {
                        indexSet.add(j);
                        result.add(words[j]);
                    }
                }
            }
        }
        return result;
    }
}
