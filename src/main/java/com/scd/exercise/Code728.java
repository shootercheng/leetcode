package com.scd.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * @author James
 */
public class Code728 {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> resultList = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (i > 0 && i < 10) {
                resultList.add(i);
            } else {
                if (isRightNum(i)) {
                    resultList.add(i);
                }
            }

        }
        return resultList;
    }

    private boolean isRightNum(int inputNum) {
        String inputStr = String.valueOf(inputNum);
        if (inputStr.contains("0")) {
            return false;
        }
        char[] charArr = inputStr.toCharArray();
        for (char c : charArr) {
            int num = c - 48;
            if (inputNum % num != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int n = 128;
        int result = n % 0;
        System.out.println(result);
    }
}
