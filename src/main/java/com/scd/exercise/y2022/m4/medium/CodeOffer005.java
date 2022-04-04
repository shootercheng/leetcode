package com.scd.exercise.y2022.m4.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author James
 */
public class CodeOffer005 {

    public int maxProduct(String[] words) {
        int lenw = words.length;
        List<Set<Character>> listSet = new ArrayList<>(lenw);
        for (String word : words) {
            char[] wcharArr = word.toCharArray();
            Set<Character> set = new HashSet<>();
            for (char ch : wcharArr) {
                set.add(ch);
            }
            listSet.add(set);
        }
        int maxLen = 0;
        for (int i = 0; i < lenw; i++) {
            for (int j = 0; j < lenw; j++) {
                if (i != j) {
                    Set<Character> seti = listSet.get(i);
                    Set<Character> setj = listSet.get(j);
                    boolean hasSame = false;
                    for (Character character : seti) {
                        if (setj.contains(character)) {
                            hasSame = true;
                            break;
                        }
                    }
                    if (!hasSame) {
                        int curLen = words[i].length() * words[j].length();
                        if (curLen > maxLen) {
                            maxLen = curLen;
                        }
                    }
                }
            }
        }
        return maxLen;
    }
}
