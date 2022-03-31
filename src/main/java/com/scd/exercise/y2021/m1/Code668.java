package com.scd.exercise.y2021.m1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author James
 */
public class Code668 {

    public int findKthNumber(int m, int n, int k) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                result.add(i*j);
            }
        }
        result = result.stream().sorted().collect(Collectors.toList());
        return result.get(k - 1);
    }
}
