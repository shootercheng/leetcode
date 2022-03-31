package com.scd.exercise;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * @author James
 */
public class Code989 {

    public List<Integer> addToArrayForm(int[] A, int K) {
        StringBuilder builder = new StringBuilder();
        for (int i : A) {
            builder.append(i);
        }
        BigInteger abigInt = new BigInteger(builder.toString());
        BigInteger kbigInt = new BigInteger(String.valueOf(K));
        BigInteger sumBig = abigInt.add(kbigInt);
        char[] charArr = sumBig.toString().toCharArray();
        List<Integer> result = new ArrayList<>();
        for (char c : charArr) {
            int num = c - '0';
            result.add(num);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] A = {9,9,9,9,9,9,9,9,9,9};
        Code989 code989 = new Code989();
        System.out.println(code989.addToArrayForm(A, 999999));
    }
}
