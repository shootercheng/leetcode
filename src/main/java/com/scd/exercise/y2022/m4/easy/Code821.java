package com.scd.exercise.y2022.m4.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author James
 */
public class Code821 {

    public int[] shortestToChar(String s, char c) {
        int lens = s.length();
        int[] result = new int[lens];
        char[] scharArr = s.toCharArray();
        List<Integer> indexC = new ArrayList<>();
        List<Integer> indexNotC = new ArrayList<>();
        for (int i = 0; i < lens; i++) {
            if (scharArr[i] == c) {
                indexC.add(i);
            } else {
                indexNotC.add(i);
            }
        }
        for (Integer index : indexNotC) {
            int min = Integer.MAX_VALUE;
            for (Integer cIndex : indexC) {
                int abs = Math.abs(index - cIndex);
                if (abs < min) {
                    min = abs;
                }
            }
            result[index] = min;
        }
        return result;
    }

    public static void main(String[] args) {
//        "loveleetcode"
//        "e"
        Code821 code821 = new Code821();
        code821.shortestToChar("loveleetcode", 'e');
    }
}
