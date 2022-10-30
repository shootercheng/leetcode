package com.scd.exercise.y2022.m5;

/**
 * @author James
 */
public class Code6065 {

    public String largestGoodInteger(String num) {
        char[] numArr = num.toCharArray();
        int count = 1;
        int maxNum = Integer.MIN_VALUE;
        String maxStr = "";
        int lenn = numArr.length;
        char start = numArr[0];
        for (int i = 1; i < lenn; i++) {
            char curChar = numArr[i];
            if (start == curChar) {
                count++;
            } else {
                if (count >= 3) {
                    String strNum = new String(new char[]{start, start, start});
                    int curNum = Integer.parseInt(strNum);
                    if (curNum > maxNum) {
                        maxNum = curNum;
                        maxStr = strNum;
                    }
                }
                start = curChar;
                count = 1;
            }
        }
        if (count >= 3) {
            String strNum = new String(new char[]{start, start, start});
            int curNum = Integer.parseInt(strNum);
            if (curNum > maxNum) {
                maxStr = strNum;
            }
        }
        return maxStr;
    }

    public static void main(String[] args) {
        Code6065 code6065 = new Code6065();
        code6065.largestGoodInteger("6777133339");
    }
}
