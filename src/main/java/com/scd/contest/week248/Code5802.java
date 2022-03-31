package com.scd.contest.week248;

import java.util.HashMap;
import java.util.Map;

/**
 * @author James
 */
public class Code5802 {
    private static Map<Long, Long> goodNumMap = new HashMap<>();

    private static long max = 9;

    static {
        long count = 0;
        for (long i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                count++;
                goodNumMap.put(i, count);
            } else {
                long previous = goodNumMap.get(i - 1);
                goodNumMap.put(i, previous);
            }
        }
        System.out.println(goodNumMap);
    }

    private static int num = (int) Math.pow(10, 9) + 7;

    public int countGoodNumbers(long n) {
        n = calFacNumber(n) - 1;
        if (goodNumMap.containsKey(n)) {
            return (int) (goodNumMap.get(n) % num);
        }
        for (long i = max + 1; i <= n; i++) {
            long previous = goodNumMap.get(i - 1);
            if (isGoodNum(i)) {
                goodNumMap.put(i, previous + 1);
            } else {
                goodNumMap.put(i, previous);
            }
        }
        if (n > max) {
            max = n;
        }
        return (int) (goodNumMap.get(n) % num);
    }

    private boolean isGoodNum(long n) {
        char[] charArr = String.valueOf(n).toCharArray();
        int lenc = charArr.length;
        for (int i = 0; i < lenc; i++) {
            int curChar = charArr[i];
            if (i % 2 == 0) {
                if (curChar == '1' || curChar == '3' || curChar == '5'
                    || curChar == '7' || curChar == '9') {
                    return false;
                }
            } else {
                if (curChar != '1' && curChar != '3' && curChar != '5' && curChar != '7') {
                    return false;
                }
            }
        }
        return true;
    }

    public long calFacNumber(long n) {
        int result = 10;
        for (int i = 1; i < n; i++) {
            result = result * 10;
        }
        return result;
    }

    public static void main(String[] args) {
        Code5802 code5802 = new Code5802();
//        for (long i = 0; i < 100; i++) {
//            System.out.println(i + " " + code5802.isGoodNum(i));
//        }
        System.out.println(code5802.countGoodNumbers(50));
    }
}
