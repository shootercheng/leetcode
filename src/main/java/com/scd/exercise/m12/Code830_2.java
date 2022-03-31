package com.scd.exercise.m12;

import java.util.ArrayList;
import java.util.List;

/**
 * @author James
 */
public class Code830_2 {

    public List<List<Integer>> largeGroupPositions(String s) {
        char[] sArr = s.toCharArray();
        int lens = sArr.length;
        List<List<Integer>> result = new ArrayList<>();
        if (lens <= 2) {
            return result;
        }
        int startIndex = 0;
        int endIndex = 1;
        while (endIndex < lens) {
            if (sArr[endIndex] == sArr[endIndex - 1]) {
                endIndex = endIndex + 1;
            } else {
                // abbxxxxzyy
                if (endIndex - startIndex >= 3) {
                    List<Integer> one = new ArrayList<>();
                    one.add(startIndex);
                    one.add(endIndex - 1);
                    result.add(one);
                }
                startIndex = endIndex;
                endIndex = endIndex + 1;
            }
        }
        if (endIndex - startIndex >= 3) {
            List<Integer> one = new ArrayList<>();
            one.add(startIndex);
            one.add(endIndex - 1);
            result.add(one);
        }
        return result;
    }
}
