package com.scd.exercise;

/**
 * @author James
 */
public class Code1323 {
    public int maximum69Number (int num) {
        String numStr = String.valueOf(num);
        char[] numCharArr = numStr.toCharArray();
        int len = numCharArr.length;
        for (int i = 0; i < len; i++) {
            if (numCharArr[i] == '6') {
                numCharArr[i] = '9';
                break;
            }
        }
        String result = new String(numCharArr);
        return Integer.parseInt(result);
    }
}
