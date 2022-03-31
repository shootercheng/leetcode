package com.scd.contest.week242;

import java.util.HashMap;
import java.util.Map;

/**
 * @author James
 */
public class Code5763 {

    public boolean checkZeroOnes(String s) {
        char[] sCharArr = s.toCharArray();
        int lens = sCharArr.length;
        int zeroMax = 0;
        int oneMax = 0;
        int zeroCount = 0;
        int oneCount = 0;
        for (int i = 0; i < lens; i++) {
            if (sCharArr[i] == '0') {
                zeroCount++;
                if (oneCount > oneMax) {
                    oneMax = oneCount;
                }
                oneCount = 0;
            } else if (sCharArr[i] == '1') {
                oneCount++;
                if (zeroCount > zeroMax) {
                    zeroMax = zeroCount;
                }
                zeroCount = 0;
            }
        }
        if (oneCount > oneMax) {
            oneMax = oneCount;
        }
        if (zeroCount > zeroMax) {
            zeroMax = zeroCount;
        }
        return oneMax > zeroMax;
    }

    public static void main(String[] args) {
        Code5763 code5673 = new Code5763();
//        System.out.println(code5673.checkZeroOnes("1101"));
        System.out.println(code5673.checkZeroOnes("111000"));
    }
}
