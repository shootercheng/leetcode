package com.scd.exercise.y2022.m5;

/**
 * @author James
 */
public class Code2042 {

    public boolean areNumbersAscending(String s) {
        String[] sArr = s.split("\\s+");
        Integer num = null;
        for (String word : sArr) {
            char[] wcharArr = word.toCharArray();
            boolean isNumber = true;
            for (char ch : wcharArr) {
                if (!Character.isDigit(ch)) {
                    isNumber = false;
                    break;
                }
            }
            if (isNumber) {
                int curNum = Integer.parseInt(word);
                if (num == null) {
                    num = curNum;
                } else {
                    if (num >= curNum) {
                        return false;
                    }
                    num = curNum;
                }
            }
        }
        return true;
    }
}
