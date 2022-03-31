package com.scd.contest.week237;

import java.util.HashSet;
import java.util.Set;

/**
 * @author James
 */
public class Code5734 {
    private static final Set<Character> characters = new HashSet<>();

    static {
        for (int i = 'a'; i < 'a' + 26; i++) {
            characters.add((char) i);
        }
    }

    public boolean checkIfPangram(String sentence) {
        char[] chars = sentence.toLowerCase().toCharArray();
        Set<Character> newCharSet = new HashSet<>(characters);
        for (char ch : chars) {
            newCharSet.remove(ch);
        }
        if (newCharSet.size() == 0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Code5734 code5734 = new Code5734();
        System.out.println(code5734.checkIfPangram("leetcode"));
    }
}
