package com.scd.exercise.y2022.m8.easy;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author James
 */
public class Code1374 {

    public String generateTheString(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n - 1; i++) {
            stringBuilder.append("a");
        }
        int mod = n % 2;
        if (mod == 0) {
            stringBuilder.append("b");
        } else {
            stringBuilder.append("a");
        }
        return stringBuilder.toString();
    }
}
