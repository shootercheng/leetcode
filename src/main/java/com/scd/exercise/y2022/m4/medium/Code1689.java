package com.scd.exercise.y2022.m4.medium;

/**
 * @author James
 */
public class Code1689 {

    public int minPartitions(String n) {
        int max = 0;
        char[] strArr = n.toCharArray();
        for (char ch : strArr) {
            int curNum = ch - 48;
            if (curNum > max) {
                max = curNum;
            }
        }
        return max;
    }
}
