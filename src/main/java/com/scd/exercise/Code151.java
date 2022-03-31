package com.scd.exercise;

/**
 * @author James
 */
public class Code151 {

    public String reverseWords(String s) {
        if (s == null) {
            return s;
        }
        s = s.trim();
        if (s.length() == 0) {
            return s;
        }
        StringBuilder stringBuilder = new StringBuilder();
        char[] charArr = s.toCharArray();
        int loopStart = charArr.length - 1;
        int spaceIndex = 0;
        StringBuilder word = new StringBuilder();
        for (int i = loopStart; i >= 0; i--) {
            char curChar = charArr[i];
            if (curChar != ' ') {
                word.append(curChar);
            } else {
                if (word.length() > 0) {
                    stringBuilder.append(word.reverse());
                    stringBuilder.append(" ");
                    word.setLength(0);
                }
                spaceIndex = i;
            }
        }
        if (spaceIndex != 0) {
            stringBuilder.append(s,0, spaceIndex);
        } else {
            stringBuilder.append(word);
        }
        return stringBuilder.toString();
    }

    public String reverseWords2(String s) {
        if (s == null) {
            return s;
        }
        s = s.trim();
        if (s.length() == 0) {
            return s;
        }
        StringBuilder stringBuilder = new StringBuilder();
        String[] strArr = s.split("\\s+");
        int loopStart = strArr.length - 1;
        for (int i = loopStart; i >= 0; i--) {
            stringBuilder.append(strArr[i]).append(" ");
        }
        return stringBuilder.toString().trim();
    }

    public static void main(String[] args) {
        Code151 code151 = new Code151();
        System.out.println(code151.reverseWords2("the   sky is blue"));
        System.out.println(code151.reverseWords2(" hello world!"));
        System.out.println(code151.reverseWords2("a good  example"));
        System.out.println(code151.reverseWords2("a"));
    }
}
