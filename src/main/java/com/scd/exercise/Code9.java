package com.scd.exercise;

/**
 * @author James
 */
public class Code9 {

    public static void main(String[] args) {
        int x = 112;
        String str = String.valueOf(x);
        char[] charArr = str.toCharArray();
        int center = charArr.length / 2;
        boolean isOk = true;
        if (center == 0) {
            isOk = true;
        }
        int i = 0;
        int j = charArr.length - 1;
        while (i < center) {
            if (charArr[i++] != charArr[j--]) {
                isOk = false;
                break;
            }
        }
        System.out.println(isOk);
    }
}
