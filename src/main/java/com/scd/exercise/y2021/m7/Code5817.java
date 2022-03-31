package com.scd.exercise.y2021.m7;

import java.util.HashMap;
import java.util.Map;

/**
 * @author James
 */
public class Code5817 {

    public boolean isDecomposable(String s) {
        char[] chars = s.toCharArray();
        int lenc = chars.length;
        int startIndex = 0;
        int moveIndex = 1;
        int countNum2 = 0;
        while (moveIndex < lenc) {
            int dis = moveIndex - startIndex;
            if (dis == 3) {
                startIndex = moveIndex;
            }
            if (chars[startIndex] != chars[moveIndex]) {
                if (dis == 2 || dis == 3) {
                    if (dis == 2) {
                        countNum2++;
                    }
                    startIndex = moveIndex;
                } else {
                    return false;
                }
            }
            moveIndex++;
        }
        int dis = moveIndex - startIndex;
        if (dis == 2 || dis == 3) {
            if (dis == 2) {
                countNum2++;
            }
        } else {
            return false;
        }
        return countNum2 == 1;
    }

    public static void main(String[] args) {
        Code5817 code5817 = new Code5817();
        System.out.println(code5817.isDecomposable("1110"));
    }
}
