package com.scd.exercise.m12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author James
 */
public class Code89 {

    public List<Integer> grayCode(int n) {
        if (n == 0) {
            return Arrays.asList(0);
        }
        List<Integer> result = new ArrayList<>();
        for (int i = n; i >= 0; i--) {
            String binaryStr = createBinaryStr(i, n - i);
            result.add(Integer.parseInt(binaryStr, 2));
        }
        for (int i = n - 1; i > 0; i--) {
            String reverseStr = createBinaryReverseStr(i, n - i);
            result.add(Integer.parseInt(reverseStr, 2));
        }
        return result;
    }

    public String createBinaryStr(int zero, int one) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < zero; i++) {
            builder.append("0");
        }
        for (int i = 0; i < one; i++) {
            builder.append("1");
        }
        return builder.toString();
    }

    public String createBinaryReverseStr(int one, int zero) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < one; i++) {
            builder.append("1");
        }
        for (int i = 0; i < zero; i++) {
            builder.append("0");
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Code89 code89 = new Code89();
        System.out.println(code89.grayCode(2));
    }
}
