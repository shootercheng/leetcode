package com.scd.exercise;

/**
 * @author James
 */
public class Code1446 {

    public int maxPower(String s) {
        char[] scharArr = s.toCharArray();
        int slen = scharArr.length;
        int max = Integer.MIN_VALUE;
        int count = 1;
        char temp = scharArr[0];
        for (int i = 1; i < slen; i++) {
            if (scharArr[i] == temp) {
                count++;
            } else {
                temp = scharArr[i];
                if (count > max) {
                    max = count;
                }
                count = 1;
            }
        }
        return max;
    }
}
