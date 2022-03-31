package com.scd.exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author James
 */
public class Code977 {

    public int[] sortedSquares(int[] A) {
        List<Integer> result = new ArrayList<>();
        for (int i : A) {
            result.add(i*i);
        }
        result = result.stream().sorted().collect(Collectors.toList());
        int size = result.size();
        int[] resArr = new int[size];
        for (int i = 0; i < size; i++) {
            resArr[i] = result.get(i);
        }
        return resArr;
    }
}
