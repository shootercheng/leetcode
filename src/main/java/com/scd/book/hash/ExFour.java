package com.scd.book.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 快乐数
 * @author James
 */
public class ExFour {
    private static final Map<Integer, Integer> numMap = new HashMap<>(16);

    public boolean isHappy(int n) {
        while (n >= 2) {
            Integer val1 = numMap.get(n);
            if (val1 != null) {
                if (isCircle(numMap, val1)) {
                    return false;
                }
                n = val1;
            } else {
                int result = calHpNum(n);
                numMap.put(n, result);
                n = result;
            }
        }
        return n == 1;
    }

    private boolean isCircle(Map<Integer, Integer> numMap, Integer val1) {
        Integer res = numMap.get(val1);
        while (res != null) {
            if (res.intValue() == val1) {
                return true;
            }
            res = numMap.get(res);
        }
        return false;
    }

    private int calHpNum(int n) {
        int res = 0;
        while (n >= 10) {
            int mod = n % 10;
            n = n / 10;
            res = res + mod * mod;
        }
        res = res + n * n;
        return res;
    }

    public static void main(String[] args) {
        Integer num = Integer.MAX_VALUE;
        ExFour exFour = new ExFour();
        System.out.println(exFour.isHappy(6));
    }
}
