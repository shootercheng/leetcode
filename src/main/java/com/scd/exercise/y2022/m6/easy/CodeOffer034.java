package com.scd.exercise.y2022.m6.easy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 剑指 Offer II 034. 外星语言是否排序
 * @author James
 */
public class CodeOffer034 {

    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> charMap = new HashMap<>();
        int leno = order.length();
        for (int i = 0; i < leno; i++) {
            charMap.put(order.charAt(i), i);
        }
        String temp = null;
        for (String word : words) {
            if (temp != null) {
                char[] tArr = temp.toCharArray();
                char[] wArr = word.toCharArray();
                int i = 0;
                int j = 0;
                boolean isOrder = false;
                for (; i < tArr.length && j < wArr.length; i++,j++) {
                    Integer tNum = charMap.get(tArr[i]);
                    Integer wNum = charMap.get(wArr[j]);
                    if (tNum < wNum) {
                        isOrder = true;
                        break;
                    } else if (tNum > wNum) {
                        return false;
                    }
                }
                if (!isOrder) {
                    if (tArr.length > wArr.length) {
                        return false;
                    }
                }
            }
            temp = word;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] words = {"word","world","row"};
        CodeOffer034 codeOffer034 = new CodeOffer034();
        codeOffer034.isAlienSorted(words, "worldabcefghijkmnpqstuvxyz");
    }
}
