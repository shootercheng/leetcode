package com.scd.contest.week291;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author James
 */
public class Code6074 {

    public String removeDigit(String number, char digit) {
        char[] charArr = number.toCharArray();
        int lenc = charArr.length;
        Set<Integer> digSet = new HashSet<>();
        for (int i = lenc - 1; i >= 0; i--) {
            if (charArr[i] == digit) {
                digSet.add(i);
            }
        }
        String maxStr = "";
        BigInteger maxBig = BigInteger.ZERO;
        for (Integer index : digSet) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < lenc; i++) {
                if (i != index) {
                    stringBuilder.append(charArr[i]);
                }
            }
            String curStr = stringBuilder.toString();
            BigInteger curInt = new BigInteger(curStr);
            if (curInt.compareTo(maxBig) >  0) {
                maxBig = curInt;
                maxStr = curStr;
            }
        }
        return maxStr;
    }
}
