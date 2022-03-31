package com.scd.exercise;

/**
 * @author James
 */
public class Code14 {

    public String longesetCommonPrefixStr(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int shortestIndex = findShortestStr(strs);
        String shortStr = strs[shortestIndex];
        int len = shortStr.length();
        int arrLen = strs.length;
        String result = "";
        for (int i = 1; i <= len; i++) {
            boolean isNotSame = false;
            result = shortStr.substring(0, i);
            for (int j = 0; j < arrLen; j++) {
                if (j == shortestIndex) {
                    continue;
                }
                if (!strs[j].startsWith(result)) {
                    result = shortStr.substring(0, i-1);
                    isNotSame = true;
                    break;
                }
            }
            if (isNotSame) {
                break;
            }
        }
        return result;
    }

    private int findShortestStr(String[] strs) {
        int min = Integer.MAX_VALUE;
        int index = 0;
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length() < min) {
                min = strs[i].length();
                index = i;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"cat","dc1at123","cat123456"};
        Code14 code14 = new Code14();
        System.out.println(code14.longesetCommonPrefixStr(strs));
    }
}
