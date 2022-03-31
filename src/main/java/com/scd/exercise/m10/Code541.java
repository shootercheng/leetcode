package com.scd.exercise.m10;

/**
 * @author James
 */
public class Code541 {

    public String reverseStr(String s, int k) {
        int startIndex = 0;
        int sIndex = s.length();
        StringBuilder result = new StringBuilder();
        int len2k = 2*k;
        while (startIndex <= sIndex - len2k) {
            String temp = s.substring(startIndex, startIndex + len2k);
            addReverseTemp(result, temp, k);
            startIndex = startIndex + len2k;
        }
        int left = sIndex - startIndex;
        if (left > 0) {
            if (left > k) {
                String temp = s.substring(startIndex, startIndex + k);
                addReverseTemp(result, temp);
                temp = s.substring(startIndex+k);
                char[] tempArr = temp.toCharArray();
                for (char c : tempArr) {
                    result.append(c);
                }
            } else {
                String temp = s.substring(startIndex);
                addReverseTemp(result, temp);
            }
        }
        return result.toString();
    }

    public void addReverseTemp(StringBuilder result, String temp, int k) {
        char[] tempArr = temp.toCharArray();
        int lent = tempArr.length;
        for (int i = lent - 1 - k; i >= 0; i--) {
            result.append(tempArr[i]);
        }
        for (int i = lent - k; i < lent; i++) {
            result.append(tempArr[i]);
        }
    }

    public void addReverseTemp(StringBuilder result, String temp) {
        char[] tempArr = temp.toCharArray();
        int lent = tempArr.length;
        for (int i = lent - 1; i >= 0; i--) {
            result.append(tempArr[i]);
        }
    }

    public static void main(String[] args) {
        String s1 = "abcdefg";
        Code541 code541 = new Code541();
        System.out.println(code541.reverseStr(s1, 2));
    }
}
