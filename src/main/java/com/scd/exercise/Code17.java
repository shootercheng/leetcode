package com.scd.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author James
 */
public class Code17 {

    private static Map<Character, List<String>> INT_LETTER_MAP = new HashMap<>();

    static {
        INT_LETTER_MAP.put('0', new ArrayList<>());
        INT_LETTER_MAP.put('1', new ArrayList<>());
        INT_LETTER_MAP.put('2', Arrays.asList("a", "b", "c"));
        INT_LETTER_MAP.put('3', Arrays.asList("d", "e", "f"));
        INT_LETTER_MAP.put('4', Arrays.asList("g", "h", "i"));
        INT_LETTER_MAP.put('5', Arrays.asList("j", "k", "l"));
        INT_LETTER_MAP.put('6', Arrays.asList("m", "n", "o"));
        INT_LETTER_MAP.put('7', Arrays.asList("p", "q", "r", "s"));
        INT_LETTER_MAP.put('8', Arrays.asList("t", "u", "v"));
        INT_LETTER_MAP.put('9', Arrays.asList("w", "x", "y", "z"));
        INT_LETTER_MAP.put('*', new ArrayList<>());
        INT_LETTER_MAP.put('#', new ArrayList<>());
    }

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0 || digits.contains("0")) {
            return new ArrayList<>();
        }
        char[] charArr = digits.toCharArray();
        int arrLen = charArr.length;
        List<String> firstList = INT_LETTER_MAP.get(charArr[0]);
        if (arrLen == 1) {
            return firstList;
        }
        List<String> secondList = INT_LETTER_MAP.get(charArr[1]);
        List<String> resultList = combineTwoList(firstList, secondList);
        for (int i = 2; i < arrLen; i++) {
            List<String> curList = INT_LETTER_MAP.get(charArr[i]);
            resultList = combineTwoList(curList, resultList);

        }
        return resultList;
    }

    private List<String> combineTwoList(List<String> firstList, List<String> secondList) {
        int firstLen = firstList.size();
        int secondLen = secondList.size();
        List<String> resultList = new ArrayList<>(firstLen + secondLen);
        if (firstLen == 0 && secondLen == 0) {
            return resultList;
        } else if (firstLen == 0) {
            return secondList;
        } else if (secondLen == 0) {
            return firstList;
        } else {
            for (int i = 0; i < firstLen; i++) {
                for (int j = 0; j < secondLen; j++) {
                    String combine = firstList.get(i) + secondList.get(j);
                    resultList.add(combine);
                }
            }
        }
        return resultList;
    }

    public static void main(String[] args) {
        Code17 code17 = new Code17();
        List<String> resultList = code17.letterCombinations("*2");
        System.out.println(resultList);
    }
}
