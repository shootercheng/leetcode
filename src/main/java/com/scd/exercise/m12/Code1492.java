package com.scd.exercise.m12;

import java.util.ArrayList;
import java.util.List;

/**
 * @author James
 */
public class Code1492 {

    public int kthFactor(int n, int k) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                result.add(i);
            }
        }
        if (k > result.size()) {
            return -1;
        }
        return result.get(k - 1);
    }
}
