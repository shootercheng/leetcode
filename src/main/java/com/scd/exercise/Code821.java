package com.scd.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * @author James
 */
public class Code821 {

    public int[] shortestToChar(String S, char C) {
        char[] scharArr = S.toCharArray();
        int slen = scharArr.length;
        List<Integer> indexList = new ArrayList<>();
        for (int i = 0; i < slen; i++) {
            if (scharArr[i] == C) {
                indexList.add(i);
            }
        }
        int[] result = new int[slen];
        for (int i = 0; i < slen; i++) {
            int min = findMin(i, indexList);
            result[i] = min;
        }
        return result;
    }

    private int findMin(int i, List<Integer> indexList) {
        int lenIndex = indexList.size();
        int min = Integer.MAX_VALUE;
        for (int j = 0; j < lenIndex; j++) {
            if (indexList.contains(i)) {
                return 0;
            }
            int s = Math.abs(i - indexList.get(j));
            if (s < min) {
                min = s;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        Code821 code821 = new Code821();
        int[] res = code821.shortestToChar("loveleetcode", 'e');
        System.out.println(res);
    }
}
