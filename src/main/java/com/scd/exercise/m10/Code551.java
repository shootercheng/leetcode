package com.scd.exercise.m10;

/**
 * @author James
 */
public class Code551 {

    public boolean checkRecord(String s) {
        char[] sArr = s.toCharArray();
        int atime = 0;
        int ltime = 0;
        int ltemp = 0;
        for (int i = 0; i < sArr.length; i++) {
            if (sArr[i] == 'A') {
                atime++;
            }
            if (sArr[i] == 'L') {
                ltemp++;
                if (ltemp > ltime) {
                    ltime = ltemp;
                }
            } else {
                ltemp = 0;
            }
        }
        if (atime <= 1 && ltime <= 2) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String input = "PPALLLP";
        Code551 code551 = new Code551();
        System.out.println(code551.checkRecord(input));
    }
}
