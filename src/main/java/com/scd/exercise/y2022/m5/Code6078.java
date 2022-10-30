package com.scd.exercise.y2022.m5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author James
 */
public class Code6078 {

    public int rearrangeCharacters(String s, String target) {
        Map<Character, List<Integer>> charMap = new HashMap<>();
        int lens = s.length();
        for (int i = 0; i < lens; i++) {
            char curChar = s.charAt(i);
            List<Integer> indexList = charMap.computeIfAbsent(curChar, k -> new ArrayList<>());
            indexList.add(i);
        }
        int count = 0;
        while (true) {
            int lent = target.length();
            boolean isFind = true;
            for (int i = 0; i < lent; i++) {
                char curChar = target.charAt(i);
                List<Integer> indexList = charMap.get(curChar);
                if (indexList == null || indexList.size() == 0) {
                    isFind = false;
                    break;
                }
                indexList.remove(0);
            }
            if (!isFind) {
                break;
            }
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
//        "abbaccaddaeea"
//        "aaaaa"
        Code6078 code6078 = new Code6078();
        code6078.rearrangeCharacters("abbaccaddaeea", "aaaaa");
    }
}
