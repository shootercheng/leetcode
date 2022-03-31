package com.scd.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author James
 */
public class Code1002 {

    public List<String> commonChars(String[] A) {
        int lena = A.length;
        String common = findCommon(A[0], A[1]);
        int minLen = common.length();
        String min = common;
        for (int i = 2; i < lena; i++) {
            common = findCommon(common, A[i]);
            if (common.length() < minLen) {
                minLen = common.length();
                min = common;
            }
        }
        List<String> result = new ArrayList<>();
        char[] minCharArr = min.toCharArray();
        for (char c : minCharArr) {
            result.add(String.valueOf(c));
        }
        return result;
    }

    private String findCommon(String str1, String str2) {
        char[] str1Arr = str1.toCharArray();
        char[] str2Arr = str2.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        int len1 = str1Arr.length;
        int len2 = str2Arr.length;
        boolean[] str1finds = new boolean[len1];
        boolean[] str2finds = new boolean[len2];
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                if (!str1finds[i] && !str2finds[j] && str1Arr[i] == str2Arr[j]) {
                    str1finds[i] = true;
                    str2finds[j] = true;
                    stringBuilder.append(str1Arr[i]);
                }
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String[] input = {"cool","lock","cook"};
        Code1002 code1002 = new Code1002();
        System.out.println(code1002.commonChars(input));
    }

}
