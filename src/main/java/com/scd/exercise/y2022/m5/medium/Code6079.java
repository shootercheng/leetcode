package com.scd.exercise.y2022.m5.medium;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author James
 */
public class Code6079 {

    public String discountPrices(String sentence, int discount) {
        String[] sArr = sentence.split("\\s+");
        StringBuilder result = new StringBuilder();
        for (String word : sArr) {
            if (word.startsWith("$") && word.length() > 1) {
                String res = calDiscount(word, discount);
                result.append(res);
            } else {
                result.append(word);
            }
            result.append(" ");
        }
        String temp = result.toString();
        return temp.trim();
    }

    private String calDiscount(String word, int discount) {
        int lenw = word.length();
        boolean isAllNum = true;
        StringBuilder num = new StringBuilder();
        for (int i = 1; i < lenw; i++) {
            char curChar = word.charAt(i);
            if (!Character.isDigit(curChar)) {
                isAllNum = false;
            } else {
                num.append(curChar);
            }
        }
        if (isAllNum && num.length() > 0) {
            BigDecimal bigDecimal = new BigDecimal(num.toString());
            BigDecimal val = bigDecimal.multiply(new BigDecimal(100- discount));
            BigDecimal hun = new BigDecimal(100);
            BigDecimal res = val.divide(hun, 2, RoundingMode.CEILING);
            return "$" + res;
        }
        return word;
    }

    public static void main(String[] args) {
//        "$76111 ab $6 $"
//        48
        Code6079 code6079 = new Code6079();
        code6079.discountPrices("$76111 ab $6 $", 48);
    }
}
