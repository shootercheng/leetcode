package com.scd.exercise.m12;

import java.util.HashMap;
import java.util.Map;

/**
 * @author James
 */
public class Code67 {

    public String addBinary(String a, String b) {
        int lena = a.length();
        int lenb = b.length();
        Map<Integer, Character> aIndexMap = getIndexMap(a);
        Map<Integer, Character> bIndexMap = getIndexMap(b);
        if (lena > lenb) {
            return addTwoMap(aIndexMap, bIndexMap, lenb);
        } else {
            return addTwoMap(bIndexMap, aIndexMap, lena);
        }
    }

    private String addTwoMap(Map<Integer, Character> aIndexMap, Map<Integer, Character> bIndexMap,
                             int minLen) {
        for (int i = 0; i < minLen; i++) {
            Character aChar = aIndexMap.get(i);
            Character bChar = bIndexMap.get(i);
            // 进位
            if (aChar == '1' && bChar == '1') {
                aIndexMap.put(i, '0');
                Character next = aIndexMap.get(i+1);
                if (next == null) {
                    aIndexMap.put(i+1, '1');
                } else {
                    // next 数据是否需要进位
                    addPreNum(aIndexMap, i+1);
                }
            } else if (aChar == '0' && bChar == '0') {
                aIndexMap.put(i, '0');
            } else {
                aIndexMap.put(i, '1');
            }
        }
        int size = aIndexMap.size();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = size - 1; i >= 0; i--) {
            stringBuilder.append(aIndexMap.get(i));
        }
        return stringBuilder.toString();
    }

    private void addPreNum(Map<Integer, Character> aIndexMap, int startIndex) {
        while (true) {
            Character curChar = aIndexMap.get(startIndex);
            if (curChar == null) {
                aIndexMap.put(startIndex, '1');
                break;
            } else if (curChar == '1') {
                aIndexMap.put(startIndex, '0');
                startIndex = startIndex + 1;
            } else {
                aIndexMap.put(startIndex, '1');
                break;
            }
        }
    }

    private Map<Integer, Character> getIndexMap(String inputStr) {
        char[] charArr = inputStr.toCharArray();
        int lenc = charArr.length;
        Map<Integer, Character> indexMap = new HashMap<>();
        int j = 0;
        for (int i = lenc - 1; i >= 0; i--) {
            indexMap.put(j++, charArr[i]);
        }
        return indexMap;
    }

    public static void main(String[] args) {
        Code67 code67 = new Code67();
        System.out.println(code67.addBinary("1", "111"));
    }
}
