package com.scd.contest.week291;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author James
 */
public class Code6050 {

    public long appealSum(String s) {
        int lens = s.length();
        long result = 0;
        char[] sCharArr = s.toCharArray();
        for (int i = 0; i < lens; i++) {
            for (int j = i+1; j <= lens; j++) {
                String subStr = s.substring(i, j);
                System.out.println(subStr);
                Set<Character> set = new HashSet<>();
                for (int k = i; k < j; k++) {
                    set.add(sCharArr[k]);
                }
                System.out.println("_" + set);
                result = result + set.size();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Code6050 code6050 = new Code6050();
        code6050.appealSum("abcdefg");
    }
}
