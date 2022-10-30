package com.scd.exercise.y2022.m8.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @author James
 */
public class Code2269 {

    public int divisorSubstrings(int num, int k) {
        String numStr = String.valueOf(num);
        int lenn = numStr.length();
        int count = 0;
        for (int i = 0; i <= lenn - k; i++) {
            String curStr = numStr.substring(i, i+k);
            int curNum = Integer.parseInt(curStr);
            if (curNum == 0) {
                continue;
            }
            if (num % curNum == 0) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Code2269 code2269 = new Code2269();
        code2269.divisorSubstrings(430043, 2);
    }
}
