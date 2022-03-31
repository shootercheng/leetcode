package com.scd.contest.week246;

/**
 * @author James
 */
public class Code5788 {

    public String largestOddNumber(String num) {
        int len = num.length();
        char[] numArr = num.toCharArray();
        for (int i = len - 1; i >= 0; i--) {
            int curNum = Integer.valueOf(String.valueOf(numArr[i]));
            if (curNum % 2 == 1) {
                return num.substring(0, i+1);
            }
        }
        return "";
    }

    public static void main(String[] args) {
        Code5788 code5788 = new Code5788();
        System.out.println(code5788.largestOddNumber("122222"));
    }
}
