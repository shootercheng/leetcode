package com.scd.exercise;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * @author James
 */
public class Code1018 {

    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> result = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        BigInteger five = new BigInteger("5");
        BigInteger zero = new BigInteger("0");
        for (int i : A) {
            stringBuilder.append(i);
            BigInteger num = new BigInteger(stringBuilder.toString(), 2);
            if (num.mod(five).compareTo(zero) == 0) {
                result.add(true);
            } else {
                result.add(false);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = {1,0,0,1,0,1,0,0,1,0,1,1,1,1,1,1,1,1,1,1,0,0,0,0,1,0,1,0,0,0,0,1,1,0,1,0,0,0,1};
        Code1018 code1018 = new Code1018();
        System.out.println(code1018.prefixesDivBy5(a));
    }
}
