package com.scd.exercise;

import java.util.List;

/**
 * @author James
 */
public class Code139 {

    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) {
            return true;
        }
        for (String word : wordDict) {
            if (!s.contains(word)) {
                return false;
            }
            s = s.replace(word, "");
        }
        if (s.length() == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {

    }
}
