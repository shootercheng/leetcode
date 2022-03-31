package com.scd.exercise;

/**
 * @author James
 */
public class Code693 {

    public boolean hasAlternatingBits(int n) {
        String binStr = Integer.toBinaryString(n);
        char[] binCharArr = binStr.toCharArray();
        int loop = binCharArr.length - 1;
        for (int i = 0; i < loop; i++) {
            if (binCharArr[i] == binCharArr[i+1]) {
                return false;
            }
        }
        return true;
    }
}
