package com.scd.exercise.y2021.m7;

import java.util.Arrays;

/**
 * @author James
 */
public class Code274 {

    public int hIndex(int[] citations) {
        int lenc = citations.length;
        Arrays.sort(citations);
        int maxNum = 0;
        for (int i = 0; i < lenc; i++) {
            int cal = lenc - i;
            int curNum = citations[i];
            if (curNum >= maxNum && cal >= curNum) {
                maxNum = curNum;
            }
        }
        return maxNum;
    }

    public static void main(String[] args) {
        int[] citations = new int[]{3,0,6,1,5};
        Code274 code274 = new Code274();
        System.out.println(code274.hIndex(citations));
    }
}
