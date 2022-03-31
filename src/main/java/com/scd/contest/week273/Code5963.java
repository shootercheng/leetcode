package com.scd.contest.week273;

/**
 * @author James
 */
public class Code5963 {

    public String reverseStr(String input) {
        StringBuilder stringBuilder = new StringBuilder(input).reverse();
        int notZeroIndex = -1;
        for (int i = 0; i < stringBuilder.length(); i++) {
            if (stringBuilder.charAt(i) != '0') {
                notZeroIndex = i;
                break;
            }
        }
        if (notZeroIndex == - 1) {
            return "0";
        }
        return stringBuilder.substring(notZeroIndex);
    }

    public boolean isSameAfterReversals(int num) {
        String originStr = String.valueOf(num);
        String result = reverseStr(reverseStr(originStr));
        return originStr.equals(result);
    }

    public static void main(String[] args) {
        Code5963 code5963 = new Code5963();
        int[] input = new int[]{526,1800,0};
        for (int i : input) {
            System.out.println(code5963.isSameAfterReversals(i));
        }
    }
}
